/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Anshu
 */
public class mainpanelcontroller {
   Stage stage;
   String Gmail;
   @FXML
   Label fullName;  
    // Assign the stage after FXMLLoader loads the controller
    public void setStage(Stage s) {
        this.stage = s;
    }
    public void setGmail(String Gmail)
    {this.Gmail=Gmail;
    }
    @FXML
    public void setName(String Name)
    {
        fullName.setText(Name);
    }
    public void home(ActionEvent e)
    {
        System.out.println("Home");
        
    }
    public void portfolio(ActionEvent e)
    {
        System.out.println("Home");
        
    }
    public void leaderboards(ActionEvent e)
    {
        System.out.println("Home");
        
    }
    public void profile(ActionEvent e)
    {
        System.out.println("Home");
        
    }
    public void aboutUs(ActionEvent e)
    {
        System.out.println("Home");
        
    }
    public void donate(ActionEvent e)
    {
        System.out.println("Home");
        
    }
    public void logout(ActionEvent e) throws IOException
    {
                // Create a confirmation alert
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        
            
        // Show the alert and wait for the user's response
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User confirmed, proceed with logout
            System.out.println("User logged out.");
            
            // Place your logout logic here, such as closing the stage or redirecting to the login page
            //login page
            FXMLLoader loader=new FXMLLoader(getClass().getResource("LoginPage.fxml"));
            Parent root = loader.load();
             LogInSignUpController mpc=loader.getController();
             Scene scene = new Scene(root);
             mpc.setStage(stage);
        scene.getStylesheets().add(getClass().getResource("loginpage.css").toExternalForm());

        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        } else {
            // User canceled the logout
            System.out.println("Logout canceled.");
        }

        
    }
}
