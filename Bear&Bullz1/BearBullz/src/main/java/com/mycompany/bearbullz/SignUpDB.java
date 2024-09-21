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
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
/**
 *
 * @author mayur
 */
import java.util.HashMap;
import java.util.Map;

public class SignUpDB {
      public static void main(String[] args) {
        // Example usage
        HashMap<String, Object> updates = new HashMap<>();
        updates.put("BIO", "i bomb stuff");
        updates.put("AGE", "99");

        updateUser("Osamabin", updates);
        System.out.println("User updated successfully.");
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

        // Close the connection
        mongoClient.close();

        // Return the value of the NAME field if document exists, otherwise null
        if (userDoc != null) {
            return userDoc.getString("NAME");
        } else {
            return null;  // User not found
        }
    }
    
}
