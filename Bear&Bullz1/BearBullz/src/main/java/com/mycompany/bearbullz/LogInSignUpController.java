package com.mycompany.bearbullz;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LogInSignUpController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginAction() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please fill in both fields.");
        } else {
            // Logic for login action can go here
            showAlert("Success", "Login successful for email: " + email);
        }
    }

    @FXML
    private void handleSignupAction() {
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
