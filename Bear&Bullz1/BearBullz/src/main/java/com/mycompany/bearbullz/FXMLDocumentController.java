package com.mycompany.bearbullz;

import java.io.IOException;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author SAIBAL SARKER
 */
public class FXMLDocumentController implements Initializable {
     Stage stage;
     public void setStage(Stage s){
        this.stage=s;
     }
     String gmail;
     public void getEmail(String gmail){
        this.gmail=gmail;
     }

     @FXML
    private RadioButton btnFemale;

    @FXML
    private RadioButton btnMaleclicked;

    @FXML
    private Button btnNextClicked;

    @FXML
    private RadioButton btnOthers;

    @FXML
    private Label label;

    @FXML
    private TextArea taBio;

    @FXML
    private TextField tfAge;
    
    @FXML
    private TextField tfprn;

    @FXML
    private TextField tfName;
    
    @FXML
    private void OnNext() throws IOException{
        String Name = tfName.getText();
        String Age = tfAge.getText();
        String prn = tfprn.getText();
        String bio = taBio.getText();
        SignUpDB.UserDetail(gmail,Name,Age,prn,bio);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Mainpanel.fxml"));
        Parent root = loader.load();
        mainpanelcontroller mpc = loader.getController();
        
        mpc.setStage(stage);
        Scene scene = new Scene(root);
        mpc.setStage(stage);
        scene.getStylesheets().add(getClass().getResource("mainpanel.css").toExternalForm());
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
        
        
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  
    
}