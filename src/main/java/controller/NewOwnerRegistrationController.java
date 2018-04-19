package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NewOwnerRegistrationController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPassField;

    @FXML
    private TextField propNameField;

    @FXML
    private TextField streetField;

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
    private Button registerButton;

    @FXML
    private Button cancelButton;

}

