package ga.goanywhere.model;

import ga.goanywhere.dao.UserEntity;
import ga.goanywhere.exceptions.UsernameAlreadyUsedException;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.validation.constraints.NotNull;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@NoArgsConstructor
public class RegistrationManagerImpl implements RegistrationManager {
    @Override
    public boolean createUser(@NotNull String username,@NotNull String password) {
        Session session = SessionFactoryUtil.getSession();
        if (session.createQuery("from UserEntity where username = \'" + username + "\'").list().size() != 0){
            throw new UsernameAlreadyUsedException();
        }
        UserEntity userEntity = new UserEntity();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            String Hash = DatatypeConverter
                    .printHexBinary(digest).toUpperCase();
            userEntity.setUsername(username);
            userEntity.setPassword(Hash);
            session.save(userEntity);
            session.close();
            return true;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}
