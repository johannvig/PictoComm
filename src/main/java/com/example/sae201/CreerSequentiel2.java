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
import javafx.stage.Stage;

import java.io.IOException;

public class CreerSequentiel2 {

    @FXML
    private Button beforeArrow;

    @FXML
    private ColorPicker borderColor;

    @FXML
    private CheckBox bordure;

    @FXML
    private CheckBox numerotation;

    @FXML
    private CheckBox positonB;

    @FXML
    private CheckBox positonD;

    @FXML
    private CheckBox positonG;

    @FXML
    private CheckBox positonH;

    @FXML
    private Button save;

    @FXML
    private TextField sizeTableau1;

    @FXML
    private TextField sizeTableau2;

    @FXML
    void borderColorPicker(ActionEvent event) {

    }

    @FXML
    void bordureCheckBox(ActionEvent event) {

        if (bordure.isSelected()) {
            borderColor.setDisable(false);

        } else {
            borderColor.setDisable(true);
            //afficher un message d'erreur
        }


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
    void numerotationButton(ActionEvent event) {

        if (numerotation.isSelected()) {
            positonH.setDisable(false);
            positonB.setDisable(false);
            positonD.setDisable(false);
            positonG.setDisable(false);

        } else {
            positonH.setDisable(true);
            positonB.setDisable(true);
            positonD.setDisable(true);
            positonG.setDisable(true);
            //afficher un message d'erreur
        }


    }

    @FXML
    void positonBCheckBox(ActionEvent event) {

    }

    @FXML
    void positonDCheckBox(ActionEvent event) {

    }

    @FXML
    void positonGCheckBox(ActionEvent event) {

    }

    @FXML
    void positonHCheckBox(ActionEvent event) {

    }

    @FXML
    void saveButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("CreerSequentiel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }

    @FXML
    void sizeTableau1Box(ActionEvent event) {
        String sizeTab1 = sizeTableau1.getText();

    }

    @FXML
    void sizeTableau2Box(ActionEvent event) {
        String sizeTab2 = sizeTableau2.getText();
    }

}
