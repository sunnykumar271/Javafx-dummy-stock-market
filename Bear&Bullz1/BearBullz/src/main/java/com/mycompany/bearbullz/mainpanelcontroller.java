/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bearbullz;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Anshu
 */
public class mainpanelcontroller {
   

    

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
    public void logout(ActionEvent e)
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
        } else {
            // User canceled the logout
            System.out.println("Logout canceled.");
        }

        
    }
}
