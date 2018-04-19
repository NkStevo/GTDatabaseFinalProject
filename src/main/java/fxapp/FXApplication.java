package main.java.fxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FXApplication extends Application {
    private Connection conn;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/view/UserLoginWindow.fxml"));
        primaryStage.setTitle("User Login");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu/cs4400_team_58",
                    "cs4400_team_58",
                    "pqMWvchC");
            if(!conn.isClosed())
                System.out.println("Successfully connected to " +
                        "MySQL server using TCP/IP...");
        } catch(Exception e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if(conn != null)
                    conn.close();
            } catch(SQLException e) {}
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}