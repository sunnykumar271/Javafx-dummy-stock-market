package com.mycompany.bearbullz;

import java.awt.Desktop;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AboutUsController1 {

    @FXML
    private TextArea anshuBio;

    @FXML
    private ImageView anshuImage;

    @FXML
    private Hyperlink anshuLink;

    @FXML
    private Label anshuName;

     @FXML
    private TextArea mayurBio;

    @FXML
    private ImageView mayurImage;

    @FXML
    private Hyperlink mayurInsta;

    @FXML
    private Label mayurName;

      @FXML
    private Label sarthakName;

    @FXML
    private TextArea sathakBio;

    @FXML
    private ImageView sathakImage;
 
    @FXML
    private Hyperlink sarthakLink;
    
    @FXML
    private TextArea sunnyBio;

    @FXML
    private ImageView sunnyImage;

    @FXML
    private Hyperlink sunnyLink;

    @FXML
    private Label sunnyName;

    @FXML
    private TextArea umangBio;

    @FXML
    private ImageView umangImage;

    @FXML
    private Hyperlink umangLink;

    @FXML
    private Label umangName;

     @FXML
    private TextArea saibalBio;

    @FXML
    private ImageView saibalImage;

    @FXML
    private Hyperlink saibalInsta;

    @FXML
    private Label saibalName;

    
    @FXML
    void openLink(ActionEvent event) throws URISyntaxException, IOException{
           System.out.println("Linked Clicked !");
           Desktop.getDesktop().browse(new URI("https://www.instagram.com/sunny_kumar.777?igsh=dWlnbnNscnU5Zmlr"));
    }
     @FXML
    void openLink1(ActionEvent event) throws URISyntaxException, IOException{
           System.out.println("Linked Clicked !");
           Desktop.getDesktop().browse(new URI("https://www.instagram.com/anshuman.cpp?igsh=emlhanMwZGc3dWE5"));
    }
    
     @FXML
    void openLink2(ActionEvent event) throws URISyntaxException, IOException{
           System.out.println("Linked Clicked !");
           Desktop.getDesktop().browse(new URI("https://www.instagram.com/butwhymayur?utm_source=qr&igsh=MXZtaXliMzc2djQyZw=="));
    }
    
      @FXML
    void openLink3(ActionEvent event) throws URISyntaxException, IOException{
           System.out.println("Linked Clicked !");
           Desktop.getDesktop().browse(new URI("https://www.instagram.com/suryavanshi_sarthak_?igsh=eDlrbjZvZ3F1cTdv"));
    }
    @FXML
    void openLink4(ActionEvent event) throws URISyntaxException, IOException{
           System.out.println("Linked Clicked !");
           Desktop.getDesktop().browse(new URI("https://www.instagram.com/umang.2701/?next=%2F&hl=en"));
    }
    
     @FXML
    void openLink5(ActionEvent event) throws URISyntaxException, IOException{
           System.out.println("Linked Clicked !");
           Desktop.getDesktop().browse(new URI("https://www.instagram.com/s4i3al_mimo14?igsh=MWtieXJ1M3VxdmplaQ%3D%3D&utm_source=qr"));
    }

    void setStage(Stage stage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

