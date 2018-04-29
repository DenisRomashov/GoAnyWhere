package ga.goanywhere.model;


import ga.goanywhere.entities.UserEntity;
import ga.goanywhere.dbutils.SessionFactoryUtil;
import ga.goanywhere.exceptions.UserNotFoundException;
import lombok.NoArgsConstructor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;


@NoArgsConstructor
public class ProfileManagerImpl implements ProfileManager {
    private final static Logger log = LogManager.getLogger(ProfileManagerImpl.class);

    @Override
    public UserEntity getInfo(final Long userId) {
        log.info("Getting information about user with id = {}", userId);
        Session session = SessionFactoryUtil.getSession();
        try {
            UserEntity userEntity = (UserEntity) session.createQuery("from UserEntity where id = :userId")
                    .setParameter("userId", userId).uniqueResult();
            if (userEntity != null) {
                return userEntity;
            } else {
                log.info("No user with id = {] found", userId);
                throw new UserNotFoundException("There is no user with id = " + userId);
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void updateUserInfo(final Long userId, final UserEntity user){
        log.info("Updating information about user with id = {}", userId);
        Session session = SessionFactoryUtil.getSession();
        try {
            UserEntity userEntity = (UserEntity) session.createQuery("from UserEntity where id = :userId")
                    .setParameter("userId", userId).uniqueResult();
            if (userEntity != null) {
                user.setUsername(userEntity.getUsername());
                user.setPassword(userEntity.getPassword());
                session.merge(user);
                session.flush();
            } else {
                log.info("No user with id = {] found", userId);
                throw new UserNotFoundException("There is no user with id = " + userId);
            }
        } finally {
            session.close();
        }

    }
}
