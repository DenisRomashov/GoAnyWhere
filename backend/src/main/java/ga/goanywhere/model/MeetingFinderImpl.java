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
import java.util.LinkedList;
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
            MeetingEntity meetingEntity = (MeetingEntity) session.get(MeetingEntity.class, meetingId);
            return meetingEntity.setNumberOfParticipants();
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
                response.add(userMeeting.getUserMeetingPK().getParticipantMeeting().setNumberOfParticipants());
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
                    response.add(userMeeting.getUserMeetingPK().getParticipantMeeting().setNumberOfParticipants());
            }
            return response;
        } finally {
            session.close();
        }
    }

    @Override
    public List<MeetingEntity> meetingSearch(Long searcherId, Long categoryId, String locality, Boolean actuality) {
        Session session = SessionFactoryUtil.getSession();
        try {
            log.info("Search meetings without participantId = {}", searcherId);
            List<MeetingEntity> meetings = session.createQuery("from MeetingEntity").list();
            List<MeetingEntity> response = new LinkedList<>();
            for (MeetingEntity meeting : meetings) {
                boolean searcherIsParticipant = false;
                for (UserMeetingEntity userMeeting : meeting.getParticipants()) {
                    if (userMeeting.getUserMeetingPK().getParticipant().getId().equals(searcherId)) {
                        searcherIsParticipant = true;
                        break;
                    }
                }
                if (!searcherIsParticipant) response.add(meeting);
            }
            if (actuality == null || actuality)
            response = filterMeetingsByActuality(response, new Timestamp(System.currentTimeMillis()));
            response = filterMeetingsByCategory(response, categoryId);
            response = filterMeetingsByLocality(response, locality);
            for (MeetingEntity meeting : response) {
                meeting.setNumberOfParticipants();
            }
            return response;
        } finally {
            session.close();
        }
    }

    private List<MeetingEntity> filterMeetingsByActuality(final List<MeetingEntity> meetings, final Timestamp now) {
        if (now == null) return meetings;
        log.info("Filter meetings by actuality");
        List<MeetingEntity> response = new LinkedList<>();
        for (MeetingEntity meeting : meetings) {
            if (meeting.getEndTime().after(now)) response.add(meeting.setNumberOfParticipants());
        }
        return response;

    }

    @Override
    public List<MeetingEntity> filterMeetingsByCategory(final List<MeetingEntity> meetings, final Long categoryId) {
        if (categoryId == null) return meetings;
        log.info("Filter meetings by category with id = {}", categoryId);
        List<MeetingEntity> filteredMeetings = new LinkedList<>();
        for (MeetingEntity meeting : meetings) {
            if (meeting.getCategoryId().equals(categoryId))
                filteredMeetings.add(meeting);
        }
        return filteredMeetings;
    }

    @Override
    public List<MeetingEntity> filterMeetingsByLocality(final List<MeetingEntity> meetings, final String locality) {
        if (locality == null) return meetings;
        log.info("Filter meetings with locality = {}", locality);
        List<MeetingEntity> filteredMeetings = new LinkedList<>();
        for (MeetingEntity meeting : meetings) {
            if (meeting.getMeetingAddress().getLocality().equals(locality))
                filteredMeetings.add(meeting);
        }
        return filteredMeetings;
    }
}
