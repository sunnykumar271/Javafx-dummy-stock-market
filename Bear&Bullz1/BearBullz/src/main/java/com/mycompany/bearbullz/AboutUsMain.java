package com.mycompany.bearbullz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AboutUsMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load FXML file
        Parent root = FXMLLoader.load(getClass().getResource("about_us1.fxml"));
        primaryStage.setTitle("About Us");
        
        // Set the scene with a given width and height
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
