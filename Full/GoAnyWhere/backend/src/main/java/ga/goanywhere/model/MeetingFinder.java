package ga.goanywhere.model;


import ga.goanywhere.entities.MeetingEntity;

import java.util.List;

public interface MeetingFinder {
    MeetingEntity findMeetingById(Long meetingId);
    List<MeetingEntity> findMeetingsByUser(Long userId) ;
    List<MeetingEntity> findMeetingsCreatedByUser(Long userId);

    List<MeetingEntity> meetingSearch(Long searcherId, Long categoryId, String locality, Boolean actuality);
}
