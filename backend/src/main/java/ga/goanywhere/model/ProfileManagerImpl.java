package ga.goanywhere.model;


import ga.goanywhere.dao.UserEntity;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class ProfileManagerImpl implements ProfileManager {
    @Override
    public UserEntity getInfo(Long userId) {
        Session session = SessionFactoryUtil.getSession();
        List<UserEntity> userEntity = session.createQuery("from UserEntity where id = "
        + userId).list();
        session.close();
        if (userEntity.size() == 1) {
            return userEntity.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void updateUserInfo(Long userId, UserEntity user){
        Session session = SessionFactoryUtil.getSession();
        List<UserEntity> userEntity = session.createQuery("from UserEntity where id = "
                + userId).list();
        if (userEntity.size() == 1) {
            user.setUsername(userEntity.get(0).getUsername());
            user.setPassword(userEntity.get(0).getPassword());
            session.update(user);
        }
        session.close();

    }
}
