package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.java.db.*;
import main.java.model.FarmItem;
import main.java.model.Has;
import main.java.model.Property;
import main.java.model.Visit;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.util.List;

public class LogVisitController {

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
    private Button logVisitButton;

    @FXML
    private Button backButton;

    @FXML
    private Rating ratingTool;

    private Property property = null;
    private UserDAOImpl users = new UserDAOImpl();
    private VisitDAOImpl visits = new VisitDAOImpl();
    private PropertyDAOImpl p = new PropertyDAOImpl();
    private HasDAOImpl has = new HasDAOImpl();

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

    public void onBack() {
        backButton.getScene().getWindow().hide();
    }

    public void onLog() {
        //LOG VISIT

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/UnlogVisit.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("Unlog Visit");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }
}

