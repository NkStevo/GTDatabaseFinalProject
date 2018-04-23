package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.db.FarmItemDAOImpl;
import main.java.model.FarmItem;
import main.java.model.User;

public class ApprovedAnimalsCropsController {

    @FXML
    private Label title;

    @FXML
    private TableView<FarmItem> approvedItems;

    @FXML
    private TableColumn<FarmItem, String> nameCol;

    @FXML
    private TableColumn<FarmItem, String> typeCol;

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

    private User user;

    public void onBack() {
        backButton.getScene().getWindow().hide();
    }

    public void loadUser(User user) { this.user = user; }

    public void loadFarmItems() {
        nameCol.setCellValueFactory(new PropertyValueFactory<FarmItem, String>("name"));
        typeCol.setCellValueFactory(new PropertyValueFactory<FarmItem, String>("itemTypeStr"));

        FarmItemDAOImpl farmItemDAO = new FarmItemDAOImpl();

        approvedItems.getItems().setAll(farmItemDAO.findPendingOrdered("Name ASC"));
    }
}

