package ga.goanywhere.model;


import ga.goanywhere.entities.UserEntity;
import ga.goanywhere.utils.SessionFactoryUtil;
import lombok.NoArgsConstructor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;


@NoArgsConstructor
public class ProfileManagerImpl implements ProfileManager {
    private final static Logger log = LogManager.getLogger(ProfileManagerImpl.class);

    @Override
    public UserEntity getInfo(Long userId) {
        log.info("Getting information about user with id = {}", userId);
        Session session = SessionFactoryUtil.getSession();
        try {
            UserEntity userEntity = (UserEntity) session.createQuery("from UserEntity where id = "
                    + userId).uniqueResult();
            if (userEntity != null) {
                return userEntity;
            } else {
                log.info("No user with id = {] found", userId);
                return null;
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void updateUserInfo(Long userId, UserEntity user){
        log.info("Updating information about user with id = {}", userId);
        Session session = SessionFactoryUtil.getSession();
        try {
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
        } finally {
            session.close();
        }

    }
}
