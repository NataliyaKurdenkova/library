package service;

import dao.UserDao;
import dto.UserDTO;
import entity.User;
import mappers.UserMapper;
import mappers.impl.UserMapperImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsersService {
    private UserDao userDao = new UserDao();
    private UserMapper userMapper = new UserMapperImpl();

    public List<Optional<UserDTO>> getUsers() {

        return userDao.getUsers().stream()
                .map(u -> (userMapper.userToUserDTO(u)))
                .collect(Collectors.toList());

    }

    public boolean saveUser(User user) {
        return userDao.saveUser(user);
    }


    public List<User> readFromJson(String userPatch) {
        return userDao.readFromJson(userPatch);
    }
}
