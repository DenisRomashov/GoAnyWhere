package ga.goanywhere.dbutils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {

    private static volatile SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            //apply configuration property settings to StandardServiceRegistryBuilder
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).build();

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession(){
        SessionFactory localSessionFactory = sessionFactory;
        if (localSessionFactory == null) {
            synchronized (SessionFactoryUtil.class) {
                localSessionFactory = sessionFactory;
                if (localSessionFactory == null) {
                    sessionFactory = localSessionFactory = buildSessionFactory();
                }
            }
        }
        return localSessionFactory.openSession();
    }
}
