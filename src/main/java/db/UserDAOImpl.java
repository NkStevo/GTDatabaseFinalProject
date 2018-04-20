package main.java.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.java.model.User;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserDAOImpl implements UserDAO{
    private ConnectionPool dataSource;

    public UserDAOImpl() {
        dataSource = ConnectionPool.getInstance();
    }

    @Override
    public User findByUsername(String username) {
        PreparedStatement preStatement = null;

        Connection connection = dataSource.getConnection();
        ResultSet resultSet = null;

        try {
            preStatement = connection.prepareStatement("SELECT * FROM USER WHERE Username=?");
            preStatement.setString(1, username);

            resultSet = preStatement.executeQuery();

            if (resultSet.next()) {
                User user = this.getUserFromResultSet(resultSet);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            //OPEN ERROR WINDOW
        } finally {
            DBUtil.closeDBObject(resultSet);
            DBUtil.closeDBObject(preStatement);
            DBUtil.closeDBObject(connection);
        }

        return null;
    }

    @Override
    public User findByEmail(String email) {
        PreparedStatement preStatement = null;

        Connection connection = dataSource.getConnection();
        ResultSet resultSet = null;

        try {
            preStatement = connection.prepareStatement("SELECT * FROM USER WHERE Email=?");
            preStatement.setString(1, email);

            resultSet = preStatement.executeQuery();

            if (resultSet.next()) {
                User user = this.getUserFromResultSet(resultSet);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            //OPEN ERROR WINDOW
        } finally {
            DBUtil.closeDBObject(resultSet);
            DBUtil.closeDBObject(preStatement);
            DBUtil.closeDBObject(connection);
        }

        return null;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        PreparedStatement preStatement = null;

        Connection connection = dataSource.getConnection();
        ResultSet resultSet = null;

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            preStatement = connection.prepareStatement("SELECT * FROM USER WHERE Username=? AND Password=?");
            preStatement.setString(1, username);
            preStatement.setString(2, password);
            //(new HexBinaryAdapter()).marshal(md5.digest(password)) convert from byte[] to String

            resultSet = preStatement.executeQuery();

            if (resultSet.next()) {
                User user = this.getUserFromResultSet(resultSet);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            //OPEN ERROR WINDOW
        } finally {
            DBUtil.closeDBObject(resultSet);
            DBUtil.closeDBObject(preStatement);
            DBUtil.closeDBObject(connection);
        }

        return null;
    }

    @Override
    public Set<User> findAll() {
        PreparedStatement preStatement = null;
        Connection connection = dataSource.getConnection();

        ResultSet resultSet = null;
        Set<User> users = new HashSet<User>();

        try {
            preStatement = connection.prepareStatement("SELECT * FROM USER");

            resultSet = preStatement.executeQuery();

            while (resultSet.next()) {
                users.add(this.getUserFromResultSet(resultSet));
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            //OPEN ERROR WINDOW
        } finally {
            DBUtil.closeDBObject(resultSet);
            DBUtil.closeDBObject(preStatement);
            DBUtil.closeDBObject(connection);
        }

        return null;
    }

    @Override
    public Set<User> findByUsernameOrEmail(String username, String email) {
        PreparedStatement preStatement = null;
        Connection connection = dataSource.getConnection();

        ResultSet resultSet = null;
        Set<User> users = new HashSet<User>();

        try {
            preStatement = connection.prepareStatement("SELECT * FROM USER WHERE Username=? OR Email=?");
            preStatement.setString(1, username);
            preStatement.setString(2, email);

            resultSet = preStatement.executeQuery();

            while (resultSet.next()) {
                users.add(this.getUserFromResultSet(resultSet));
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            //OPEN ERROR WINDOW
        } finally {
            DBUtil.closeDBObject(resultSet);
            DBUtil.closeDBObject(preStatement);
            DBUtil.closeDBObject(connection);
        }

        return null;
    }

    @Override
    public boolean insertUser(User user) {
        PreparedStatement preStatement = null;
        Connection connection = dataSource.getConnection();

        try {
            preStatement = connection.prepareStatement("INSERT INTO User (Username, Email, Password, UserType) " +
                    "VALUES (?, ?, ?, ?)");

            preStatement.setString(1, user.getUsername());
            preStatement.setString(2, user.getEmail());
            preStatement.setString(3, user.getPassword());
            preStatement.setString(4, user.getUserType().name());

            int flag = preStatement.executeUpdate();

            if (flag == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDBObject(preStatement);
            DBUtil.closeDBObject(connection);
        }

        return false;
    }

    @Override
    public boolean updateUser(User user) {
        PreparedStatement preStatement = null;
        Connection connection = dataSource.getConnection();

        try {
            preStatement = connection.prepareStatement("UPDATE User SET Username=?, Email=?, Password=?, UserType=? " +
                    "WHERE Username=?");

            preStatement.setString(1, user.getUsername());
            preStatement.setString(2, user.getEmail());
            preStatement.setString(3, user.getPassword());
            preStatement.setString(4, user.getUserType().name());
            preStatement.setString(5, user.getUsername());

            int flag = preStatement.executeUpdate();

            if (flag == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDBObject(preStatement);
            DBUtil.closeDBObject(connection);
        }

        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        PreparedStatement preStatement = null;
        Connection connection = dataSource.getConnection();

        try {
            preStatement = connection.prepareStatement("DELETE FROM User WHERE Username=?");

            preStatement.setString(1, user.getUsername());

            int flag = preStatement.executeUpdate();

            if (flag == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDBObject(preStatement);
            DBUtil.closeDBObject(connection);
        }

        return false;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException, UnsupportedEncodingException {
        String username = resultSet.getString("Username");
        String email = resultSet.getString("Email");
        String password = resultSet.getString("Password");
        User.UserType userType = User.UserType.valueOf(resultSet.getString("UserType"));

        return new User(username, email, password, userType);
    }
}
