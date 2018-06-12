package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HibernateHelper {

    private static SessionFactory sessionFactory;

    public static void prepareSessionFactory() {
        // Hide Hibernate INFO console printouts
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

}
