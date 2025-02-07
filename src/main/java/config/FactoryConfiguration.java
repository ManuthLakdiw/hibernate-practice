package config;

import entity.Customer;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    // hibernate boostrap karanna thamai meken karanne (start karanna)

    public FactoryConfiguration(){
       Configuration configuration =  new Configuration().configure(); // meka dunna gaman xml file eka process wenawa (load wenawa)
        configuration.addAnnotatedClass(Customer.class); // class eka set karanwa (hadana hadana entities methenta add karannona)
        configuration.buildSessionFactory();
    }
}
