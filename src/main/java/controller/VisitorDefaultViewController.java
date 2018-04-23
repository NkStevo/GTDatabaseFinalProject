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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.java.db.PropertyViewServiceImpl;
import main.java.model.Property;
import main.java.model.PropertyView;
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
    private TableView<PropertyView> validProperties;

    @FXML
    private TableColumn<PropertyView, String> nameCol;

    @FXML
    private TableColumn<PropertyView, String> addressCol;

    @FXML
    private TableColumn<PropertyView, String> cityCol;

    @FXML
    private TableColumn<PropertyView, Integer> zipCol;

    @FXML
    private TableColumn<PropertyView, Float> sizeCol;

    @FXML
    private TableColumn<PropertyView, String> typeCol;

    @FXML
    private TableColumn<PropertyView, Boolean> publicCol;

    @FXML
    private TableColumn<PropertyView, Boolean> commercialCol;

    @FXML
    private TableColumn<PropertyView, Integer> idCol;

    @FXML
    private TableColumn<PropertyView, Integer> visitsCol;

    @FXML
    private TableColumn<PropertyView, Integer> avgRatingCol;

    private User user;


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
        LogVisitController vc = loader.<LogVisitController>getController();
        PropertyView p = validProperties.getSelectionModel().getSelectedItem();
        vc.setTitle(p.getName());
        vc.setProperty(p);
        vc.loadUser(this.user);
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

    public void loadUser(User user) {
        this.user = user;
    }

    public void loadProperties() {
        nameCol.setCellValueFactory(new PropertyValueFactory<PropertyView, String>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<PropertyView, String>("street"));
        cityCol.setCellValueFactory(new PropertyValueFactory<PropertyView, String>("city"));
        zipCol.setCellValueFactory(new PropertyValueFactory<PropertyView, Integer>("zipcode"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<PropertyView, Float>("size"));
        typeCol.setCellValueFactory(new PropertyValueFactory<PropertyView, String>("propertyType"));
        publicCol.setCellValueFactory(new PropertyValueFactory<PropertyView, Boolean>("isPublic"));
        commercialCol.setCellValueFactory(new PropertyValueFactory<PropertyView, Boolean>("isCommercial"));
        idCol.setCellValueFactory(new PropertyValueFactory<PropertyView, Integer>("id"));
        visitsCol.setCellValueFactory(new PropertyValueFactory<PropertyView, Integer>("visits"));
        avgRatingCol.setCellValueFactory(new PropertyValueFactory<PropertyView, Integer>("averageRating"));

        PropertyViewServiceImpl propertyViewService = new PropertyViewServiceImpl();

        validProperties.getItems().setAll(propertyViewService.findAllOtherConfirmedOrdered("Name ASC", null, null, user.getUsername()));
    }
}

