package lk.ijse.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author manuthlakdiv
 * @date 2/20/25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_table")
public class Student {
    //    GenerationType.IDENTITY -> database auto increment
    //   GenerationType.AUTO -> Hibernate එක database type අනුව සුදුසු strategy එක තෝරනවා.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}
