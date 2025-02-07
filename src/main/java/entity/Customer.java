package entity;


import lombok.*;

@Data // meka athule getter , setter , toString thiyenawa
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String email;
}
