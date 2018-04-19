package main.java.model;

import java.util.Date;

public class Visit {
    private String username;
    private int propertyID;
    private Date visitDate;
    private int rating;

    public Visit(String username, int propertyID, Date visitDate, int rating) {
        this.username = username;
        this.propertyID = propertyID;
        this.visitDate = visitDate;
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
