package com.example.sae201;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.scene.control.Hyperlink;
import javafx.application.Application;

public class Homepage{


    @FXML
    private Button Home;

    @FXML
    private Button bibliothequeSequentiel;

    @FXML
    private Button goAffiche1;

    @FXML
    private Button goAffiche2;

    @FXML
    private Button goAffiche3;

    @FXML
    private Button goAffiche4;

    @FXML
    private Button goAffiche5;

    @FXML
    private Button goSetting;

    @FXML
    private Button newSequentiel;

    @FXML
    void affiche1Button(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().browse(new URI("https://arasaac.org/aac-users/fr"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void affiche2Button(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().browse(new URI("https://arasaac.org/developers/api"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void affiche3Button(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().browse(new URI("https://arasaac.org/about-us"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void affiche4Button(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().browse(new URI("https://arasaac.org/prizes"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void affiche5Button(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().browse(new URI("https://arasaac.org/contact-us"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void billiothequeSequentielButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("bibliothequeSequentiel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }


    @FXML
    void homeButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("homepage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        System.out.println("Hello");
        stage.setScene(scene);
    }

    @FXML
    void newSequentielButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("creerSequentiel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);


    }

    @FXML
    void settingButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("Homepage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        System.out.println("Page non dev");
        stage.setScene(scene);
    }

}
