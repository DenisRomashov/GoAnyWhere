package ga.goanywhere.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "address", schema = "goanywhere", catalog = "")
public class AddressEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "locality")
    private String locality;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @JsonIgnore
    @OneToMany(mappedBy = "userAddress")
    private Collection<UserEntity> users;

    @JsonIgnore
    @OneToMany(mappedBy = "meetingAddress")
    private Collection<MeetingEntity> meetings;

}
