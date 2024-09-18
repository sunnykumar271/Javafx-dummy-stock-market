package com.mycompany.bearbullz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInSignUpController {

    // FXML fields corresponding to the fields in the FXML file
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    // Method to handle the login button click
    @FXML
    private void handleLoginAction() {
        String email = emailField.getText();
        String password = passwordField.getText();
        
        // Placeholder logic for login (authentication can be added later)
        if (email.equals("user@example.com") && password.equals("password")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid login. Please try again.");
        }
    }

    // Method to handle the transition to the signup page
    @FXML
    private void handleShowSignupPage() {
        System.out.println("Navigating to signup page...");
        // Placeholder action to navigate to the signup page
        // Logic to change scenes can be implemented here
    }

    // Additional logic for signup can be added here
}
