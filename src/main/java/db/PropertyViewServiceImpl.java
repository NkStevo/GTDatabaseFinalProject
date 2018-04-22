package main.java.db;

import main.java.model.Property;
import main.java.model.PropertyView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropertyViewServiceImpl implements  PropertyViewService {
    private ConnectionPool connectionPool;

    public PropertyViewServiceImpl() {
        connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public List<PropertyView> findAllConfirmedOrdered(String orderByColumn, String searchTerm, String termLike,
                                                      boolean isAscending) {
        Connection connection = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        List<PropertyView> properties = new ArrayList<>();

        try {
            connection = connectionPool.getConnection();
            String order = (isAscending) ? "ASC" : "DESC";

            if (termLike != null) {
                preStatement = connection.prepareStatement("SELECT * FROM Display WHERE ApprovedBy IS NOT NULL AND " +
                        searchTerm + " LIKE %" + termLike + "% ORDER BY " + orderByColumn + " " + order);
            } else {
                preStatement = connection.prepareStatement("SELECT * FROM Display WHERE ApprovedBy IS NULL " +
                        "ORDER BY " + orderByColumn + " " + order);
            }

            resultSet = preStatement.executeQuery();

            while(resultSet.next()) {
                //properties.add(this.getPropertyFromResultSet(resultSet));
            }

            return properties;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDBObject(resultSet);
            DBUtil.closeDBObject(preStatement);
            DBUtil.closeDBObject(connection);
        }

        return null;
    }

    @Override
    public List<PropertyView> findAllExcludeOwner(String excludedOwner, String orderByColumn, String searchTerm, String termLike,
                                                     boolean isAscending) {
        Connection connection = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        List<PropertyView> properties = new ArrayList<>();

        try {
            connection = connectionPool.getConnection();
            String order = (isAscending) ? "ASC" : "DESC";

            if (termLike != null) {
                preStatement = connection.prepareStatement("SELECT * FROM Property WHERE Owner!=? AND " +
                        searchTerm + " LIKE %" + termLike + "% ORDER BY " + orderByColumn + " " + order);
            } else {
                preStatement = connection.prepareStatement("SELECT * FROM Property WHERE Owner!=? ORDER BY " +
                        orderByColumn + " " + order);
            }

            preStatement.setString(1, excludedOwner);

            resultSet = preStatement.executeQuery();

            while(resultSet.next()) {
                //properties.add(this.getPropertyFromResultSet(resultSet));
            }

            return properties;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDBObject(resultSet);
            DBUtil.closeDBObject(preStatement);
            DBUtil.closeDBObject(connection);
        }

        return null;
    }
}
