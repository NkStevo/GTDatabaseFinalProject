package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.db.UserDAOImpl;
import main.java.model.Property;
import main.java.model.User;

import javax.print.DocFlavor;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private ComboBox<Property.PropertyType> typeMenu;

    @FXML
    private ComboBox<?> animalMenu;

    @FXML
    private ComboBox<?> cropMenu;

    @FXML
    private ComboBox<String> publicMenu;

    @FXML
    private ComboBox<String> commercialMenu;

    @FXML
    private Button registerButton;

    @FXML
    private Button cancelButton;

    @FXML
    public void initialize() {
        ObservableList<Property.PropertyType> propTypes = FXCollections.observableArrayList(Property.PropertyType.FARM, Property.PropertyType.ORCHARD, Property.PropertyType.GARDEN);
        typeMenu.setItems(propTypes);

        ObservableList<String> commercial = FXCollections.observableArrayList("YES", "NO");
        commercialMenu.setItems(commercial);

        ObservableList<String> publicType = FXCollections.observableArrayList("YES", "NO");
        publicMenu.setItems(publicType);


    }

    public void onCancel() {
        cancelButton.getScene().getWindow().hide();
    }

    public void onRegister() {
    try {
        User x = null;
        User y = null;
        MessageDigest md = MessageDigest.getInstance("MD5");
        UserDAOImpl userDAO = new UserDAOImpl();

        String email = emailField.getText();
        String password = (new HexBinaryAdapter()).marshal(md.digest(passwordField.getText().
                getBytes("UTF-8")));
        String username = usernameField.getText();
        String conf_pass = (new HexBinaryAdapter().marshal(md.digest(confirmPassField.getText().
                getBytes("UTF-8"))));

        String propName = propNameField.getText();
        String address = streetField.getText();

        String city = cityField.getText();
        String zip = zipField.getText();

        String acres = sizeField.getText();


        x = userDAO.findByUsername(username);
        y = userDAO.findByEmail(email);

        Pattern emailPat = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher emailMat = emailPat.matcher(email);

        Pattern zipPat = Pattern.compile("[0-9]{5}");
        Matcher zipMat = zipPat.matcher(zip);

        if (typeMenu.getValue() == Property.PropertyType.FARM) {

        } else if (typeMenu.getValue() == Property.PropertyType.GARDEN) {
            animalMenu.hide();

        } else if (typeMenu.getValue() == Property.PropertyType.ORCHARD) {

        }




    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    }

}


