package ga.goanywhere.model;


import ga.goanywhere.dao.UserEntity;

public interface ProfileManager {
    UserEntity getInfo(Long userId);
    void updateUserInfo(Long userId, UserEntity userEntity);
}
