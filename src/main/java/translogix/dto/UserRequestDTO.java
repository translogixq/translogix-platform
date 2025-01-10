package translogix.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDTO {

    private String firstName;
    private String secondName;
    private String email;
    private String password;
}
