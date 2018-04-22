package main.java.db;

import main.java.model.User;

import java.util.List;
import java.util.Set;

public interface UserDAO {
    public User findByUsername(String username);
    public User findByEmail(String email);
    public User findByUsernameAndPassword(String username, String password);

    public Set<User> findByType(User.UserType userType);
    public Set<User> findAll();
    public Set<User> findByUsernameOrEmail(String username, String email);

    public boolean insertUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(User user);
}
