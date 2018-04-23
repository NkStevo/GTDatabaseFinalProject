package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.db.OwnerViewServiceImpl;
import main.java.model.OwnerView;
import main.java.model.User;

public class ViewAllOwnersController {

    @FXML
    private Label title;

    @FXML
    private TableView<OwnerView> allOwners;

    @FXML
    private TableColumn<OwnerView, String> usernameCol;

    @FXML
    private TableColumn<OwnerView, String> emailCol;

    @FXML
    private TableColumn<OwnerView, Integer> numPropertiesCol;

    @FXML
    private Button deleteButton;

    @FXML
    private Button backButton;

    @FXML
    private ComboBox<?> searchMenu;

    @FXML
    private TextField searchTerm;

    @FXML
    private Button searchButton;

    private User user;

    public void onBack() {
        backButton.getScene().getWindow().hide();
    }

    public void loadUser(User user) {
        this.user = user;
    }

    public void loadOwners() {
        usernameCol.setCellValueFactory(new PropertyValueFactory<OwnerView, String>("username"));
        emailCol.setCellValueFactory(new PropertyValueFactory<OwnerView, String>("email"));
        numPropertiesCol.setCellValueFactory(new PropertyValueFactory<OwnerView, Integer>("numOfProperties"));

        OwnerViewServiceImpl ownerViewService = new OwnerViewServiceImpl();

        allOwners.getItems().setAll(ownerViewService.findAllOrdered("Username ASC", null, null));
    }
}

