package ga.goanywhere.model;



import ga.goanywhere.entities.CategoryEntity;
import ga.goanywhere.entities.UserEntity;

import java.util.Date;
import java.util.List;

public interface MeetingManger {

    Long createMeeting(Long id, Long creatorId, Long categoryId,
                       Long addressId, String name, Date startTime,
                       Date endTime, String description, Long maxParticipants,
                       Long minAge, byte[] attachment);

    void deleteMeeting(Long userId, Long meetingId);
    void applyMeeting(Long userId, Long meetingId, String privilege);
    void exitMeeting(Long userId, Long meetingId);
    List<UserEntity> getMeetingParticipants(Long meetingId);

    List<CategoryEntity> getCategories();
}
