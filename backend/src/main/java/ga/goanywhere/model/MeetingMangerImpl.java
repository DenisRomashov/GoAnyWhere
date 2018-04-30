package ga.goanywhere.model;

import ga.goanywhere.entities.*;
import ga.goanywhere.dbutils.SessionFactoryUtil;
import ga.goanywhere.exceptions.NotEnoughPrivilegesException;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class MeetingMangerImpl implements MeetingManger {
    private final static Logger log = LogManager.getLogger(MeetingMangerImpl.class);
    private final static String CREATOR_PRIVILEGE = "creator";

    @Override
    public Long createMeeting(final Long id, final Long creatorId, final Long categoryId,
                              final Long addressId, final String name, final Long startTime,
                              final Long endTime, final String description, final Long maxParticipants,
                              final Long minAge, final byte[] attachment) {
        Session session = SessionFactoryUtil.getSession();
        try {
            log.info("Creating new meeting by user with id = {}", creatorId);
            MeetingEntity meetingEntity;
            boolean b = true;
            if (id == null) {
                meetingEntity = new MeetingEntity();
            } else {
                meetingEntity = (MeetingEntity) session.get(MeetingEntity.class, id);
                b = false;
            }
            meetingEntity.setCategoryId(categoryId);
            meetingEntity.setMeetingAddress((AddressEntity) session.get(AddressEntity.class, addressId));
            meetingEntity.setName(name);
            meetingEntity.setStartTime(new Timestamp(startTime));
            meetingEntity.setEndTime(new Timestamp(endTime));
            meetingEntity.setDescription(description);
            meetingEntity.setMaxParticipants(maxParticipants);
            meetingEntity.setMinAge(minAge);
            meetingEntity.setAttachment(attachment);
            session.saveOrUpdate(meetingEntity);
            session.flush();
            if (b) applyMeeting(creatorId, meetingEntity.getId(), CREATOR_PRIVILEGE);
            return meetingEntity.getId();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteMeeting(final Long userId, final Long meetingId) {
        Session session = SessionFactoryUtil.getSession();
        try {
            log.info("Deleting meeting with id = {} by usr with id = {}", meetingId, userId);
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
        } finally {
            session.close();
        }
    }

    @Override
    public void applyMeeting(final Long userId, final Long meetingId, final String privilege) {
        Session session = SessionFactoryUtil.getSession();
        try {
            log.info("Find or create privilege {}", privilege);
            PrivilegeEntity privilegeEntity;
            synchronized (this) {
                privilegeEntity = (PrivilegeEntity) session.createQuery("from PrivilegeEntity where type = :privilege")
                        .setString("privilege", privilege).uniqueResult();
                if (privilegeEntity == null) {
                    privilegeEntity = new PrivilegeEntity();
                    privilegeEntity.setType(privilege);
                    session.save(privilegeEntity);
                    session.flush();
                }
            }
            log.info("Applying user with id = {} to meeting with id = {}", userId, meetingId);
            UserEntity user = (UserEntity) session.get(UserEntity.class, userId);
            MeetingEntity meeting = (MeetingEntity) session.get(MeetingEntity.class, meetingId);
            UserMeetingEntity userMeeting = new UserMeetingEntity();
            userMeeting.setUserMeetingPK(new UserMeetingEntity.UserMeetingPK(user, meeting));
            userMeeting.setPrivilegeId(privilegeEntity.getId());
            session.save(userMeeting);
            session.flush();
        } finally {
            session.close();
        }
    }

    @Override
    public void exitMeeting(final Long userId, final Long meetingId) {
        Session session = SessionFactoryUtil.getSession();
        try {
            log.info("User with id = {} exit meeting with id = {}", userId, meetingId);
            UserEntity user = (UserEntity) session.get(UserEntity.class, userId);
            MeetingEntity meeting = (MeetingEntity) session.get(MeetingEntity.class, meetingId);
            UserMeetingEntity userMeeting = (UserMeetingEntity) session.get
                    (UserMeetingEntity.class, new UserMeetingEntity.UserMeetingPK(user, meeting));
            PrivilegeEntity privilege = (PrivilegeEntity) session.get
                    (PrivilegeEntity.class, userMeeting.getPrivilegeId());
            session.delete(userMeeting);
            session.flush();
            if (privilege.getType().equals("creator")) {
                log.info("This user is creator, finding other participants");
                Query query = session.createQuery("from UserMeetingEntity where meeting_id = :meetingId")
                        .setParameter("meetingId", meetingId);
                query.setFirstResult(0);
                query.setMaxResults(1);
                synchronized (this) {
                    List<UserMeetingEntity> meetingFirstParticipant = query.list();
                    if (meetingFirstParticipant.size() == 0) {
                        log.info("No other participants, delete meeting");
                        deleteMeeting(BigInteger.ZERO.longValue(), meetingId);
                    } else {
                        UserMeetingEntity firstParticipant = meetingFirstParticipant.get(0);
                        firstParticipant.setPrivilegeId(privilege.getId());
                        session.save(firstParticipant);
                        session.flush();
                    }
                }
            }
        } finally {
            session.close();
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
