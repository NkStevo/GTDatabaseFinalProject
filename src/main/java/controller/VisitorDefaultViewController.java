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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.java.model.Property;
import main.java.model.User;

import java.io.IOException;

public class VisitorDefaultViewController {

    private User me;

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

    public Property p = new Property(0, "Atwood Street Garden", 1.0f, false, true, "Atwood Street SW", "Atlanta",30308, Property.PropertyType.GARDEN, "gardenowner");


    @FXML
    public void setTitle(String name) {
        title.setText("Welcome " + name);

    }

    public void onBack() {
        logOutButton.getScene().getWindow().hide();
    }

    public void onProperty() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/view/LogVisit.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Log Visit");
        try {
            stage.setScene(new Scene((Pane) loader.load(), 750, 600));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //p = (Property)validProps.getSelectionModel().getSelectedItem();
        LogVisitController vc = loader.<LogVisitController>getController();
        vc.setTitle(p.getName());
        vc.setProperty(p);
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

