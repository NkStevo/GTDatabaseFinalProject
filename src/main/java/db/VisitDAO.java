package main.java.db;

import main.java.model.Visit;

import java.util.Set;

public interface VisitDAO {
    public Set<Visit> findAll();
    public Set<Visit> findByProperty(int propertyID);

    public boolean updateVisit(Visit visit);
    public boolean insertVisit(Visit visit);
    public boolean deleteVisit(Visit visit);
}
