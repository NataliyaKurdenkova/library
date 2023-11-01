package dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class UserDao {
    Map<String, User> userMap = new HashMap<>();

    Optional<User> findUserById(long id) {
        User user = userMap.values().stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .get();
        return Optional.of(user);
    }

    Optional<User> findUserByLogin(String login) {
        User user = userMap.entrySet().stream()
                .filter(u -> login.equals(u.getKey()))
                .findFirst()
                .get()
                .getValue();
        return Optional.of(user);
    }

    public List<Optional<User>> getUsers() {
        List<Optional<User>> users = userMap.values().stream()
                .map(u -> Optional.of(u))
                .collect(Collectors.toList());
        return users;
    }


    public boolean saveUser(User user){
        if(!user.equals(null)) {
            userMap.put(user.getLogin(), user);
            return true;
        }
        return false;
    }

    public List<User> readFromJson(String path) {
        List<User> users=new ArrayList<>();
        if (path != null) {
            byte[] jsonData = new byte[0];
            try {
                jsonData = Files.readAllBytes(Paths.get(path));
                ObjectMapper objectMapper = new ObjectMapper();
                User user = objectMapper.readValue(jsonData, User.class);
                users.add(user);

            } catch (IOException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return users;

    }

}
