package com.example.gestionbibliotheque;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MenuController {

@FXML
VBox contenu;


    public void afficheAdherents()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("adherent.fxml"));
        Parent content  = fxmlLoader.load();
        contenu.getChildren().clear();
        contenu.getChildren().add(content);
    }

    public void afficheLivres()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("livre" +
                ".fxml"));
        Parent content  = fxmlLoader.load();
        contenu.getChildren().clear();
        contenu.getChildren().add(content);
    }
    public void afficheEmprunts()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("emprunt" +
                ".fxml"));
        Parent content  = fxmlLoader.load();
        contenu.getChildren().clear();
        contenu.getChildren().add(content);
    }
}
