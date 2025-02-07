package entity;


import jakarta.persistence.*;
import lombok.*;

@Data // meka athule getter , setter , toString thiyenawa
@AllArgsConstructor
@NoArgsConstructor

@Entity // map to table (JPA Annotation - imported from jakartha ee)

@Table(name = "customer_table") // default table name eka wenuwat name eka wenas kara customer_table kiyala (JPA Annotation - imported from jakartha ee)
public class Customer {  // default table name eka customer meka wenas karanna puluwan

    @Id // (JPA Annotation - imported from jakartha ee)


    @GeneratedValue(strategy = GenerationType.AUTO) // id eka auto genarate wenwa
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // id eka manual denna oona
//    @GeneratedValue(strategy = GenerationType.UUID) // random diga id ekak genarate karala denwa


    private int id; // set this variable for table primary key using @Id

    private String name;
    private String email;
    private String phone;
}
