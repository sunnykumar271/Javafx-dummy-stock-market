package com.mycompany.bearbullz;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;
import java.util.HashMap;

public class leaderboardController {

    @FXML
    private VBox leaderboardContainer;

    public void initialize() {
        // Fetching data from MongoDB
         ArrayList<HashMap<String, Object>> users = UsersDB.getAllUsersSortedByBalance();
        int i=1;
        // Creating UI elements for each user
        for (HashMap a : users) {
            HBox userCard = createUserCard(a.get("NAME").toString(),
                                           i++,
                                           Integer.parseInt(a.get("BALANCE").toString()));
            leaderboardContainer.getChildren().add(userCard);
        }
    }

    private HBox createUserCard(String username, int indexNumber, int balanceCoins) {
        HBox card = new HBox();
        card.getStyleClass().add("user-card");

        Label usernameLabel = new Label(username);
        usernameLabel.getStyleClass().add("username");

        Label indexLabel = new Label(String.valueOf(indexNumber));
        indexLabel.getStyleClass().add("index-number");

        Label balanceLabel = new Label(balanceCoins + " coins");
        balanceLabel.getStyleClass().add("balance-coins");

        card.getChildren().addAll(usernameLabel, indexLabel, balanceLabel);
        return card;
    }

   /* private List<Document> fetchUsersFromDB() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("yourDatabaseName");
        MongoCollection<Document> collection = database.getCollection("users");

        return collection.find().into(new java.util.ArrayList<>());
    }*/
}
