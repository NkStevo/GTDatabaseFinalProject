package main.java.model;

public class User {
    private String username;
    private String email;

    public enum UserType {
        ADMIN, OWNER, VISITOR
    };

    private UserType userType;

    public User(String username, String email, UserType type) {
        this.username = username;
        this.email = email;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType type) {
        this.userType = type;
    }
}
