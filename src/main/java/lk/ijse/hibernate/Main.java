package lk.ijse.hibernate;

import config.FactoryConfiguration;
import entity.Customer;
import lombok.val;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


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

//        boolean check = deleteCustomer(1);
//        if (check) {
//            System.out.println("customer deleted successfully");
//        }else {
//            System.out.println("customer not deleted successfully");
//        }

//        boolean updated = updateCustomer(4, new Customer(5, "dimantha", "dimantha@gmail.com", "0713322324"));
//        if (updated) {
//            System.out.println("updated successfully");
//        }else {
//            System.out.println("failed to update customer");
//        }

        List<Customer> customerList = getCustomerList();
        for (Customer c : customerList) {
            System.out.println(c);
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

    public static boolean updateCustomer(int id , Customer newCustomer){
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Customer customer = session.get(Customer.class, id);
            Transaction transaction = session.beginTransaction();

            customer.setName(newCustomer.getName());
            customer.setEmail(newCustomer.getEmail());
            customer.setPhone(newCustomer.getPhone());

            transaction.commit();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            session.close();
        }
    }

//    HQL -> Hibernate Query Language (Ex : from Customer)
    public static List<Customer> getCustomerList(){
        Session session = FactoryConfiguration.getInstance().getSession();

        List<Customer> customers = session.createQuery(
                "from Customer", // methana table name eka newei class eke ekiyanne object name ek denna
                Customer.class
        ).list();

        return customers;
    }



}