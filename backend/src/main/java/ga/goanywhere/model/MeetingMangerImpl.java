package ga.goanywhere.model;

import ga.goanywhere.entities.UserEntity;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class MeetingMangerImpl implements MeetingManger {
    private final static Logger log = LogManager.getLogger(MeetingMangerImpl.class);
    @Override
    public boolean createMeeting(Long categoryId, Date start_time, Long addressId) {

        return false;
    }

    @Override
    public void deleteMeeting(Long userId, Long meetingId) {

    }

    @Override
    public boolean applyMeeting(Long userId, Long meetingId) {

        return false;
    }

    @Override
    public void exitMeeting(Long userId, Long meetingId) {

    }

    @Override
    public List<UserEntity> getMeetingParticipants(Long meetingId) {
        return null;
    }
}
