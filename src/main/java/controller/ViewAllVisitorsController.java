package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.java.db.*;

public class ViewAllVisitorsController {

    @FXML
    private Label title;

    @FXML
    private TableView<?> allVisitors;

    @FXML
    private TableColumn<?, ?> usernameCol;

    @FXML
    private TableColumn<?, ?> emailCol;

    @FXML
    private TableColumn<?, ?> visitsCol;

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

    @FXML
    public void initialize() {

    }

    public void onBack() {
        backButton.getScene().getWindow().hide();
    }
}

