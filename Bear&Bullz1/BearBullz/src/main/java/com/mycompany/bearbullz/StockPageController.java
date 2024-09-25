/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 *
 * @author sarthak
 */
public class StockPageController {





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

    public void initialize() {
        // Load sample stock data
        

        // Set up Buy and Sell button actions
        buyButton.setOnAction(e -> handleBuyAction());
        sellButton.setOnAction(e -> handleSellAction());
    }

    public void loadSampleStockData(String Name) {
        // Sample stock data\
        HashMap<String, Object>Stock= StocksDB.getStockByName(Name);
        
        String sampleCompanyName =(String) Stock.get("NAME");
        double sampleStockRate = Double.parseDouble(Stock.get("VALUE5").toString());

        // Set the company name and rate
        companyName.setText(sampleCompanyName);
        stockRate.setText("$" + sampleStockRate);

        // Sample price history for the graph (Time, Price)
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(sampleCompanyName);

        // Add sample data points to the series
        series.getData().add(new XYChart.Data<>(1,  Double.parseDouble(Stock.get("VALUE1").toString())));
        series.getData().add(new XYChart.Data<>(2,  Double.parseDouble(Stock.get("VALUE2").toString())));
        series.getData().add(new XYChart.Data<>(3,  Double.parseDouble(Stock.get("VALUE3").toString())));
        series.getData().add(new XYChart.Data<>(4,  Double.parseDouble(Stock.get("VALUE4").toString())));
         series.getData().add(new XYChart.Data<>(5,  Double.parseDouble(Stock.get("VALUE5").toString())));

        // Add series to the stock chart
        stockChart.getData().add(series);
    }

    private void handleBuyAction() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Buy Action");
        alert.setHeaderText(null);
        alert.setContentText("You have bought stocks!");
        alert.showAndWait();
    }

    private void handleSellAction() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Sell Action");
        alert.setHeaderText(null);
        alert.setContentText("You have sold stocks!");
        alert.showAndWait();
    }
}

    

