package com.mycompany.bearbullz;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController {
    Stage stage;
 
    public void setStage(Stage s) {
        this.stage = s;
    }

    @FXML
    private TextField emailField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private PasswordField confirmPasswordField;
    
    @FXML
    private Button signupButton;

    @FXML
    private void handleSignup() throws IOException{
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (password.equals(confirmPassword)) {
            // Handle successful signup (e.g., save user to database)
            if(UserAuthDB.addUser(email, password))
            {System.out.println("Signup successful with email: " + email);
             FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
             Parent root = loader.load();
             FXMLDocumentController mpc=loader.getController();
             mpc.getEmail(email);
             mpc.setStage(stage);
             Scene scene=new Scene(root);
             mpc.setStage(stage);
             scene.getStylesheets().add(getClass().getResource("signup2.css").toExternalForm());
             stage.setTitle("SignUp");
             stage.setScene(scene);
            stage.show();}
        } else {
            // Handle password mismatch
            System.out.println("Passwords do not match.");
        }
    }

    @FXML
    private void handleLoginPage() throws IOException{
        // Handle navigating back to the login page
        FXMLLoader loader=new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = loader.load();
        LogInSignUpController mpc=loader.getController();
        mpc.setStage(stage);
        Scene scene=new Scene(root);
        mpc.setStage(stage);
        scene.getStylesheets().add(getClass().getResource("loginpage.css").toExternalForm());
        stage.setTitle("LoginPage");
        stage.setScene(scene);
        stage.show();
    }
}
