package com.mycompany.bearbullz;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AboutUsController {

    @FXML
    private ImageView member1Image, member2Image, member3Image, member4Image, member5Image, member6Image;
    @FXML
    private Label member1Name, member2Name, member3Name, member4Name, member5Name, member6Name;
    @FXML
    private TextArea member1Bio, member2Bio, member3Bio, member4Bio, member5Bio, member6Bio;
    @FXML
    private Hyperlink member1InstagramLink, member2InstagramLink, member3InstagramLink, member4InstagramLink, member5InstagramLink, member6InstagramLink;

    @FXML
    public void initialize() {
        // Set data for member 1
        member1Name.setText("John Doe");
        member1Bio.setText("John is a software engineer with a passion for open-source.");
        member1InstagramLink.setText("Instagram");
        member1InstagramLink.setOnAction(e -> openLink("https://instagram.com/johndoe"));
        member1Image.setImage(new Image(getClass().getResourceAsStream("/images/johndoe.jpg")));

        // Set data for member 2
        member2Name.setText("Jane Smith");
        member2Bio.setText("Jane is a UI/UX designer with experience in creative solutions.");
        member2InstagramLink.setText("Instagram");
        member2InstagramLink.setOnAction(e -> openLink("https://instagram.com/janesmith"));
        member2Image.setImage(new Image(getClass().getResourceAsStream("/images/janesmith.jpg")));

        // Set data for member 3
        member3Name.setText("Robert Brown");
        member3Bio.setText("Robert is a project manager specializing in Agile development.");
        member3InstagramLink.setText("Instagram");
        member3InstagramLink.setOnAction(e -> openLink("https://instagram.com/robertbrown"));
        member3Image.setImage(new Image(getClass().getResourceAsStream("/images/robertbrown.jpg")));

        // Set data for member 4
        member4Name.setText("Emily Davis");
        member4Bio.setText("Emily is a front-end developer who loves creating responsive websites.");
        member4InstagramLink.setText("Instagram");
        member4InstagramLink.setOnAction(e -> openLink("https://instagram.com/emilydavis"));
        member4Image.setImage(new Image(getClass().getResourceAsStream("/images/emilydavis.jpg")));

        // Set data for member 5
        member5Name.setText("Michael Johnson");
        member5Bio.setText("Michael is a backend developer focused on microservices.");
        member5InstagramLink.setText("Instagram");
        member5InstagramLink.setOnAction(e -> openLink("https://instagram.com/michaeljohnson"));
        member5Image.setImage(new Image(getClass().getResourceAsStream("/images/michaeljohnson.jpg")));

        // Set data for member 6
        member6Name.setText("Sophia Martinez");
        member6Bio.setText("Sophia is a data scientist who loves analyzing complex datasets.");
        member6InstagramLink.setText("Instagram");
        member6InstagramLink.setOnAction(e -> openLink("https://instagram.com/sophiamartinez"));
        member6Image.setImage(new Image(getClass().getResourceAsStream("/images/sophiamartinez.jpg")));
    }

    private void openLink(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
