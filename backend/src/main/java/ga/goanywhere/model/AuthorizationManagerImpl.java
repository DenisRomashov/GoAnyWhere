package ga.goanywhere.model;

import ga.goanywhere.entities.UserEntity;
import ga.goanywhere.utils.HashUtil;
import ga.goanywhere.utils.SessionFactoryUtil;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import javax.validation.constraints.NotNull;
import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@NoArgsConstructor
public class AuthorizationManagerImpl implements AuthorizationManager {


    @Override
    public BigInteger logIn(@NotNull String username, @NotNull String password) {
        log.info("Authorization of {}", username);
        Session session = SessionFactoryUtil.getSession();
        UserEntity userEntity = (UserEntity) session.createQuery("from UserEntity where username = \'"
                + username + "\'").uniqueResult();
        session.close();
        if (userEntity == null) {
            log.info("No user with such username");
            return BigInteger.ZERO;
        }
        try {
            if (userEntity.getPassword().equals(HashUtil.hash(password))) {
                return BigInteger.valueOf(userEntity.getId());
            } else {
                log.info("Incorrect password");
                return BigInteger.ZERO;
            }
        } catch (NoSuchAlgorithmException e) {
            log.info("Error while creating hash of password");
            e.printStackTrace();
            return BigInteger.ZERO;
        }
    }
}
