package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddNewPropertyController {

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
    private ComboBox<?> typeMenu;

    @FXML
    private ComboBox<?> animalMenu;

    @FXML
    private ComboBox<?> cropMenu;

    @FXML
    private ComboBox<?> publicMenu;

    @FXML
    private ComboBox<?> commercialMenu;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

}