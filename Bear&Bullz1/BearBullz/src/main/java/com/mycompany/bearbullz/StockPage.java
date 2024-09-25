/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

/**
 *
 * @author sarthak
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class StockPage extends Application {
    
   
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StockPage.fxml"));
        Parent root = loader.load();
        StockPageController mpc=loader.getController();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stockpage.css").toExternalForm());
        primaryStage.setTitle("Stock Trading App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
