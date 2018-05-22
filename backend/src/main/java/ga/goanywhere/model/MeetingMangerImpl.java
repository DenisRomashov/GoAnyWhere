package ga.goanywhere.model;

import ga.goanywhere.entities.*;
import ga.goanywhere.dbutils.SessionFactoryUtil;
import ga.goanywhere.exceptions.NotEnoughPrivilegesException;
import ga.goanywhere.exceptions.TooManyParticipantsException;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class MeetingMangerImpl implements MeetingManger {
    private final static Logger log = LogManager.getLogger(MeetingMangerImpl.class);
    private final static String CREATOR_PRIVILEGE = "creator";
    private Session currentSession;
    private int methodsDepth;

    private Session getCurrentSession(){
        if (currentSession == null) {
            methodsDepth = 0;
            currentSession = SessionFactoryUtil.getSession();
        }
        methodsDepth++;
        return currentSession;
    }

    private void closeCurrentSession(){
        if (methodsDepth == 1) {
            currentSession.close();
            currentSession = null;
        }
        methodsDepth--;
    }

    @Override
    public Long createOrUpdateMeeting(final Long id, final Long creatorId, final Long categoryId,
                              final Long addressId, final String name, final String startTime,
                              final String endTime, final String description, final Long maxParticipants,
                              final Long minAge, final byte[] attachment) throws ParseException {
        log.info("Creating new meeting by user with id = {}", creatorId);
        Session session = getCurrentSession();
        try {
            MeetingEntity meetingEntity;
            if (id == null)
                meetingEntity = new MeetingEntity();
            else
                meetingEntity = (MeetingEntity) session.get(MeetingEntity.class, id);
            meetingEntity.setCategoryId(categoryId);
            meetingEntity.setMeetingAddress((AddressEntity) session.get(AddressEntity.class, addressId));
            meetingEntity.setName(name);

            meetingEntity.setStartTime(new Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
                    .parse(startTime).getTime()));
            meetingEntity.setEndTime(new Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
                    .parse(endTime).getTime()));

            meetingEntity.setDescription(description);
            meetingEntity.setMaxParticipants(maxParticipants);
            meetingEntity.setMinAge(minAge);
            meetingEntity.setAttachment(attachment);

            UserEntity creator = (UserEntity) session.get(UserEntity.class, creatorId);

            session.save(meetingEntity);
            if (id == null) applyMeeting(creator, meetingEntity, CREATOR_PRIVILEGE);

            session.flush();
            return meetingEntity.getId();

        } finally {
            closeCurrentSession();
        }
    }

    @Override
    public void applyMeeting(final Long userId, final Long meetingId, final String privilege) {
        log.info("Applying user with id = {} to meeting with id = {}", userId, meetingId);
        Session session = getCurrentSession();
        try {
            UserEntity user = (UserEntity) session.get(UserEntity.class, userId);
            MeetingEntity meeting = (MeetingEntity) session.get(MeetingEntity.class, meetingId);

            applyMeeting(user, meeting, privilege);

            session.flush();
        } finally {
            closeCurrentSession();
        }
    }

    private final Object applyMeetingLock = new Object();

    private void applyMeeting(final UserEntity user, final MeetingEntity meeting, final String privilege) {
        log.info("Find or create privilege {}", privilege);
        Session session = getCurrentSession();
        try {
            PrivilegeEntity privilegeEntity;
            synchronized (applyMeetingLock) {
                privilegeEntity = (PrivilegeEntity) session.createQuery("from PrivilegeEntity where type = :privilege")
                        .setString("privilege", privilege).uniqueResult();

                if (privilegeEntity == null) {
                    log.info("Creating new privilege");
                    privilegeEntity = new PrivilegeEntity();
                    privilegeEntity.setType(privilege);
                    session.save(privilegeEntity);
                }
            }

            synchronized (applyMeetingLock) {
                if (meeting.getParticipants() == null ||
                        meeting.getParticipants().size() < meeting.getMaxParticipants()) {
                    UserMeetingEntity userMeeting = new UserMeetingEntity();
                    userMeeting.setUserMeetingPK(new UserMeetingEntity.UserMeetingPK(user, meeting));
                    userMeeting.setPrivilegeId(privilegeEntity.getId());
                    session.save(userMeeting);
                    session.flush();
                }
                else
                    throw new TooManyParticipantsException();
            }
        } finally {
            closeCurrentSession();
        }
    }

    private final Object exitMeetingLock = new Object();

    @Override
    public void exitMeeting(final Long userId, final Long meetingId) {
        log.info("User with id = {} exit meeting with id = {}", userId, meetingId);
        Session session = getCurrentSession();
        try {
            UserEntity user = (UserEntity) session.get(UserEntity.class, userId);
            MeetingEntity meeting = (MeetingEntity) session.get(MeetingEntity.class, meetingId);
            UserMeetingEntity userMeeting = (UserMeetingEntity) session.get
                    (UserMeetingEntity.class, new UserMeetingEntity.UserMeetingPK(user, meeting));
            PrivilegeEntity privilege = (PrivilegeEntity) session.get
                    (PrivilegeEntity.class, userMeeting.getPrivilegeId());

            session.delete(userMeeting);

            if (privilege.getType().equals("creator")) {
                log.info("This user is creator, finding other participants");
                Query query = session.createQuery("from UserMeetingEntity where meeting_id = :meetingId")
                        .setParameter("meetingId", meetingId);
                query.setFirstResult(0);
                query.setMaxResults(2);
                synchronized (exitMeetingLock) {
                    List<UserMeetingEntity> meetingFirstParticipant = query.list();
                    if (meetingFirstParticipant.size() == 1) {
                        log.info("No other participants, delete meeting");
                        deleteMeeting(BigInteger.ZERO.longValue(), meetingId);
                    } else {
                        for (UserMeetingEntity participant : meetingFirstParticipant) {
                            if (participant != userMeeting) {
                                participant.setPrivilegeId(privilege.getId());
                                session.save(participant);
                                break;
                            }
                        }
                    }
                }
            }

            session.flush();
        } finally {
            closeCurrentSession();
        }
    }

    @Override
    public void deleteMeeting(final Long userId, final Long meetingId) {
        log.info("Deleting meeting with id = {} by usr with id = {}", meetingId, userId);
        Session session = getCurrentSession();
        try {
            MeetingEntity meeting = (MeetingEntity) session.get(MeetingEntity.class, meetingId);

            if (userId != BigInteger.ZERO.longValue()) {
                UserEntity user = (UserEntity) session.get(UserEntity.class, userId);
                UserMeetingEntity userMeeting = (UserMeetingEntity)
                        session.get(UserMeetingEntity.class, new UserMeetingEntity.UserMeetingPK(user, meeting));
                PrivilegeEntity privilegeEntity = (PrivilegeEntity)
                        session.get(PrivilegeEntity.class, userMeeting.getPrivilegeId());

                if (!privilegeEntity.getType().equals(CREATOR_PRIVILEGE)) {
                    throw new NotEnoughPrivilegesException("User with id = " + userId +
                            " can't delete meeting with id = " + meetingId);
                }
            }

            session.delete(meeting);
            session.flush();
        }finally {
            closeCurrentSession();
        }
    }

    @Override
    public List<UserEntity> getMeetingParticipants(final Long meetingId) {
        Session session = SessionFactoryUtil.getSession();
        try {
            MeetingEntity meeting = (MeetingEntity) session.get(MeetingEntity.class, meetingId);
            List<UserEntity> participants = new ArrayList<>();
            meeting.getParticipants().forEach((participant) ->
                    participants.add(participant.getUserMeetingPK().getParticipant()));
            return participants;
        } finally {
            session.close();
        }
    }

    @Override
    public List<CategoryEntity> getCategories(){
        Session session = SessionFactoryUtil.getSession();
        try {
            return session.createQuery("from CategoryEntity").list();
        } finally {
            session.close();
        }
    }
}
