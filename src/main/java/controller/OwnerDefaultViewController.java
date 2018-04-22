package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.java.model.User;

import java.io.IOException;
import java.security.acl.Owner;

public class OwnerDefaultViewController {

    private User me;

    @FXML
    private Label title;

    @FXML
    private Label propertyName;

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
    private Button logOutButton;


    public void onLogOut() {
        logOutButton.getScene().getWindow().hide();
    }

    @FXML
    public void initialize(){
    }

    @FXML
    public void setOwnerName(String name) {
        ownerName.setText(name);
    }

    public void onAddProperty() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/view/AddNewProperty.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Add New Property");
        try {
            stage.setScene(new Scene((Pane) loader.load(), 750, 600));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        AddNewPropertyController add = loader.<AddNewPropertyController>getController();
        add.setTitle(ownerName.getText().substring(7));
        stage.show();
    }

    public void onViewOthers() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/ViewOtherOwnersProperties.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("View Other Owners' Properties");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

    public void onManageProperty() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/OwnerManageProperties.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("Manage Property ");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

}

