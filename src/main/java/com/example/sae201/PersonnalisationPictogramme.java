package com.example.sae201;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class PersonnalisationPictogramme {

    @FXML
    private CheckBox barreP1;

    @FXML
    private Button beforeArrow;

    @FXML
    private CheckBox bordureP1;

    @FXML
    private ColorPicker colorpickerP1N1;

    @FXML
    private ColorPicker colorpickerP1N2;

    @FXML
    private CheckBox couleurP1;

    @FXML
    private Button goNextPage;

    @FXML
    private TextField tailleBordureP1;



    @FXML
    void BordureP1Button(ActionEvent event) {



        if (bordureP1.isSelected()) {
            colorpickerP1N1.setDisable(false);
            tailleBordureP1.setDisable(false);


        } else {

            colorpickerP1N1.setDisable(true);
            tailleBordureP1.setDisable(true);
            //gérer l'api

        }

    }

    @FXML
    void NextButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("PersonnalisationPictogramme2.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }

    @FXML
    void barreP1Button(ActionEvent event) {

        if (barreP1.isSelected()) {


            //gérer l'api
        } else {


        }
    }

    @FXML
    void colorPickerButtonN1(ActionEvent event) {
        Color selectedColor1 = colorpickerP1N1.getValue();
    }

    @FXML
    void colorpickerP1N2Button(ActionEvent event) {

        Color selectedColor2 = colorpickerP1N2.getValue();

    }

    @FXML
    void couleurP1Button(ActionEvent event) {


        if (couleurP1.isSelected()) {
            colorpickerP1N2.setDisable(false);


        } else {
            colorpickerP1N2.setDisable(true);
            //gérer l'api
        }

    }

    @FXML
    void createSequentielButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("creerSequentiel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);

    }

    @FXML
    void tailleBordureP1Box(ActionEvent event) {
        String tailleBordure = tailleBordureP1.getText();

    }

}
