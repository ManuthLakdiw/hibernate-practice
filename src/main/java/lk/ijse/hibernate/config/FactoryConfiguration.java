package lk.ijse.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * @author manuthlakdiv
 * @date 2/20/25
 */
public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;
//    SessionFactory කියන්නේ Database එකට connect වෙලා Session(data) generate කරන්න උදව් කරන Object එක.

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure();

        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration.setProperties(properties);
        configuration.buildSessionFactory();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        if(factoryConfiguration == null){
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }


}
