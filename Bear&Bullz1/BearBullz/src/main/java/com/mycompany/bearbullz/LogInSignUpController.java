package com.mycompany.bearbullz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LogInSignUpController {
    Stage stage;
    public void setStage(Stage s) {
        this.stage = s;
    }
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginAction() throws IOException {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please fill in both fields.");
        } else {
            // Logic for login action can go here
//            //showAlert("Success", "Login successful for email: " + email);
            FXMLLoader loader=new FXMLLoader(getClass().getResource("mainpanel.fxml"));
        Parent root = loader.load();
        mainpanelcontroller mpc=loader.getController();
        mpc.setStage(stage);
        Scene scene=new Scene(root);
        mpc.setStage(stage);
        scene.getStylesheets().add(getClass().getResource("Mainpanel.css").toExternalForm());
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
          
        }
    }

    @FXML
    private void handleSignupAction()  {
        showAlert("Signup", "Redirecting to signup page...");
         
        // Logic to switch to signup page
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
