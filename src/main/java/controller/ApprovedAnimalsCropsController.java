package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ApprovedAnimalsCropsController {

    @FXML
    private Label title;

    @FXML
    private TableView<?> approvedItems;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> typeCol;

    @FXML
    private ComboBox<?> typeMenu;

    @FXML
    private TextField approveName;

    @FXML
    private Button approveButton;

    @FXML
    private ComboBox<?> searchMenu;

    @FXML
    private TextField searchTerm;

    @FXML
    private Button searchButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button backButton;

    public void onBack() {
        backButton.getScene().getWindow().hide();
    }

}

