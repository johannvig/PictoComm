package com.example.sae201;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;

public class BibliothequeSequentiel {


    @FXML
    private Button Home;

    @FXML
    private Button billiothequeSequentiel;

    @FXML
    private Button goSetting;

    @FXML
    private Button menuBurger;

    @FXML
    private Button newSequentiel;

    @FXML
    private Button searchPicto2;

    @FXML
    private TextField searchSequentiel2;

    @FXML
    void billiothequeSequentielButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("BibliothequeSequentiel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }



    @FXML
    void goSettingButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("Homepage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        System.out.println("Page non dev");
        stage.setScene(scene);
    }

    @FXML
    void homeButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("Homepage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);

    }

    @FXML
    void menuBurgerButton(ActionEvent event) {

    }

    @FXML
    void newSequentielButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("CreerSequentiel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);

    }

    @FXML
    void searchPicto2button(ActionEvent event) {

    }

    @FXML
    void searchSequentielBox(ActionEvent event) {
        String text = searchSequentiel2.getText();
        System.out.println(text);
    }

}
