package ga.goanywhere.model;


import ga.goanywhere.entities.MeetingEntity;

import java.util.List;

public interface MeetingFinder {
    List<MeetingEntity> findMeetingsByCategory(String category);
    List<MeetingEntity> findMeetingByUser(Long userId) ;
    List<MeetingEntity> findMeetingCreatedByUser(Long userId);
    List<MeetingEntity> findActualMeetingForUser(Long userId);
    List<MeetingEntity> findMeetingByLocality(String locality);
}
