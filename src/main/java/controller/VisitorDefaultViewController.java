package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VisitorDefaultViewController {

    @FXML
    private Label title;

    @FXML
    private ComboBox<?> searchMenu;

    @FXML
    private TextField searchTerm;

    @FXML
    private Button searchButton;

    @FXML
    private Button viewPropertyButton;

    @FXML
    private Button viewVisitHistButton;

    @FXML
    private Button logOutButton;

    @FXML
    private TableView<?> validProps;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> cityCol;

    @FXML
    private TableColumn<?, ?> zipCol;

    @FXML
    private TableColumn<?, ?> sizeCol;

    @FXML
    private TableColumn<?, ?> typeCol;

    @FXML
    private TableColumn<?, ?> publicCol;

    @FXML
    private TableColumn<?, ?> commercialCol;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> visitsCol;

    @FXML
    private TableColumn<?, ?> avgRatingCol;

}
