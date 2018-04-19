package main.java.db;

import main.java.model.User;

import java.util.List;
import java.util.Set;

public interface UserDAO {
    User findByUsername();
    User findByEmail();
    User findByUsernameAndPassword();

    Set<User> findAll();
    Set<User> findByUsernameOrEmail();

    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
