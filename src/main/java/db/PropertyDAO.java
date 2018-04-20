package main.java.db;

import main.java.model.Property;

import java.util.Set;

public interface PropertyDAO {
    Set<Property> findAll();

}
