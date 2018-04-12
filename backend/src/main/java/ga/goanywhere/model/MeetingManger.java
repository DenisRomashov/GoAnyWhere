package ga.goanywhere.model;



import ga.goanywhere.entities.UserEntity;

import java.util.Date;
import java.util.List;

public interface MeetingManger {
    boolean createMeeting(Long categoryId, Date start_time, Long addressId);
    void deleteMeeting(Long userId, Long meetingId);
    boolean applyMeeting(Long userId, Long meetingId);
    void exitMeeting(Long userId, Long meetingId);
    List<UserEntity> getMeetingParticipants(Long meetingId);

}
