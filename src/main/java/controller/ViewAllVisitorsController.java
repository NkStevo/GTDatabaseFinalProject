package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.db.*;
import main.java.model.User;
import main.java.model.VisitorView;

public class ViewAllVisitorsController {

    @FXML
    private Label title;

    @FXML
    private TableView<VisitorView> allVisitors;

    @FXML
    private TableColumn<VisitorView, String> usernameCol;

    @FXML
    private TableColumn<VisitorView, String> emailCol;

    @FXML
    private TableColumn<VisitorView, Integer> visitsCol;

    @FXML
    private Button delVisitorButton;

    @FXML
    private Button delHistoryButton;

    @FXML
    private Button backButton;

    @FXML
    private ComboBox<?> searchMenu;

    @FXML
    private TextField searchTerm;

    @FXML
    private Button searchButton;

    private User user;

    public void loadUser(User user) {
        this.user = user;
    }

    public void onBack() {
        backButton.getScene().getWindow().hide();
    }

    public void loadVisitors() {
        usernameCol.setCellValueFactory(new PropertyValueFactory<VisitorView, String>("username"));
        emailCol.setCellValueFactory(new PropertyValueFactory<VisitorView, String>("email"));
        visitsCol.setCellValueFactory(new PropertyValueFactory<VisitorView, Integer>("loggedVisits"));

        VisitorViewServiceImpl visitorViewService = new VisitorViewServiceImpl();

        allVisitors.getItems().setAll(visitorViewService.findAllOrdered("Username ASC", null, null));
    }
}

