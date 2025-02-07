package entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data // meka athule getter , setter , toString thiyenawa
@AllArgsConstructor
@NoArgsConstructor

@Entity // map to table

@Table(name = "customer_table") // default table name eka wenuwat name eka wenas kara customer_table kiyala
public class Customer {  // default table name eka customer meka wenas karanna puluwan

    @Id
    private int id; // set this variable for table primary key
    private String name;
    private String email;
}
