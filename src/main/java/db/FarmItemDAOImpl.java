package main.java.db;

import main.java.model.FarmItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.HashSet;

public class FarmItemDAOImpl implements FarmItemDAO {
    private ConnectionPool dataSource;

    public FarmItemDAOImpl() {
        dataSource = ConnectionPool.getInstance();
    }

    @Override
    public Set<FarmItem> findAll() {
        PreparedStatement preStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Set<FarmItem> farmItemSet = new HashSet<FarmItem>();

        try {
            connection = dataSource.getConnection();
            preStatement = connection.prepareStatement("SELECT * FROM Has");
            resultSet = preStatement.executeQuery();

            while(resultSet.next()) {
                farmItemSet.add(this.getFarmItemFromResultSet(resultSet));
            }

            return farmItemSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean insertFarmItem(FarmItem farmItem) {
        PreparedStatement preStatement = null;
        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            preStatement = connection.prepareStatement("INSERT INTO FarmItem (Name, IsApproved, Type) " +
                    "VALUES (?, ?, ?)");

            preStatement.setString(1, farmItem.getName());
            preStatement.setBoolean(2, farmItem.isApproved());
            preStatement.setString(3, farmItem.getItemType().name());

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
    public boolean updateFarmItem(FarmItem farmItem) {
        PreparedStatement preStatement = null;
        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            preStatement = connection.prepareStatement("UPDATE FarmItem SET Name=?, IsApproved=?, Type=?");

            preStatement.setString(1, farmItem.getName());
            preStatement.setBoolean(2, farmItem.isApproved());
            preStatement.setString(3, farmItem.getItemType().name());

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
    public boolean deleteFarmItem(FarmItem farmItem) {
        PreparedStatement preStatement = null;
        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            preStatement = connection.prepareStatement("DELETE FROM FarmItem WHERE Name=?");

            preStatement.setString(1, farmItem.getName());

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

    private FarmItem getFarmItemFromResultSet(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("Name");
        Boolean isApproved = resultSet.getBoolean("IsApproved");
        FarmItem.FarmItemType farmItemType= FarmItem.FarmItemType.valueOf(resultSet.getString("Type"));

        return new FarmItem(name, isApproved, farmItemType);
    }
}
