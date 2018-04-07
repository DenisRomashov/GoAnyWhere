package ga.goanywhere.model;

import ga.goanywhere.dao.UserEntity;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.validation.constraints.NotNull;
import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@NoArgsConstructor
public class AuthorizationManagerImpl implements AuthorizationManager {


    @Override
    public //Long
    BigInteger logIn(@NotNull String username, @NotNull String password) {
        String hash;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            hash = DatatypeConverter
                    .printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return BigInteger.ZERO;
        }
        Session session = SessionFactoryUtil.getSession();
        //Если мы всегда будем ожидать одного пользователя на выходе - зачем нам тут List?
        List<UserEntity> userEntityList = session.createQuery("from UserEntity where username = \'"
                + username + "\' and password = \'" + hash + "\'").list();//Зачем тут нужен на вход пароль? Имя пользователя должно быть уникальным
        session.close();
        //return userEntityList.size() == 1 ? userEntiryList.get(0) : 0L;

        if (userEntityList.size() == 1) {
            return userEntityList.get(0).getId();
        } else {
            return 0L;
        }
    }
}
