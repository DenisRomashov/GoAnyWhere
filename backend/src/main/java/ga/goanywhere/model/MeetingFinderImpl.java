package ga.goanywhere.model;


import ga.goanywhere.entities.MeetingEntity;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@NoArgsConstructor
public class MeetingFinderImpl implements MeetingFinder {
    private final static Logger log = LogManager.getLogger(MeetingFinderImpl.class);

    @Override
    public List<MeetingEntity> findMeetingsByCategory(final String category) {
        return null;
    }

    @Override
    public List<MeetingEntity> findMeetingByUser(final Long userId) {
        return null;
    }

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
