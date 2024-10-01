/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
/**
 *
 * @author sarthak
 */
public class StockPageController {



String sampleCompanyName;
String email;
Stage stage;
public void setStage(Stage stage)
{
    this.stage=stage;
}
    @FXML
    private LineChart<Number, Number> stockChart;

    @FXML
    private Label companyName;

    @FXML
    private Label stockRate;

    @FXML
    private Button buyButton;

    @FXML
    private Button sellButton;
    
      HashMap<String, Object>Stock;
    public void initialize() {
        // Load sample stock data
        

        // Set up Buy and Sell button actions
        buyButton.setOnAction(e -> {
            try {
                handleBuyAction();
            } catch (IOException ex) {
                Logger.getLogger(StockPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        sellButton.setOnAction(e -> {
            try {
                handleSellAction();
            } catch (IOException ex) {
                Logger.getLogger(StockPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void loadSampleStockData(String Name) {
        // Sample stock data\
        Stock= StocksDB.getStockByName(Name);
        
         sampleCompanyName =(String) Stock.get("NAME");
        double sampleStockRate = Double.parseDouble(Stock.get("VALUE5").toString());

        // Set the company name and rate
        companyName.setText(sampleCompanyName);
        stockRate.setText("$" + sampleStockRate);
        GraphUpdateThread graphUpdateThread = new GraphUpdateThread(sampleCompanyName, Stock, stockChart);
graphUpdateThread.start();
        // Sample price history for the graph (Time, Price)
//        XYChart.Series<Number, Number> series = new XYChart.Series<>();
//        series.setName(sampleCompanyName);
//
//        // Add sample data points to the series
//        series.getData().add(new XYChart.Data<>(1,  Double.parseDouble(Stock.get("VALUE1").toString())));
//        series.getData().add(new XYChart.Data<>(2,  Double.parseDouble(Stock.get("VALUE2").toString())));
//        series.getData().add(new XYChart.Data<>(3,  Double.parseDouble(Stock.get("VALUE3").toString())));
//        series.getData().add(new XYChart.Data<>(4,  Double.parseDouble(Stock.get("VALUE4").toString())));
//         series.getData().add(new XYChart.Data<>(5,  Double.parseDouble(Stock.get("VALUE5").toString())));
//
//        // Add series to the stock chart
//        stockChart.getData().add(series);
    }

    private void handleBuyAction() throws IOException {
//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.setTitle("Buy Action");
//        alert.setHeaderText(null);
//        alert.setContentText("You have bought stocks!");
//        alert.showAndWait();
// Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StockBuying.fxml"));
            Parent root = loader.load();

            // Get the controller instance and set the stock name
            StockPurchaseController controller = loader.getController();
            controller.setStockName(sampleCompanyName);  // You can set the stock name dynamically here
            controller.email=email;
            System.out.println("Value"+controller.value1);
            controller.setvalue((int) Double.parseDouble(Stock.get("VALUE5").toString()),email);
            // Set up the scene and stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
            controller.setStage(stage);
           
    }

    private void handleSellAction() throws IOException {
        // Load the FXML file for stock selling
            FXMLLoader loader = new FXMLLoader(getClass().getResource("stock_sell.fxml"));
            Parent root = loader.load();

            // Get the controller instance
            StockSellController controller = loader.getController();
            
            // Set the stock name dynamically
            controller.setStockName(sampleCompanyName);
            
            // Set the email dynamically
            controller.setEmail(email);  // Ensure this method is defined in StockSellController

            // Set the stock value (parsed from the Stock map)
            controller.setvalue((int) Double.parseDouble(Stock.get("VALUE5").toString()));

            // Set up the scene and stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
            // Set the stage for the controller (if necessary for handling closing, etc.)
            controller.setStage(stage);
            
            stage.show();
    }
}


    

