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
    public void updateUserInfo(final Long userId, final Long addressId, final String email,
                               final String phoneNumber, final String facebookReference, final String twitterReference,
                               final String vkReference, final Date birthday, final String firstName,
                               final String lastName, final String sex){
        log.info("Updating information about user with id = {}", userId);
        Session session = SessionFactoryUtil.getSession();
        try {
            UserEntity userEntity = (UserEntity) session.get(UserEntity.class, userId);
            UserContactEntity userContact = (UserContactEntity) session.createQuery("from UserContactEntity" +
                    " where userId = :userId").setParameter("userId", userEntity).uniqueResult();
            if (userEntity != null) {
                userContact.setEmail(email);
                userContact.setPhoneNumber(phoneNumber);
                userContact.setFacebookReference(facebookReference);
                userContact.setTwitterReference(twitterReference);
                userContact.setVkReference(vkReference);
                if (addressId != null) userEntity.setUserAddress((AddressEntity)session.get(AddressEntity.class, addressId));
                userEntity.setBirthday(birthday);
                userEntity.setFirstName(firstName);
                userEntity.setLastName(lastName);
                userEntity.setSex(sex);
                session.update(userEntity);
                session.update(userContact);
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
