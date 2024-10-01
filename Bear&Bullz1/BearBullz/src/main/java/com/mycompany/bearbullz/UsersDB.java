/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Indexes.ascending;
import com.mongodb.client.model.Updates;
import static com.mongodb.client.model.Updates.inc;
import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Updates.unset;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author mayur
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsersDB {
      public static void main(String[] args) {
        // Example usage
         System.out.println(getBalance("2"));
         setBalance("2",500);
         System.out.println(getBalance("2"));
        
    }
   
    public static boolean updateUser(String email, HashMap<String, Object> updates) {
        // Connect to MongoDB Atlas (replace <connection_string> with your actual connection string)
        MongoClient mongoClient = MongoClients.create("mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/");
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ");
        MongoCollection<Document> collection = database.getCollection("USERS");

        // Build the update fields from the HashMap
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            collection.updateOne(eq("GMAIL", email), Updates.set(entry.getKey(), entry.getValue()));
        }

        // Close the MongoClient connection
        mongoClient.close();
        return true;
    }
     public static String getNameByEmail(String email) {
        // Connect to MongoDB Atlas (replace <connection_string> with your actual connection string)
         MongoClient mongoClient = MongoClients.create("mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/");
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ");
        MongoCollection<Document> collection = database.getCollection("USERS");


        // Find the document by GMAIL
        Document userDoc = collection.find(eq("GMAIL", email)).first();


        mongoClient.close();

        // Return the value of the NAME field if document exists, otherwise null
        if (userDoc != null) {
            return userDoc.getString("NAME");
        } else {
            return null;  // User not found

        }
    }
     // Method to fetch the user's document as a HashMap using GMAIL
    public static HashMap<String, Object> getUserDataByEmail(String email) {
        // Connect to MongoDB Atlas (replace <connection_string> with your actual connection string)
        MongoClient mongoClient = MongoClients.create("mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/");
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ");
        MongoCollection<Document> collection = database.getCollection("USERS");

        // Find the document by GMAIL
        Document userDoc = collection.find(eq("GMAIL", email)).first();

        // Close the connection
        mongoClient.close();

        // Convert the Document to HashMap and return it if the document exists
        if (userDoc != null) {
            HashMap<String, Object> userData = new HashMap<>();
            Set<String> keys = userDoc.keySet();
            for (String key : keys) {
                userData.put(key, userDoc.get(key));
            }
            return userData;
        } else {
            return null;  // User not found
        }
    }
    // Method to fetch all user documents sorted by BALANCE and return an array of HashMaps
    public static ArrayList<HashMap<String, Object>> getAllUsersSortedByBalance() {
        // Connect to MongoDB Atlas (replace <connection_string> with your actual connection string)
       MongoClient mongoClient = MongoClients.create("mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/");
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ");
        MongoCollection<Document> collection = database.getCollection("USERS");

        // Find all documents sorted by BALANCE in ascending order
        MongoCursor<Document> cursor = collection.find().sort(ascending("BALANCE")).iterator();

        // Create an ArrayList to store the HashMaps for each user
        ArrayList<HashMap<String, Object>> sortedUsers = new ArrayList<>();

        try {
            // Loop through the sorted documents and add them as HashMaps to the list
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                HashMap<String, Object> userData = new HashMap<>();
                for (Map.Entry<String, Object> entry : doc.entrySet()) {
                    userData.put(entry.getKey(), entry.getValue());
                }
                sortedUsers.add(userData);  // Add each document's data as a HashMap to the list
            }
        } finally {
            cursor.close();
            mongoClient.close();
        }
        Collections.reverse(sortedUsers);
        return sortedUsers;  // Return the ArrayList of HashMaps
    }
    // Method to update stock data for a given user by GMAIL
    public static void updateStock(String email, String stockName, int numberOfStocks, int amountInvested) {
        // Connect to MongoDB Atlas (replace <connection_string> with your actual connection string)
         MongoClient mongoClient = MongoClients.create("mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/");
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ");
        MongoCollection<Document> collection = database.getCollection("USERS");

        // Check if the user has an existing stock entry for the given stock name
        Document userDoc = collection.find(eq("GMAIL", email)).first();
        if (userDoc != null) {
            Document stocks = (Document) userDoc.get("STOCKS");

            // If stock entry exists, increment the quantity and investment
            if (stocks != null && stocks.containsKey(stockName)) {
                collection.updateOne(
                    eq("GMAIL", email),
                    Updates.combine(
                        inc("STOCKS." + stockName + ".QUANTITY", numberOfStocks),
                        inc("STOCKS." + stockName + ".INVESTMENT", amountInvested)
                    )
                );
            } else {
                // If stock entry does not exist, create a new one
                Document newStockData = new Document("QUANTITY", numberOfStocks)
                        .append("INVESTMENT", amountInvested);
                collection.updateOne(
                    eq("GMAIL", email),
                    set("STOCKS." + stockName, newStockData)
                );
            }
        }

        // Close the connection
        mongoClient.close();
    }
  // Method to fetch single stock data by GMAIL and stock name
    public static HashMap<String, Object> getStockByEmailAndName(String email, String stockName) {
        // Connect to MongoDB Atlas (replace <connection_string> with your actual connection string)
     MongoClient mongoClient = MongoClients.create("mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/");
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ");
        MongoCollection<Document> collection = database.getCollection("USERS");

        // Find the user's document by GMAIL
        Document userDoc = collection.find(eq("GMAIL", email)).first();

        // Close the connection
        mongoClient.close();

        // Check if the user document and stocks exist
        if (userDoc != null && userDoc.containsKey("STOCKS")) {
            Document stocks = (Document) userDoc.get("STOCKS");

            // Check if the specific stock exists
            if (stocks.containsKey(stockName)) {
                Document stockDoc = (Document) stocks.get(stockName);

                // Convert the stock data to a HashMap and return it
                HashMap<String, Object> stockData = new HashMap<>();
                stockData.put("QUANTITY", stockDoc.get("QUANTITY"));
                stockData.put("INVESTMENT", stockDoc.get("INVESTMENT"));

                return stockData;  // Return stock data
            }
        }

        return null;  // Return null if stock not found
    }
     // Method to fetch all stocks of a user, sorted by investment (decreasing)
    public static ArrayList<HashMap<String, Object>> getSortedStocksByInvestment(String email) {
        // Connect to MongoDB Atlas (replace <connection_string> with your actual connection string)
       MongoClient mongoClient = MongoClients.create("mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/");
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ");
        MongoCollection<Document> collection = database.getCollection("USERS");

        // Find the user's document by GMAIL
        Document userDoc = collection.find(eq("GMAIL", email)).first();

        // Close the connection
        mongoClient.close();

        ArrayList<HashMap<String, Object>> sortedStocksList = new ArrayList<>();

        // Check if the user document and stocks exist
        if (userDoc != null && userDoc.containsKey("STOCKS")) {
            Document stocks = (Document) userDoc.get("STOCKS");

            // Iterate over the stocks
            for (Map.Entry<String, Object> stockEntry : stocks.entrySet()) {
                String stockName = stockEntry.getKey();
                Document stockDoc = (Document) stockEntry.getValue();

                // Create a HashMap for each stock
                HashMap<String, Object> stockData = new HashMap<>();
                stockData.put("STOCK_NAME", stockName);
                stockData.put("QUANTITY", stockDoc.get("QUANTITY"));
                stockData.put("INVESTMENT", stockDoc.get("INVESTMENT"));

                // Add the stock data to the list
                sortedStocksList.add(stockData);
            }

            // Sort the list by INVESTMENT in decreasing order
            sortedStocksList.sort((stock1, stock2) -> {
                int investment1 = ((Number) stock1.get("INVESTMENT")).intValue();
                int investment2 = ((Number) stock2.get("INVESTMENT")).intValue();
                return Integer.compare(investment2, investment1); // Sort in descending order
            });
        }

        return sortedStocksList;  // Return sorted list
    }
    // Method to get the balance for a user by GMAIL
    public static int getBalance(String email) {
        // Connect to MongoDB Atlas (replace <connection_string> with your actual connection string)
        MongoClient mongoClient = MongoClients.create("mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/");
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ");
        MongoCollection<Document> collection = database.getCollection("USERS");
        // Find the user's document by GMAIL
        Document userDoc = collection.find(eq("GMAIL", email)).first();

        // Close the connection
        mongoClient.close();

        // If the user document exists, return the balance
        if (userDoc != null && userDoc.containsKey("BALANCE")) {
            return ((Number) userDoc.get("BALANCE")).intValue();  // Convert to int
        }

        // Return 0 if no balance found
        return 0;
    }
     // Method to set the balance for a user by GMAIL
    public static void setBalance(String email, int newBalance) {
        // Connect to MongoDB Atlas (replace <connection_string> with your actual connection string)
       MongoClient mongoClient = MongoClients.create("mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/");
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ");
        MongoCollection<Document> collection = database.getCollection("USERS");

        // Update the BALANCE for the given user
        collection.updateOne(eq("GMAIL", email), set("BALANCE", newBalance));

        // Close the connection
        mongoClient.close();
    }
    // Method to update stock data after selling stocks
    public static void sellStock(String email, String stockName, int numberOfStocksSold, int amountFromSale) {
    MongoClient mongoClient = MongoClients.create("mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/");
    MongoDatabase database = mongoClient.getDatabase("BEARBULLZ");
    MongoCollection<Document> collection = database.getCollection("USERS");

    Document userDoc = collection.find(eq("GMAIL", email)).first();

    if (userDoc != null) {
        Document stocks = (Document) userDoc.get("STOCKS");

        if (stocks != null && stocks.containsKey(stockName.toUpperCase())) {
            Document stockDoc = (Document) stocks.get(stockName.toUpperCase());

            int currentQuantity = stockDoc.getInteger("QUANTITY");
            int currentInvestment = stockDoc.getInteger("INVESTMENT");

            if (currentQuantity >= numberOfStocksSold) {
                int newQuantity = currentQuantity - numberOfStocksSold;
                int newInvestment = currentInvestment - amountFromSale;

                if (newQuantity > 0) {
                    // Update the quantity and investment in the database
                    collection.updateOne(
                        eq("GMAIL", email),
                        set("STOCKS." + stockName.toUpperCase() + ".QUANTITY", newQuantity)
                    );

                    collection.updateOne(
                        eq("GMAIL", email),
                        set("STOCKS." + stockName.toUpperCase() + ".INVESTMENT", newInvestment)
                    );
                } else {
                    // Remove the stock entry if quantity becomes less than or equal to zero
                    collection.updateOne(
                        eq("GMAIL", email),
                        unset("STOCKS." + stockName.toUpperCase())
                    );
                }
            } else {
                System.out.println("Error: Not enough stocks to sell.");
            }
        } else {
            System.out.println("Error: Stock not found.");
        }
    } else {
        System.out.println("Error: User not found.");
    }
}

    
}
