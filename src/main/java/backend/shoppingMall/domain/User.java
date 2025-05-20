package backend.shoppingMall.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String phone_number;

    public  boolean checkPassword(String rawPassword, PasswordEncoder encoder){
        return encoder.matches(rawPassword, this.password);
    }
}

