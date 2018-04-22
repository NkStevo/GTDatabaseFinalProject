package main.java.db;

import main.java.model.Property;

import java.util.List;

public interface PropertyDAO {
    List<Property> findAll();
    List<Property> findByOwner(String owner);
    List<Property> findByExcludedOwner(String excludedOwner);
    List<Property> findByType(Property.PropertyType propertyType);
    List<Property> findByNameLike(String nameLike);
    List<Property> findApprovedOrUnapprovedOrdered(String orderByColumn, boolean isApproved, boolean isAscending);

    Property findByName(String propertyName);
    Property findByID(int propertyID);

    boolean insertProperty(Property property);
    boolean updateProperty(Property property);
    boolean deleteProperty(Property property);
}
