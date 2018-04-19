package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PendingAnimalCropsController {

    @FXML
    private Label title;

    @FXML
    private TableView<?> pendingItems;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> typeCol;

    @FXML
    private Button approveButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button backButton;

}

