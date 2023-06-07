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

public class PersonnalisationPictogramme2 {

    @FXML
    private TextField SizeFontTextB;

    @FXML
    private TextField SizeFontTextH;

    @FXML
    private Button beforeArrow;

    @FXML
    private ColorPicker colorpickerColorFont;

    @FXML
    private ColorPicker colorpickerTextB;

    @FXML
    private Button nextPage;

    @FXML
    private CheckBox texteB;

    @FXML
    private CheckBox texteH;

    @FXML
    private TextField writeTextH;

    @FXML
    private TextField writeTexteB;

    @FXML
    void SizeFontTextBBox(ActionEvent event) {
        String textFB = SizeFontTextB.getText();
    }

    @FXML
    void SizeFontTextHBox(ActionEvent event) {
        String textFH = SizeFontTextH.getText();
    }

    @FXML
    void colorpickerColorFontButton(ActionEvent event) {
        Color selectedColor = colorpickerColorFont.getValue();
    }

    @FXML
    void colorpickerTextBButton(ActionEvent event) {
        Color selectedColor = colorpickerTextB.getValue();

    }

    @FXML
    void nextPageButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("creerSequentiel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }

    @FXML
    void persoPictoButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("PersonnalisationPictogramme.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }

    @FXML
    void texteBButton(ActionEvent event) {


        if (texteB.isSelected()) {
            colorpickerTextB.setDisable(false);
            SizeFontTextB.setDisable(false);
            writeTexteB.setDisable(false);


        } else {
            colorpickerTextB.setDisable(true);
            SizeFontTextB.setDisable(true);
            writeTexteB.setDisable(true);
            //afficher un message d'erreur
        }


    }

    @FXML
    void texteHButton(ActionEvent event) {

        if (texteH.isSelected()) {
            colorpickerColorFont.setDisable(false);
            SizeFontTextH.setDisable(false);
            writeTextH.setDisable(false);


        } else {
            colorpickerColorFont.setDisable(true);
            SizeFontTextH.setDisable(true);
            writeTextH.setDisable(true);
            //afficher un message d'erreur
        }

    }

    @FXML
    void writeTextHBox(ActionEvent event) {
        String textH = writeTextH.getText();
    }

    @FXML
    void writeTexteBBox(ActionEvent event) {
        String textB = writeTexteB.getText();
    }

}
