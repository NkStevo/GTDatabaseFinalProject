package main.resources.sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

	public void onClickLogin() {
		//SUBMIT QUERY TO DATABASE
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
