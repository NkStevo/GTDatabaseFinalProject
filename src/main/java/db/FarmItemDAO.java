package main.java.db;

import main.java.model.FarmItem;

import java.util.List;

public interface FarmItemDAO {
    List<FarmItem> findAll();
    List<FarmItem> findApprovedOrPendingOrdered(String orderByColumn, boolean isAscending, boolean isApproved);

    boolean insertFarmItem(FarmItem farmItem);
    boolean updateFarmItem(FarmItem farmItem);
    boolean deleteFarmItem(FarmItem farmItem);
}
