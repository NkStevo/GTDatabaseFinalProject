package main.java.db;

import main.java.model.Visit;

import java.util.List;

public interface VisitDAO {
    List<Visit> findAll();
    List<Visit> findByProperty(int propertyID);

    boolean updateVisit(Visit visit);
    boolean insertVisit(Visit visit);
    boolean deleteVisit(Visit visit);
}
