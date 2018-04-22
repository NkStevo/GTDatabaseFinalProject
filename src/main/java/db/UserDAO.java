package main.java.db;

import main.java.model.User;

import java.util.List;
import java.util.Set;

public interface UserDAO {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUsernameAndPassword(String username, String password);

    List<User> findByType(User.UserType userType);
    List<User> findAll();
    List<User> findByUsernameOrEmail(String username, String email);

    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
