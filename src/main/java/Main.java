import lk.ijse.hibernate.config.FactoryConfiguration;
import lk.ijse.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author manuthlakdiv
 * @date 2/20/25
 */
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setId(10);
        student1.setName("manuth");

        saveStudent(student1);


        Student student2 = new Student();
        student2.setName("lakdiv");
        saveStudent(student2);

    }


    public static void saveStudent(Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();

        }

    }
}
