package ga.goanywhere.dbutils;

import org.hibernate.Session;

public class CreateOrUpdateObjectUtil {

    public Long createOrUpdate(Class aClass, Object object) throws ClassNotFoundException{
        Session session = SessionFactoryUtil.getSession();
        try {
            return null;
        } finally {
            session.close();
        }
    }

}
