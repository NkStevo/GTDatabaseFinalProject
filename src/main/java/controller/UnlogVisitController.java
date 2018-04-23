package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.java.db.HasDAOImpl;
import main.java.db.PropertyDAOImpl;
import main.java.db.UserDAOImpl;
import main.java.db.VisitDAOImpl;
import main.java.model.Has;
import main.java.model.Property;
import main.java.model.User;
import main.java.model.Visit;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UnlogVisitController {

    @FXML
    private Label title;

    @FXML
    private Label name;

    @FXML
    private Label ownerName;

    @FXML
    private Label ownerEmail;

    @FXML
    private Label numVisits;

    @FXML
    private Label address;

    @FXML
    private Label city;

    @FXML
    private Label zip;

    @FXML
    private Label size;

    @FXML
    private Label avgRating;

    @FXML
    private Label type;

    @FXML
    private Label isPublic;

    @FXML
    private Label isCommercial;

    @FXML
    private Label id;

    @FXML
    private Label cropList;

    @FXML
    private Label animalList;

    @FXML
    private Button unlogVisitButton;

    @FXML
    private Button backButton;

    public void onBack() {
        backButton.getScene().getWindow().hide();
    }

    private Property property = null;
    private UserDAOImpl users = new UserDAOImpl();
    private VisitDAOImpl visits = new VisitDAOImpl();
    private PropertyDAOImpl p = new PropertyDAOImpl();
    private HasDAOImpl has = new HasDAOImpl();
    private User u;
    private Visit v;

    @FXML
    public void setTitle(String name) {
        title.setText(name + " Details");
    }

    @FXML
    public void setProperty(Property p) {
        property = p;
        String pubtext = "No";
        String comtext = "No";
        if (property.getIsCommercial()) {
            comtext = "Yes";
        }

        if (property.getIsPublic()) {
            pubtext = "Yes";
        }
        List<Visit> v = visits.findByProperty(property.getId());
        name.setText(property.getName());
        ownerName.setText(property.getOwnerUsername());
        ownerEmail.setText(users.findByUsername(property.getOwnerUsername()).getEmail());
        address.setText(property.getStreet());
        city.setText(property.getCity());
        zip.setText(String.valueOf(property.getZipcode()));
        size.setText("" + property.getSize());
        type.setText(property.getPropertyType().toString());
        isPublic.setText(pubtext);
        isCommercial.setText(comtext);
        id.setText("" + property.getId());
        numVisits.setText("" + v.size());

        List<Has> animals;
        List<Has> crops;
        String cropL = "";
        String animalL = "";
        if (property.getPropertyType() == Property.PropertyType.FARM) {
            animals = has.findAnimalsByProperty(Integer.toString(property.getId()));
            for (Has f : animals) {
                animalL = animalL.concat(f.getItemName() + ",");
            }
            animalList.setText(animalL);
        }
        crops = has.findCropsByProperty(Integer.toString(property.getId()));
        for (Has f: crops) {
            cropL = cropL.concat(f.getItemName() + ",");
        }
        cropList.setText(cropL);

    }

    @FXML
    public void initialize() {


    }

    public void loadUser(User u) {
        this.u = u;
    }

    public void loadVisit(Visit v) {
        this.v = v;
    }

    public void onUnlog() {
        visits.deleteVisit(v);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/view/LogVisit.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Log Visit");
        try {
            stage.setScene(new Scene((Pane) loader.load(), 750, 600));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        LogVisitController controller = loader.<LogVisitController>getController();
        controller.setProperty(property);
        controller.loadUser(u);
        stage.show();
    }

}

