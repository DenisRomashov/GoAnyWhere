package ga.goanywhere.model;


import ga.goanywhere.dbutils.SessionFactoryUtil;
import ga.goanywhere.entities.MeetingEntity;
import ga.goanywhere.entities.PrivilegeEntity;
import ga.goanywhere.entities.UserEntity;
import ga.goanywhere.entities.UserMeetingEntity;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;


@NoArgsConstructor
public class MeetingFinderImpl implements MeetingFinder {
    private final static Logger log = LogManager.getLogger(MeetingFinderImpl.class);
    private final static String CREATOR_PRIVILEGE = "creator";

    @Override
    public MeetingEntity findMeetingById(final Long meetingId) {
        Session session = SessionFactoryUtil.getSession();
        try {
            log.info("Finding meeting by id = {}", meetingId);
            return  (MeetingEntity) session.get(MeetingEntity.class, meetingId);
        } finally {
            session.close();
        }
    }

    @Override
    public List<MeetingEntity> findMeetingsByCategory(final Long categoryId) {
        Session session = SessionFactoryUtil.getSession();
        try {
            log.info("Finding meetings by category with id = {}", categoryId);
            return  session.createQuery("from MeetingEntity where categoryId = :categoryId")
                    .setParameter("categoryId", categoryId).list();
        } finally {
            session.close();
        }
    }

    @Override
    public List<MeetingEntity> findMeetingsByUser(final Long userId) {
        Session session = SessionFactoryUtil.getSession();
        try {
            log.info("Finding meetings by userId = {}", userId);
            UserEntity user = (UserEntity) session.get(UserEntity.class, userId);
            List<MeetingEntity> response = new ArrayList<>();
            for (UserMeetingEntity userMeeting : user.getMeetings()) {
                response.add(userMeeting.getUserMeetingPK().getParticipantMeeting());
            }
            return response;
        } finally {
            session.close();
        }
    }

    @Override
    public List<MeetingEntity> findMeetingsCreatedByUser(final Long userId) {
        Session session = SessionFactoryUtil.getSession();
        try {
            log.info("Finding meetings by creatorId = {}", userId);
            UserEntity user = (UserEntity) session.get(UserEntity.class, userId);
            List<MeetingEntity> response = new ArrayList<>();
            PrivilegeEntity creatorPrivilege = (PrivilegeEntity) session.createQuery("from PrivilegeEntity where type = :creator")
                    .setString("creator", CREATOR_PRIVILEGE).uniqueResult();
            for (UserMeetingEntity userMeeting : user.getMeetings()) {
                if (userMeeting.getPrivilegeId().equals(creatorPrivilege.getId()))
                    response.add(userMeeting.getUserMeetingPK().getParticipantMeeting());
            }
            return response;
        } finally {
            session.close();
        }
    }

    @Override
    public List<MeetingEntity> findActualMeetingsForUser(final Long userId) {
        Session session = SessionFactoryUtil.getSession();
        try {
            log.info("Finding actual meetings for user with id = {}", userId);
            List<MeetingEntity> meetingsOfUser = findMeetingsByUser(userId);
            List<MeetingEntity> response = new ArrayList<>();
            Timestamp now = new Timestamp(System.currentTimeMillis());
            for (MeetingEntity meetingOfUser : meetingsOfUser) {
                if (meetingOfUser.getEndTime().after(now)) response.add(meetingOfUser);
            }
            return response;
        } finally {
            session.close();
        }
    }

    @Override
    public List<MeetingEntity> findMeetingsByLocality(final String locality) {
        Session session = SessionFactoryUtil.getSession();
        try {
            log.info("Finding meetings with locality = {}", locality);
            return session.createQuery("from MeetingEntity where meetingAddress.locality = :locality")
                    .setString("locality", locality).list();
        } finally {
            session.close();
        }
    }
}
