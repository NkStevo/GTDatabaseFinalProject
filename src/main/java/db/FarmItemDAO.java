package main.java.db;

import main.java.model.FarmItem;

import java.util.Set;

public interface FarmItemDAO {
    public Set<FarmItem> findAll();

    public boolean insertFarmItem(FarmItem farmItem);
    public boolean updateFarmItem(FarmItem farmItem);
    public boolean deleteFarmItem(FarmItem farmItem);
}
