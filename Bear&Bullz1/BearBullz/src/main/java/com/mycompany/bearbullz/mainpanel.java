/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.mycompany.bearbullz;

import java.io.IOException;
import java.math.BigDecimal;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author Anshu
 */
public class mainpanel extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("mainpanel.fxml"));
        
        Scene scene = new Scene(root, 300, 250);
        System.out.println("Hello");
        primaryStage.setTitle("Bear & Bullz");
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
