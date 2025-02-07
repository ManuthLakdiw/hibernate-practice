package config;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    // hibernate boostrap karanna thamai meken karanne (start karanna)


    //mulu project ekakata session factory eka parai hadenne eka nisa singleton desgin pattern eka danwa

    private static FactoryConfiguration factoryConfiguration;

    private static SessionFactory sessionFactory;

    private FactoryConfiguration(){
       Configuration configuration =  new Configuration().configure(); // meka dunna gaman xml file eka process wenawa (load wenawa)
        configuration.addAnnotatedClass(Customer.class); // class eka set karanwa (hadana hadana entities methenta add karannona)
        configuration.buildSessionFactory();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        if(factoryConfiguration == null){
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

//    hema crud ekakatama session open karanna ona nisa meken session return karagannawa
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
