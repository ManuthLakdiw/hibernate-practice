package lk.ijse.hibernate;

import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(
                4,
                "bbbbb",
                "ccccc@gmail.com",
                "04112141424"
        );


        boolean check = saveCustomer(customer);
        if (check) {
            System.out.println("Customer has been saved");
        }
        else {
            System.out.println("Customer has not been saved");
        }


    }

    public static boolean saveCustomer(Customer customer){
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            Transaction transaction = session.beginTransaction();

            session.save(customer);

            transaction.commit();

            return true;
        }catch (Exception e){
            return false;
        }finally {
            session.close();
        }
    }


}