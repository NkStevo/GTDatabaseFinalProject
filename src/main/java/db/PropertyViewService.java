package main.java.db;

import main.java.model.PropertyView;

import java.util.List;

public interface PropertyViewService {
    List<PropertyView> findAllConfirmedOrdered(String orderByColumn, String searchTerm, String termLike,
                                               boolean isAscending);
    List<PropertyView> findAllExcludeOwner(String excludedOwner, String orderByColumn, String searchTerm,
                                           String termLike, boolean isAscending);
}
