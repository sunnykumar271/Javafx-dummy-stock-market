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
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StockSellController {
    HashMap<String,Object> data;
    Stage stage;
    void setStage(Stage stage)
    {this.stage=stage;
    }
    public int ownedTokens;  // Total stocks/tokens the user currently owns
    String email;
    String stockName;
    
    void setEmail(String email)
    {
        this.email=email;
        data=UsersDB.getStockByEmailAndName(email, stockName);
        ownedTokens=Integer.parseInt(data.get("QUANTITY").toString());
    }
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
    private Button sellButton;

    public int tokenCount = 0;
    public int value1;
   
    @FXML
    public void initialize() {
        // Increment token count when the up arrow is pressed (but not more than owned tokens)
        incrementButton.setOnAction(event -> {
            if (tokenCount < ownedTokens) {
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

    public void setvalue(int value) {
        value1 = value;
        this.value.setText(String.valueOf(value));
    }

    // Call this method to set the stock name
    public void setStockName(String stockName) {
        this.stockName=stockName;
        stockNameLabel.setText(stockName);
    }

    public void setOwnedTokens(int tokens) {
        this.ownedTokens = tokens;
        tokenCountLabel.setText(String.valueOf(0)); // Reset token count
    }

    // Method to handle the "Sell" button action
    @FXML
    private void handleSellButton() throws IOException {
        // Ensure the user is selling an amount they own
        if (tokenCount <= ownedTokens) {
            UsersDB.setBalance(email,UsersDB.getBalance(email)+ tokenCount*value1);
            UsersDB.sellStock(email, stockName, tokenCount, tokenCount*value1);
            System.out.println("Selling " + tokenCount + " tokens for stock: " + stockNameLabel.getText());
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
            System.out.println("You cannot sell more tokens than you own.");
        }
    }
}

