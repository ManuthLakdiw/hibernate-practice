package lk.ijse.hibernate;

import config.FactoryConfiguration;
import entity.Customer;
import lombok.val;
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


        Customer customer1 = getCustomer(1);
        System.out.println(customer1);

        Customer customer2 = getCustomer(5);
        System.out.println(customer2);

//        boolean check = saveCustomer(customer);
//        if (check) {
//            System.out.println("Customer has been saved");
//        }
//        else {
//            System.out.println("Customer has not been saved");
//        }

        boolean check = deleteCustomer(1);
        if (check) {
            System.out.println("customer deleted successfully");
        }else {
            System.out.println("customer not deleted successfully");
        }


    }

    public static Customer getCustomer(int id){
        Session session = FactoryConfiguration.getInstance().getSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return  customer;
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

    public static boolean deleteCustomer(int id){
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.delete(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            session.close();
        }
    }



}