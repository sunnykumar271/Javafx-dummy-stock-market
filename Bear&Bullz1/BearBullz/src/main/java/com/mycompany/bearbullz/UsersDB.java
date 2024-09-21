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
        ArrayList<HashMap<String, Object>> sortedUsers = getAllUsersSortedByBalance();
        if (!sortedUsers.isEmpty()) {
            System.out.println("Users sorted by BALANCE:");
            for (HashMap<String, Object> user : sortedUsers) {
                System.out.println(user.get("NAME")+" "+user.get("BALANCE").toString());
            }
        } else {
            System.out.println("No users found.");
        }
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
    
}
