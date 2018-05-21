package ga.goanywhere.model;


import ga.goanywhere.entities.UserEntity;

import java.sql.Date;

public interface ProfileManager {
    UserEntity getInfo(Long userId);

    void updateUserInfo(Long userId, Long addressId, String email,
                        String phoneNumber, String facebookReference, String twitterReference,
                        String vkReference, Date birthday, String firstName,
                        String lastName, String sex, String preferred);
}
