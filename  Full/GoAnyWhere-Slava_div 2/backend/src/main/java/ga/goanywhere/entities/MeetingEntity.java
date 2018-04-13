package ga.goanywhere.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "meeting", schema = "goanywhere", catalog = "")
public class MeetingEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "description")
    private String description;

    @Column(name = "max_participants")
    private Integer maxParticipants;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "attachment")
    private byte[] attachment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingEntity that = (MeetingEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(addressId, that.addressId) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(description, that.description) &&
                Objects.equals(maxParticipants, that.maxParticipants) &&
                Objects.equals(minAge, that.minAge) &&
                Arrays.equals(attachment, that.attachment);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, categoryId, addressId, startTime, endTime, description, maxParticipants, minAge);
        result = 31 * result + Arrays.hashCode(attachment);
        return result;
    }
}
