package com.mycompany.bearbullz;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Anshu
 */
public class HomePageController  {

    /**
     * Initializes the controller class.
     */
    @FXML
    VBox stockscontainer;
    public void initialize() {
        System.out.println("Homepage");
        ArrayList<HashMap<String,Object>> stocks =StocksDB.getStocksSortedByChangePerc();
        int i = 1;
        // Creating UI elements for each user
        for (HashMap a : stocks) {
            HBox userCard = createUserCard(i++,a.get("NAME").toString(),
                                           Double.parseDouble(a.get("VALUE5").toString()),
                                           Double.parseDouble(a.get("CHANGE_PERC").toString()));
            
            stockscontainer.getChildren().add(userCard);
        }
    }
    public void start()
    {
        
    }
     private HBox createUserCard(int indexNumber, String Name, double Value,double change) {
        HBox card = new HBox();
      card.getStyleClass().add("user-card");
      
        // Add the index number before the username
        Label indexLabel = new Label(String.valueOf(indexNumber));
        indexLabel.getStyleClass().add("index-number");

        Label usernameLabel = new Label(Name);
        usernameLabel.getStyleClass().add("username");

        Label balanceLabel = new Label("Current Value:" + Value);
        balanceLabel.getStyleClass().add("balance-coins");
        Label change1 = new Label(String.format("%.2f",change)+"%");
        if(change>0)
        change1.setTextFill(Color.GREEN);
        else change1.setTextFill(Color.RED);
        balanceLabel.getStyleClass().add("balance-coins");
        
        // The order now places index before the username
        card.getChildren().addAll(indexLabel, usernameLabel, balanceLabel,change1);
        card.setOnMouseClicked(event -> {
        // Your code for handling the click event
        System.out.println("Card clicked: " + Name);
        // You can also perform more complex actions here like navigating or updating data
    });
        return card;
    }
    
}
