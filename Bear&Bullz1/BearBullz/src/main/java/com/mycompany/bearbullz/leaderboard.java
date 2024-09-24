package com.mycompany.bearbullz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Parent;

public class leaderboard extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("leaderboard.fxml"));
        Parent root = loader.load();
        leaderboardController mpc=loader.getController();
        mpc.initialize();
        Scene scene = new Scene(root);

        // Load CSS
        scene.getStylesheets().add(getClass().getResource("leaderboard.css").toExternalForm());

        primaryStage.setTitle("Leaderboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
