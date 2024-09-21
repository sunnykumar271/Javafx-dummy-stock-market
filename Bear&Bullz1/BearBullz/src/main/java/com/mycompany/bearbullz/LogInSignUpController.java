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
if(QuickStart.validateUser(email, password))
{ FXMLLoader loader=new FXMLLoader(getClass().getResource("mainpanel.fxml"));
        Parent root = loader.load();
        mainpanelcontroller mpc=loader.getController();
        mpc.setStage(stage);
        mpc.setGmail(email);
        Scene scene=new Scene(root);
        mpc.setStage(stage);
        mpc.setName(SignUpDB.getNameByEmail(email));
        scene.getStylesheets().add(getClass().getResource("Mainpanel.css").toExternalForm());
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();}
          else
{
    showAlert("Error", "Wrong Info");
}
        }
    }

    @FXML
    private void handleSignupAction()  throws IOException{
        
          FXMLLoader loader=new FXMLLoader(getClass().getResource("SignupPage.fxml"));
        Parent root = loader.load();
        SignupController mpc=loader.getController();
        mpc.setStage(stage);
        Scene scene=new Scene(root);
        mpc.setStage(stage);
        scene.getStylesheets().add(getClass().getResource("signup.css").toExternalForm());
        stage.setTitle("signup");
        stage.setScene(scene);
        stage.show();
          
        // Logic to switch to signup page
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
