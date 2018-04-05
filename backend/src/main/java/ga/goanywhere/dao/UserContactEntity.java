package ga.goanywhere.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "user_contact", schema = "goanywhere", catalog = "")
public class UserContactEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserContactEntity that = (UserContactEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(vkReference, that.vkReference) &&
                Objects.equals(facebookReference, that.facebookReference) &&
                Objects.equals(twitterReference, that.twitterReference) &&
                Objects.equals(preferred, that.preferred);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, email, phoneNumber, vkReference, facebookReference, twitterReference, preferred);
    }
}
