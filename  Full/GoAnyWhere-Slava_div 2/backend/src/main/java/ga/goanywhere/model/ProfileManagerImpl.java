package ga.goanywhere.model;


import ga.goanywhere.entities.UserEntity;
import ga.goanywhere.utils.SessionFactoryUtil;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.List;

@Slf4j
@NoArgsConstructor
public class ProfileManagerImpl implements ProfileManager {
    @Override
    public UserEntity getInfo(Long userId) {
        log.info("Getting information about user with id = {}", userId);
        Session session = SessionFactoryUtil.getSession();
        UserEntity userEntity = (UserEntity) session.createQuery("from UserEntity where id = "
        + userId).uniqueResult();
        session.close();
        if (userEntity != null) {
            return userEntity;
        } else {
            log.info("No user with id = {] found", userId);
            return null;
        }
    }

    //final для закрытия сессии
    @Override
    public void updateUserInfo(Long userId, UserEntity user){
        log.info("Updating information about user with id = {}", userId);
        Session session = SessionFactoryUtil.getSession();
        UserEntity userEntity = (UserEntity) session.createQuery("from UserEntity where id = "
                + userId).uniqueResult();
        if (userEntity != null) {
            user.setUsername(userEntity.getUsername());
            user.setPassword(userEntity.getPassword());
            session.merge(user);
            session.flush();
        } else {
            log.info("No user with id = {] found", userId);
        }
        session.close();

    }
}
