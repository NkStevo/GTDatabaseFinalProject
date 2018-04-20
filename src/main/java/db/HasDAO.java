package main.java.db;

import main.java.model.Has;

import java.util.List;
import java.util.Set;

public interface HasDAO {
    Set<Has> findAnimalsByProperty(String propertyID);
    Set<Has> findCropsByProperty(String propertyID);

    public boolean insertHas(Has has);
    public boolean updateHas(Has has);
    public boolean deleteHas(Has has);
}
