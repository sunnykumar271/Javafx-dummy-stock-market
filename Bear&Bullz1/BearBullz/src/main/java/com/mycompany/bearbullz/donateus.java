/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vivek bisen
 */
public class donateus extends Application {

    /**
     *
     * @param primaryStage
     * @throws IOException
     */
    @Override
      public void start(Stage primaryStage) throws IOException {
        

        Parent root = FXMLLoader.load(getClass().getResource("donation.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
         scene.getStylesheets().add(getClass().getResource("Mainpanel.css").toExternalForm());
        primaryStage.setFullScreen(true);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
