package ga.goanywhere.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "user_meeting", schema = "goanywhere", catalog = "")
public class UserMeetingEntity {
    @JsonIgnore
    @EmbeddedId
    private UserMeetingPK userMeetingPK;

    @Column(name = "privilege_id")
    private Long privilegeId;

    @Override
    public String toString() {
        return "UserMeetingEntity{" +
                "userMeetingPK=" + userMeetingPK +
                ", privilegeId=" + privilegeId +
                '}';
    }

    @Getter
    @Setter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Embeddable
    private static class UserMeetingPK implements Serializable{

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserEntity participant;

        @ManyToOne
        @JoinColumn(name = "meeting_id")
        private MeetingEntity participantMeeting;

    }
}
