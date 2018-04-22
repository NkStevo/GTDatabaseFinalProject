package main.java.db;

import main.java.model.VisitorView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisitorViewServiceImpl implements  VisitorViewService {
    private ConnectionPool connectionPool;

    public VisitorViewServiceImpl() {
        connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public List<VisitorView> findAllOrdered(String orderByColumns, String searchTerm, String termLike) {
        Connection connection = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        List<VisitorView> visitors = new ArrayList<>();

        try {
            connection = connectionPool.getConnection();

            if (termLike != null) {
                preStatement = connection.prepareStatement("SELECT User.Username, User.Email, " +
                        "COUNT(select * from Visit GROUP BY Visit.Username) AS LoggedVisits FROM User INNER JOIN " +
                        "Visit ON User.Username = Visit.Username WHERE " + searchTerm + " LIKE %" + termLike +
                        "% ORDER BY " + orderByColumns);
            } else {
                preStatement = connection.prepareStatement("SELECT User.Username, User.Email, " +
                        "COUNT(select * from Visit GROUP BY Visit.Username) AS LoggedVisits FROM User INNER JOIN " +
                        "Visit ON User.Username = Visit.Username ORDER BY " + orderByColumns);
            }

            resultSet = preStatement.executeQuery();

            while(resultSet.next()) {
                visitors.add(this.getVisitorViewFromResultSet(resultSet));
            }

            return visitors;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDBObject(resultSet);
            DBUtil.closeDBObject(preStatement);
            DBUtil.closeDBObject(connection);
        }

        return null;
    }

    private VisitorView getVisitorViewFromResultSet(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString("Username");
        String email = resultSet.getString("Email");
        int loggedVisits = resultSet.getInt("LoggedVisits");

        return new VisitorView(username, email, loggedVisits);
    }
}
