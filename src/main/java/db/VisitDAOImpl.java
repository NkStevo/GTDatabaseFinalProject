package main.java.db;

import main.java.model.Visit;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class VisitDAOImpl implements VisitDAO {
    ConnectionPool dataSource;

    public VisitDAOImpl() {
        dataSource = dataSource.getInstance();
    }

    @Override
    public Set<Visit> findAll() {
        Connection connection = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        Set<Visit> visitSet = new HashSet<Visit>();

        try {
            connection = dataSource.getConnection();
            preStatement =connection.prepareStatement("SELECT * FROM Visit");
            resultSet = preStatement.executeQuery();

            while(resultSet.next()) {
                visitSet.add(this.getVisitFromResultSet(resultSet));
            }

            return visitSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Set<Visit> findByProperty(int propertyID) {
        Connection connection = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        Set<Visit> visitSet = new HashSet<Visit>();

        try {
            connection = dataSource.getConnection();
            preStatement = connection.prepareStatement("SELECT * FROM Visit WHERE PropertyID=?");
            preStatement.setInt(1, propertyID);

            while(resultSet.next()) {
                visitSet.add(this.getVisitFromResultSet(resultSet));
            }

            return visitSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateVisit(Visit visit) {
        Connection connection = null;
        PreparedStatement preStatement = null;

        try {
            connection = dataSource.getConnection();
            preStatement = connection.prepareStatement("UPDATE Visit SET Username=?, PropertyID=?, VisitDate=?, " +
                    "Rating=? WHERE Username=? AND PropertyID=?");

            preStatement.setString(1, visit.getUsername());
            preStatement.setInt(2, visit.getPropertyID());
            preStatement.setTimestamp(3, visit.getVisitDate());
            preStatement.setInt(4, visit.getRating());
            preStatement.setString(5, visit.getUsername());
            preStatement.setInt(6, visit.getPropertyID());

            int flag = preStatement.executeUpdate();

            if (flag == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean insertVisit(Visit visit) {
        Connection connection = null;
        PreparedStatement preStatement = null;

        try {
            connection = dataSource.getConnection();
            preStatement = connection.prepareStatement("INSERT INTO Visit (Username, PropertyID, VisitDate, " +
                    "Rating) VALUES (?, ?, ?, ?)");

            preStatement.setString(1, visit.getUsername());
            preStatement.setInt(2, visit.getPropertyID());
            preStatement.setTimestamp(3, visit.getVisitDate());
            preStatement.setInt(4, visit.getRating());

            int flag = preStatement.executeUpdate();

            if (flag == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteVisit(Visit visit) {
        Connection connection = null;
        PreparedStatement preStatement = null;

        try {
            connection = dataSource.getConnection();
            preStatement = connection.prepareStatement("DELETE FROM Visit WHERE Username=? AND PropertyID=?");

            preStatement.setString(1, visit.getUsername());
            preStatement.setInt(2, visit.getPropertyID());

            int flag = preStatement.executeUpdate();

            if (flag == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private Visit getVisitFromResultSet(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString("Username");
        int property = resultSet.getInt("PropertyID");
        Timestamp time = resultSet.getTimestamp("VisitDate");
        int rating = resultSet.getInt("Rating");

        return new Visit(username, property, time, rating);
    }
}
