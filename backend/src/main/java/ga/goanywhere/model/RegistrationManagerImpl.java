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

    private final Object createUserLock = new Object();

    @Override
    public Long createUser(final String username, final String password, final String email,
                           final String firstName, final String lastName, final String sex)
            throws NoSuchAlgorithmException {
        log.info("Creating user with username =  {}", username);
        Session session = SessionFactoryUtil.getSession();
        try {

            UserEntity user = new UserEntity();
            user.setUsername(username);
            user.setPassword(HashUtil.hash(password));
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setSex(sex);

            log.info("Adding email info of user with username = {}", username);
            UserContactEntity userContact = new UserContactEntity();
            userContact.setUser(user);
            userContact.setEmail(email);

            synchronized (createUserLock) {
                if (session.createQuery("from UserEntity where username = :username")
                        .setString("username", username).uniqueResult() != null) {
                    log.info("Username {} already used", username);
                    throw new UsernameAlreadyUsedException();
                }
                session.save(user);
                session.save(userContact);
                session.flush();
            }

            return user.getId();
        } finally {
            session.close();
        }
    }
}
