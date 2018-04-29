package ga.goanywhere.model;



import ga.goanywhere.entities.UserEntity;

import java.util.List;

public interface MeetingManger {
    void createMeeting(Long creatorId, String category, String name, Long start_time, Long end_time);
    void deleteMeeting(Long userId, Long meetingId);
    void applyMeeting(Long userId, Long meetingId, String privilege);
    void exitMeeting(Long userId, Long meetingId);
    List<UserEntity> getMeetingParticipants(Long meetingId);

}
