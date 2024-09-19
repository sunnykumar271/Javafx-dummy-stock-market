package com.mycompany.bearbullz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignupPage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("SignupPage.fxml"));
        Parent root = loader.load();
        SignupController mpc=loader.getController();
        mpc.setStage(primaryStage);
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(getClass().getResource("signup.css").toExternalForm());
        primaryStage.setTitle("Signup Page");
        primaryStage.setScene(scene);

        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
