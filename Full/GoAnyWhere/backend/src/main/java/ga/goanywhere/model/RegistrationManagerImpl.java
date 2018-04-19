package ga.goanywhere.model;

import ga.goanywhere.entities.UserContactEntity;
import ga.goanywhere.entities.UserEntity;
import ga.goanywhere.exceptions.UsernameAlreadyUsedException;
import ga.goanywhere.utils.HashUtil;
import ga.goanywhere.utils.SessionFactoryUtil;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public BigInteger createUser(@NotNull String username, @NotNull String password) {
        log.info("Creating user: {}", username);
        Session session = SessionFactoryUtil.getSession();
        try {
            if (session.createQuery("from UserEntity where username = \'" + username + "\'").list().size() != 0) {
                log.info("Username {} already used", username);
                throw new UsernameAlreadyUsedException();
            }
            UserEntity userEntity = new UserEntity();
            try {
                userEntity.setUsername(username);
                userEntity.setPassword(HashUtil.hash(password));
                session.save(userEntity);
                session.flush();
                return BigInteger.valueOf(userEntity.getId());
            } catch (NoSuchAlgorithmException e) {
                log.info("Error while creating hash of password");
                e.printStackTrace();
                return BigInteger.ZERO;
            }
        } finally {
            session.close();
        }
    }

    @Override
    public BigInteger createUser(@NotNull String username, @NotNull String password, @NotNull String email) {
        BigInteger userId = createUser(username, password);
        if (userId.equals(BigInteger.ZERO)) {
            log.info("User was not created");
            return userId;
        }
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
}
