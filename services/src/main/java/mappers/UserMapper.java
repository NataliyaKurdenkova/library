package mappers;


import dto.UserDTO;
import entity.User;

import java.util.Optional;

public interface UserMapper {
    Optional<User> userDTOToUser(Optional<UserDTO> userDTO);

    Optional<UserDTO> userToUserDTO(Optional<User> user);

}
