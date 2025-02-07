package lk.ijse.hibernate;

import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(
                2,
                "lakdiv",
                "lakdiw@gmail.com"
        );

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();

        session.close();


    }
}