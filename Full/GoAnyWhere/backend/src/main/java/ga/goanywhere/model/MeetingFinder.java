package ga.goanywhere.model;


import ga.goanywhere.entities.MeetingEntity;

import java.util.List;

public interface MeetingFinder {
    MeetingEntity findMeetingById(Long meetingId);

    List<MeetingEntity> findMeetingsByCategory(Long categoryId);
    List<MeetingEntity> findMeetingsByUser(Long userId) ;
    List<MeetingEntity> findMeetingsCreatedByUser(Long userId);
    List<MeetingEntity> findActualMeetingsForUser(Long userId);
    List<MeetingEntity> findMeetingsByLocality(String locality);
}
