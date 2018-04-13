package ga.goanywhere.model;


import ga.goanywhere.entities.MeetingEntity;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class MeetingFinderImpl implements MeetingFinder {


    @Override
    public List<MeetingEntity> findMeetingsByCategory(String category) {
        return null;
    }

    @Override
    public List<MeetingEntity> findMeetingByUser(Long userId) {
        return null;
    }

    @Override
    public List<MeetingEntity> findMeetingCreatedByUser(Long userId) {
        return null;
    }

    @Override
    public List<MeetingEntity> findActualMeetingForUser(Long userId) {
        return null;
    }

    @Override
    public List<MeetingEntity> findMeetingByLocality(String locality) {
        return null;
    }
}
