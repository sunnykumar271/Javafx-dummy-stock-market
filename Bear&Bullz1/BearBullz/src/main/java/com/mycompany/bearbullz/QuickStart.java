/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

/**
 *
 * @author Anshu
 */
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class QuickStart {
    public static void main(String args[])
    {
         boolean isValid = validateUser("Osamabin", "Hello");
        if (isValid) {
            System.out.println("User validated successfully.");
        } else {
            System.out.println("Invalid GMAIL or PASSWORD.");
        }
    }
    public static boolean addUser( String gmail,String password ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/";

         // Create a MongoClient instance
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // Connect to the database
            MongoDatabase database = mongoClient.getDatabase("BEARBULLZ"); // Replace with your database name

            // Access the collection
            MongoCollection<Document> collection = database.getCollection("USERS"); // Replace with your collection name

            // Check for a document
            Document query = new Document("GMAIL",gmail);
            Document existingDocument = collection.find(query).first();

            if (existingDocument != null) {
               return false;
            } else {
                System.out.println("Document not found. Adding new document...");

                // Insert a new document
                Document newDocument = new Document("GMAIL", gmail)
                        .append("PASSWORD", password);
                collection.insertOne(newDocument);
                System.out.println("New document inserted successfully!");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
return false;    }
    
     public static boolean validateUser(String GMail, String password) {
        // Connect to MongoDB Atlas (replace <connection_string> with your actual connection string)
        MongoClient mongoClient = MongoClients.create("mongodb+srv://sanshuman4422:umangbsdk@cluster0.pi8si.mongodb.net/");
        MongoDatabase database = mongoClient.getDatabase("BEARBULLZ");
        MongoCollection<Document> collection = database.getCollection("USERS");

        // Check if user exists with the given GMAIL
        Document userDoc = collection.find(new Document("GMAIL", GMail)).first();

        if (userDoc == null) {
            // User does not exist
            mongoClient.close();
            return false;
        }

        // Check if the password is correct
        String storedPassword = userDoc.getString("PASSWORD");
        mongoClient.close();
        return storedPassword.equals(password);
    }
}

