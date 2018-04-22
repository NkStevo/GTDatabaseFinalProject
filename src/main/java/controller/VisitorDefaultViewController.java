package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class VisitorDefaultViewController {

    @FXML
    private Label title;

    @FXML
    private ComboBox<?> searchMenu;

    @FXML
    private TextField searchTerm;

    @FXML
    private Button searchButton;

    @FXML
    private Button viewPropertyButton;

    @FXML
    private Button viewVisitHistButton;

    @FXML
    private Button logOutButton;

    @FXML
    private TableView<?> validProps;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> cityCol;

    @FXML
    private TableColumn<?, ?> zipCol;

    @FXML
    private TableColumn<?, ?> sizeCol;

    @FXML
    private TableColumn<?, ?> typeCol;

    @FXML
    private TableColumn<?, ?> publicCol;

    @FXML
    private TableColumn<?, ?> commercialCol;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> visitsCol;

    @FXML
    private TableColumn<?, ?> avgRatingCol;

    public void onBack() {
        logOutButton.getScene().getWindow().hide();
    }

    public void onProperty() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/LogVisit.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("Log Visit");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();

    }

    public void onClickHistory() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/VisitorHistory.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("Visit History");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

}

