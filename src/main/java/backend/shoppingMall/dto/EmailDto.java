package backend.shoppingMall.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class EmailDto {
    private String email;
    private int authNum;
}
