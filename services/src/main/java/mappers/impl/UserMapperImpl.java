package mappers.impl;

import dto.UserDTO;
import entity.User;
import mappers.UserMapper;

import java.util.Optional;

public class UserMapperImpl implements UserMapper {
    private static int countUser = 0;

    @Override
    public Optional<User> userDTOToUser(Optional<UserDTO> userDTO) {
        User user = User.builder()
                .id(countUser++)
                .login(userDTO.get().getLogin())
                .password(userDTO.get().getPassword())
                .mail(userDTO.get().getMail())
                .surname(userDTO.get().getSurname())
                .name(userDTO.get().getName())
                .age(userDTO.get().getAge())
                .build();

        return Optional.of(user);
    }

    @Override
    public Optional<UserDTO> userToUserDTO(Optional<User> user) {

        UserDTO userDTO = UserDTO.builder()
                .login(user.get().getLogin())
                .password(user.get().getPassword())
                .mail(user.get().getMail())
                .surname(user.get().getSurname())
                .name(user.get().getName())
                .age(user.get().getAge())
                .build();
        return Optional.of(userDTO);
    }
}
