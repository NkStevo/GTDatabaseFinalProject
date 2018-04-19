package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class OwnerManagePropertiesController {

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
    private ComboBox<?> approvedCropMenu;

    @FXML
    private Button addCropButton;

    @FXML
    private TextField cropName;

    @FXML
    private ComboBox<?> cropTypeMenu;

    @FXML
    private Button submitButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

}

