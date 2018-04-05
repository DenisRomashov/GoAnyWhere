package ga.goanywhere.model;


import ga.goanywhere.dao.UserEntity;

import java.util.Date;

public interface ProfileManager {
    UserEntity getInfo(Long userId);
    void updateUserInfo(Long userId, UserEntity userEntity);
}
