package main.java.model;

public class PropertyView {
    private int id;
    private String name;
    private float size;
    private boolean isCommercial;
    private boolean isPublic;
    private String street;
    private String city;
    private int zipcode;
    private String ownerUsername;
    private String approverUsername;
    private boolean isValid;
    private int visits;
    private int averageRating;

    public enum PropertyType {
        FARM, GARDEN, ORCHARD
    }

    private Property.PropertyType propertyType;

    public PropertyView(int id, String name, float size, boolean isCommercial, boolean isPublic, String street,
                        String city, int zipcode, Property.PropertyType propertyType, String ownerUsername,
                        String approverUsername, boolean isValid, int visits, int averageRating) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.isCommercial = isCommercial;
        this.isPublic = isPublic;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.propertyType = propertyType;
        this.ownerUsername = ownerUsername;
        this.approverUsername = approverUsername;
        this.isValid = isValid;
        this.visits = visits;
        this.averageRating = averageRating;
    }

    public PropertyView(int id, String name, float size, boolean isCommercial, boolean isPublic, String street, String city,
                    int zipcode, Property.PropertyType propertyType, String ownerUsername, boolean isValid, int visits,
                        int averageRating) {
        this(id, name, size, isCommercial, isPublic, street, city, zipcode, propertyType, ownerUsername,
                null, isValid, visits, averageRating);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public boolean isCommercial() {
        return isCommercial;
    }

    public void setCommercial(boolean commercial) {
        isCommercial = commercial;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getApproverUsername() {
        return approverUsername;
    }

    public void setApproverUsername(String approverUsername) {
        this.approverUsername = approverUsername;
    }

    public Property.PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Property.PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }
}
