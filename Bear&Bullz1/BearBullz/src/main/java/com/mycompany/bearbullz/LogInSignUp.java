package com.mycompany.bearbullz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogInSignUp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = loader.load();
        LogInSignUpController mpc=loader.getController();
        mpc.setStage(primaryStage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("loginpage.css").toExternalForm());
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
