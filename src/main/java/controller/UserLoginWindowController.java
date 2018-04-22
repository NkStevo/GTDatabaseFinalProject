package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.db.UserDAOImpl;
import main.java.model.User;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserLoginWindowController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button newOwnerButton;

    @FXML
    private Button newVisitorButton;

    public void onClickLogin() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            UserDAOImpl userDAO = new UserDAOImpl();

            String email = emailField.getText();
            String password = (new HexBinaryAdapter()).marshal(md.digest(passwordField.getText().
                    getBytes("UTF-8")));

            User user = userDAO.findByEmail(email);
            Stage stage;
            Parent root = null;
            if (user.getPassword().equalsIgnoreCase(password)) {
                switch (user.getUserType()) {
                    case ADMIN:
                        try {
                            root = FXMLLoader.load(getClass().getResource("/main/resources/view/AdminDefaultView.fxml"));
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                        stage = new Stage();
                        stage.setTitle("Admin View");
                        stage.setScene(new Scene(root, 750, 600));
                        stage.show();
                        break;
                    case OWNER:
                        try {
                            root = FXMLLoader.load(getClass().getResource("/main/resources/view/OwnerDefaultView.fxml"));
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                        stage = new Stage();
                        stage.setTitle("Owner View");
                        stage.setScene(new Scene(root, 750, 600));
                        stage.show();
                        break;
                    case VISITOR:
                        try {
                            root = FXMLLoader.load(getClass().getResource("/main/resources/view/VisitorDefaultView.fxml"));
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                        stage = new Stage();
                        stage.setTitle("Visitor View");
                        stage.setScene(new Scene(root, 750, 600));
                        stage.show();
                        break;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    public void onClickNewOwnerRegistration() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/NewOwnerRegistration.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("New Owner Registration");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

    public void onClickNewVisitorRegistration() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/NewVisitorRegistration.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("New Visitor Registration");
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

}

