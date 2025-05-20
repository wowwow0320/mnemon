package backend.shoppingMall.dto;

import backend.shoppingMall.domain.User;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class UserResponseDto {
    private int id;
    private String name;
    private String email;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
