package backend.shoppingMall.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class UserLoginRequestDto {
    private String email;
    private String password;
}