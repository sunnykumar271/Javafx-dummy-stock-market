/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

import java.util.Map;
import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Anshu
 */
// Create a thread class to handle graph updates
class GraphUpdateThread extends Thread {
    private XYChart.Series<Number, Number> series;
    private String sampleCompanyName;
    private Map<String, Object> Stock;
    private LineChart<Number, Number> stockChart;

    public GraphUpdateThread(String sampleCompanyName, Map<String, Object> Stock, LineChart<Number, Number> stockChart) {
        this.sampleCompanyName = sampleCompanyName;
        this.Stock = Stock;
        this.stockChart = stockChart;
        this.series = new XYChart.Series<>();
    }

    @Override
    public void run() {
        // Set series name
        series.setName(sampleCompanyName);

        // Add sample data points to the series
        series.getData().add(new XYChart.Data<>(1, Double.parseDouble(Stock.get("VALUE1").toString())));
        series.getData().add(new XYChart.Data<>(2, Double.parseDouble(Stock.get("VALUE2").toString())));
        series.getData().add(new XYChart.Data<>(3, Double.parseDouble(Stock.get("VALUE3").toString())));
        series.getData().add(new XYChart.Data<>(4, Double.parseDouble(Stock.get("VALUE4").toString())));
        series.getData().add(new XYChart.Data<>(5, Double.parseDouble(Stock.get("VALUE5").toString())));

        // Update the chart on the JavaFX Application Thread
        Platform.runLater(() -> stockChart.getData().add(series));
    }
}



