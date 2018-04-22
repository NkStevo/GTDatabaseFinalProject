package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

import java.io.IOException;

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

