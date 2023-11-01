package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDTO {
    private String login;
    private String password;
    private String surname;
    private String name;
    private int age;
    private String mail;

}
