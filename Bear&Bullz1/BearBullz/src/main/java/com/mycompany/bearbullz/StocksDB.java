/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.HashMap;
import org.bson.Document;
import org.bson.conversions.Bson;


/**
 *
 * @author Anshu
 */
public class StocksDB {
    
       public static void main(String[] args) {
     
       
       
    }
   
public static void  addStockToMongo(String name, double firstValue, double secondValue, double thirdValue, double fourthValue, double fifthValue) {
    // MongoDB Atlas connection string
    String connectionString = "mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/";

    // Create a MongoDB client and connect to the database
    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ"); // Replace with your database name
            MongoCollection<Document> collection = database.getCollection("STOCKS"); // Replace with your collection name

        // Calculate percent change
        double percentChange = ((fifthValue - fourthValue) / fourthValue) * 100;

        // Create the stock document
            Document doc = new Document("NAME", name)
                .append("VALUE1", firstValue)
                .append("VALUE2", secondValue)
                .append("VALUE3", thirdValue)
                .append("VALUE4", fourthValue)
                .append("VALUE5", fifthValue)
                .append("CHANGE_PERC", percentChange);

        // Insert the document into the collection
        collection.insertOne(doc);
    }
}
public static void updateStockValues(String name, double newValue) {
    // MongoDB Atlas connection string
    String connectionString = "mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/";

    // Create a MongoDB client and connect to the database
    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ"); // Replace with your database name
        MongoCollection<Document> collection = database.getCollection("STOCKS"); // Replace with your collection name

        // Find the stock document by name
        Document stock = collection.find(Filters.eq("NAME", name)).first();

        if (stock != null) {
            // Get the current values
            double previousValue5 = stock.getDouble("VALUE5");
            double previousValue4 = stock.getDouble("VALUE4");
            double previousValue3 = stock.getDouble("VALUE3");
            double previousValue2 = stock.getDouble("VALUE2");
            double previousValue1 = stock.getDouble("VALUE1");

            // Calculate the new CHANGE_PERC
            double newChangePerc = ((newValue - previousValue4) / previousValue4) * 100;

            // Create the updates
            Bson updates = Updates.combine(
                    Updates.set("VALUE5", newValue),          // New current value
                    Updates.set("VALUE4", previousValue5),    // Previous VALUE5 becomes VALUE4
                    Updates.set("VALUE3", previousValue4),    // Previous VALUE4 becomes VALUE3
                    Updates.set("VALUE2", previousValue3),    // Previous VALUE3 becomes VALUE2
                    Updates.set("VALUE1", previousValue2),    // Previous VALUE2 becomes VALUE1
                    Updates.set("CHANGE_PERC", newChangePerc) // Update CHANGE_PERC
            );

            collection.updateOne(Filters.eq("NAME", name), updates);
            System.out.println("Updated stock: " + name);
        } else {
            System.out.println("Stock not found: " + name);
        }
    }
}
public static HashMap<String, Object> getStockByName(String name) {
    HashMap<String, Object> stockMap = new HashMap<>();

    // MongoDB Atlas connection string
    String connectionString = "mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/";

    // Create a MongoDB client and connect to the database
    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ"); // Replace with your database name
        MongoCollection<Document> collection = database.getCollection("STOCKS"); // Replace with your collection name

        // Find the stock document by name
        Document stock = collection.find(Filters.eq("NAME", name)).first();

        if (stock != null) {
            // Convert the Document to a HashMap
            for (String key : stock.keySet()) {
                stockMap.put(key, stock.get(key));
            }
        } else {
            System.out.println("Stock not found: " + name);
        }
    }
    
    return stockMap;
}

}
