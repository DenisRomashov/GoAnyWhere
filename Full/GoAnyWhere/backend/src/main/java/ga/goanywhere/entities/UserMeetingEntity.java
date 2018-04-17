package ga.goanywhere.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "user_meeting", schema = "goanywhere", catalog = "")
public class UserMeetingEntity {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMeetingEntity that = (UserMeetingEntity) o;
        return Objects.equals(userMeetingPK, that.userMeetingPK) &&
                Objects.equals(privilegeId, that.privilegeId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userMeetingPK, privilegeId);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    private static class UserMeetingPK implements Serializable{

        @Column(name = "user_id")
        private Integer user_id;

        @Column(name = "meeting_id")
        private Integer meeting_id;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserMeetingPK that = (UserMeetingPK) o;
            return Objects.equals(user_id, that.user_id) &&
                    Objects.equals(meeting_id, that.meeting_id);
        }

        @Override
        public int hashCode() {

            return Objects.hash(user_id, meeting_id);
        }

        @Override
        public String toString() {
            return "UserMeetingPK{" +
                    "user_id=" + user_id +
                    ", meeting_id=" + meeting_id +
                    '}';
        }
    }
}
