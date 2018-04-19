package ga.goanywhere.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "user", schema = "goanywhere", catalog = "")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity userAddress;

    @OneToOne(mappedBy = "userId")
    private UserContactEntity userContact;

    @JsonIgnore
    @OneToMany(mappedBy = "userMeetingPK.participant")
    private Collection<UserMeetingEntity> meetings;

    public UserEntity(Long id) {
        this.id = id;
    }

}
