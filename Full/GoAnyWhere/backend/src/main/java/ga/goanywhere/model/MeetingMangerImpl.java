package ga.goanywhere.model;

import ga.goanywhere.entities.UserEntity;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class MeetingMangerImpl implements MeetingManger {
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
