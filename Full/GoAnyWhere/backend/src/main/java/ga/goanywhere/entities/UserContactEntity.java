package ga.goanywhere.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "user_contact", schema = "goanywhere", catalog = "")
public class UserContactEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "vk_reference")
    private String vkReference;

    @Column(name = "facebook_reference")
    private String facebookReference;

    @Column(name = "twitter_reference")
    private String twitterReference;

    @Column(name = "preferred")
    private String preferred;



}
