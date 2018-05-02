package ga.goanywhere.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "meeting", schema = "goanywhere", catalog = "")
public class MeetingEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity meetingAddress;

    @Column(name = "name")
    private String name;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "description")
    private String description;

    @Column(name = "max_participants")
    private Long maxParticipants;

    @Column(name = "min_age")
    private Long minAge;

    @Column(name = "attachment")
    private byte[] attachment;

    @JsonIgnore
    @OneToMany(mappedBy = "userMeetingPK.participantMeeting", cascade = CascadeType.ALL)
    private Collection<UserMeetingEntity> participants;
}
