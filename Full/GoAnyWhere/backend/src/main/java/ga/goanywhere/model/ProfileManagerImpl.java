package ga.goanywhere.model;


import ga.goanywhere.entities.AddressEntity;
import ga.goanywhere.entities.UserContactEntity;
import ga.goanywhere.entities.UserEntity;
import ga.goanywhere.dbutils.SessionFactoryUtil;
import ga.goanywhere.exceptions.UserNotFoundException;
import lombok.NoArgsConstructor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.sql.Date;


@NoArgsConstructor
public class ProfileManagerImpl implements ProfileManager {
    private final static Logger log = LogManager.getLogger(ProfileManagerImpl.class);

    @Override
    public UserEntity getInfo(final Long userId) {
        log.info("Getting information about user with id = {}", userId);
        Session session = SessionFactoryUtil.getSession();
        try {
            UserEntity userEntity = (UserEntity) session.get(UserEntity.class, userId);
            if (userEntity != null)
                return userEntity;
            log.info("No user with id = {] found", userId);
            throw new UserNotFoundException("There is no user with id = " + userId);
        } finally {
            session.close();
        }
    }

    @Override
    public void updateUserInfo(final Long userId, final Long addressId, final String email,
                               final String phoneNumber, final String facebookReference, final String twitterReference,
                               final String vkReference, final Date birthday, final String firstName,
                               final String lastName, final String sex, String preferred) {
        log.info("Updating information about user with id = {}", userId);
        Session session = SessionFactoryUtil.getSession();
        try {
            session.beginTransaction();

            UserEntity user = (UserEntity) session.get(UserEntity.class, userId);
            if (user == null)
                throw new UserNotFoundException("There is no user with id = " + userId);
            user.setBirthday(birthday);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setSex(sex);
            if (addressId != null)
                user.setUserAddress((AddressEntity) session.get(AddressEntity.class, addressId));

            UserContactEntity userContact = (UserContactEntity) session.createQuery("from UserContactEntity" +
                    " where user = :user").setParameter("user", user).uniqueResult();
            userContact.setEmail(email);
            userContact.setPhoneNumber(phoneNumber);
            userContact.setFacebookReference(facebookReference);
            userContact.setTwitterReference(twitterReference);
            userContact.setVkReference(vkReference);
            userContact.setPreferred(preferred);

            session.update(user);
            session.update(userContact);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }finally {
            session.close();
        }

    }
}
