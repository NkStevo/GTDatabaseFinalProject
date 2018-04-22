package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDefaultViewController {

    @FXML
    private Label title;

    @FXML
    private Button visitorListButton;

    @FXML
    private Button ownerListButton;

    @FXML
    private Button confirmedPropButton;

    @FXML
    private Button unconfirmedPropButton;

    @FXML
    private Button ApprovedItemsButton;

    @FXML
    private Button pendingItemsButton;

    @FXML
    private Button logOutButton;

    public void onClickVisitorsList() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/ViewAllVisitors.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("View Visitors List");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

    public void onClickOwnersList() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/ViewAllOwners.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("View Owners List");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();

    }

    public void onConfirmedProperties() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/ConfirmedProperties.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("View Confirmed Properties");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();

    }

    public void onUnconfirmedProperties() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/UnconfirmedProperties.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("View Unconfirmed Properties");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();

    }

    public void onApproved() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/ApprovedAnimalsCrops.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("Approved Animals and Crops");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();

    }

    public void onPending() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/PendingAnimalsCrops.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("Pending Animals and Crops");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

    public void onLogout() {
        logOutButton.getScene().getWindow().hide();
    }
}

