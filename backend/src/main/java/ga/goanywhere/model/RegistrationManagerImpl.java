package ga.goanywhere.model;

import ga.goanywhere.entities.UserContactEntity;
import ga.goanywhere.entities.UserEntity;
import ga.goanywhere.exceptions.UsernameAlreadyUsedException;
import ga.goanywhere.utils.HashUtil;
import ga.goanywhere.dbutils.SessionFactoryUtil;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

@NoArgsConstructor
public class RegistrationManagerImpl implements RegistrationManager {
    private final static Logger log = LogManager.getLogger(RegistrationManagerImpl.class);

    @Override
    public BigInteger createUser(@NotNull final String username, @NotNull final String password)
            throws NoSuchAlgorithmException {
        log.info("Creating user: {}", username);
        Session session = SessionFactoryUtil.getSession();
        try {
            synchronized (this) {
                if (session.createQuery("from UserEntity where username = :username")
                        .setString("username", username).uniqueResult() != null) {
                    log.info("Username {} already used", username);
                    throw new UsernameAlreadyUsedException();
                }
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(username);
                userEntity.setPassword(HashUtil.hash(password));
                session.save(userEntity);
                session.flush();
                return BigInteger.valueOf(userEntity.getId());
            }
        } finally {
            session.close();
        }
    }

    @Override
    public BigInteger createUser(@NotNull final String username, @NotNull final String password,
                                 @NotNull final String email)
            throws NoSuchAlgorithmException {
        BigInteger userId = createUser(username, password);
        log.info("Adding email info of user with id = {}", userId);
        UserContactEntity userContactEntity = new UserContactEntity();
        userContactEntity.setUserId(new UserEntity(userId.longValue()));
        userContactEntity.setEmail(email);
        Session session = SessionFactoryUtil.getSession();
        try {
            session.save(userContactEntity);
            session.flush();
            return userId;
        } finally {
            session.close();
        }
    }

    @Override
    public BigInteger createUser(@NotNull final String username, @NotNull final String password,
                                 @NotNull final String email, @NotNull final String firstName,
                                 @NotNull final String lastName, @NotNull final String sex)
            throws  NoSuchAlgorithmException{
        BigInteger userId = createUser(username, password, email);
        Session session = SessionFactoryUtil.getSession();
        try {
            UserEntity userEntity = (UserEntity) session.get(UserEntity.class, userId.longValue());
            userEntity.setFirstName(firstName);
            userEntity.setLastName(lastName);
            userEntity.setSex(sex);
            session.update(userEntity);
            session.flush();
            return userId;
        } finally {
            session.close();
        }
    }
}
