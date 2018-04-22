package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdminManagePropertiesController {

    @FXML
    private Label title;

    @FXML
    private TextField nameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField zipField;

    @FXML
    private TextField sizeField;

    @FXML
    private Label type;

    @FXML
    private ComboBox<?> publicMenu;

    @FXML
    private ComboBox<?> commercialMenu;

    @FXML
    private Label id;

    @FXML
    private Label cropList;

    @FXML
    private Label animalList;

    @FXML
    private ComboBox<?> cropMenu;

    @FXML
    private Button addCropButton;

    @FXML
    private ComboBox<?> animalMenu;

    @FXML
    private Button addAnimalButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    public void onBack() {
        backButton.getScene().getWindow().hide();
    }

}

