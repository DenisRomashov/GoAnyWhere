package ga.goanywhere.model;


import ga.goanywhere.dbutils.SessionFactoryUtil;
import ga.goanywhere.entities.MeetingEntity;
import ga.goanywhere.entities.UserEntity;
import ga.goanywhere.entities.UserMeetingEntity;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class MeetingFinderImpl implements MeetingFinder {
    private final static Logger log = LogManager.getLogger(MeetingFinderImpl.class);

    @Override
    public List<MeetingEntity> findMeetingsByCategory(final String category) {
        return null;
    }

    // /meeting/user?id=5
    @Override
    public List<MeetingEntity> findMeetingByUser(final Long userId) {
        Session session = SessionFactoryUtil.getSession();
        try {
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

    // /meeting/creator?id=5
    @Override
    public List<MeetingEntity> findMeetingCreatedByUser(final Long userId) {
        return null;
    }

    @Override
    public List<MeetingEntity> findActualMeetingForUser(final Long userId) {
        return null;
    }

    @Override
    public List<MeetingEntity> findMeetingByLocality(final String locality) {
        return null;
    }
}
