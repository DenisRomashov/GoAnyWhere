package ga.goanywhere.model;

import ga.goanywhere.entities.UserEntity;
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
public class AuthorizationManagerImpl implements AuthorizationManager {
    private final static Logger log = LogManager.getLogger(AuthorizationManagerImpl.class);

    @Override
    public BigInteger logIn(@NotNull final String username, @NotNull final String password)
            throws NoSuchAlgorithmException {
        log.info("Authorization of {}", username);
        UserEntity userEntity;
        Session session = SessionFactoryUtil.getSession();
        try {
            userEntity = (UserEntity) session.createQuery("from UserEntity where username = :username")
                    .setString("username", username).uniqueResult();
        } finally {
            session.close();
        }
        if (userEntity == null) {
            log.info("No user with such username");
            return BigInteger.ZERO;
        }
        if (userEntity.getPassword().equals(HashUtil.hash(password))) {
            return BigInteger.valueOf(userEntity.getId());
        } else {
            log.info("Incorrect password");
            return BigInteger.ZERO;
        }
    }
}
