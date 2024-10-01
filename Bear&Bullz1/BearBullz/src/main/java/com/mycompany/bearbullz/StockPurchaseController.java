/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

/**
 *
 * @author Anshu
 */
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StockPurchaseController {
String email;
    Stage stage;
public void setStage(Stage stage)
{
    this.stage=stage;
}
    public int balance;

    @FXML
    private Label stockNameLabel;

    @FXML
    public Label value;

    @FXML
    private Label tokenCountLabel;

    @FXML
    private Button incrementButton;

    @FXML
    private Button decrementButton;

    @FXML
    private Button buyButton;

    public int tokenCount = 0;
    public int value1;

    @FXML
    public void initialize() {
        
        // Increment token count when the up arrow is pressed
        incrementButton.setOnAction(event -> {
            if ((tokenCount + 1) * value1 <= balance) {
                tokenCount++;
                tokenCountLabel.setText(String.valueOf(tokenCount));
            }
        });

        // Decrement token count when the down arrow is pressed (but not below 0)
        decrementButton.setOnAction(event -> {
            if (tokenCount > 0) {
                tokenCount--;
                tokenCountLabel.setText(String.valueOf(tokenCount));
            }
        });
    }

    public void setvalue(int value,String email) {
        value1 = value;
        this.value.setText(String.valueOf(value));
        this.email=email;
        balance =UsersDB.getBalance(email);
    }

    // Call this method to set the stock name
    public void setStockName(String stockName) {
        stockNameLabel.setText(stockName);
    }

    // Method to handle the "Buy" button action
    @FXML
    private void handleBuyButton() throws IOException {
        // Ensure the total cost is less than or equal to balance
        if (tokenCount * value1 <= balance) {
            System.out.println("Buying " + tokenCount + " tokens for stock: " + stockNameLabel.getText());
            UsersDB.updateStock( email,stockNameLabel.getText(),tokenCount , tokenCount*value1);
            UsersDB.setBalance(email, balance-tokenCount*value1);
            

           
            // Set up the scene and stage
            FXMLLoader loader=new FXMLLoader(getClass().getResource("mainpanel.fxml"));
        Parent root = loader.load();
        mainpanelcontroller mpc=loader.getController();
        mpc.setStage(stage);
        mpc.setGmail(email);
        Scene scene=new Scene(root);
        mpc.setStage(stage);
        mpc.setName(UsersDB.getNameByEmail(email),String.valueOf(UsersDB.getBalance(email))+"coins");
        scene.getStylesheets().add(getClass().getResource("Mainpanel.css").toExternalForm());
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        } else {
            System.out.println("Insufficient balance to buy " + tokenCount + " tokens.");
        }
    }
}
