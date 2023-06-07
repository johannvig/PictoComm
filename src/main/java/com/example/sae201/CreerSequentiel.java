package com.example.sae201;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class CreerSequentiel {


    @FXML
    private Button Home;

    @FXML
    private Button SavePage;

    @FXML
    private Button SearchPitco;


    @FXML
    private Button bibliothequeSequentiel;

    @FXML
    private Button editTableau;

    @FXML
    private Button menuBurger;

    @FXML
    private Button newSequentiel;

    @FXML
    private Button settingPage;

    @FXML
    private TextField titreSequentiel;

    @FXML
    void addPictoButton(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        Image newImage = new Image("https://static.arasaac.org/pictograms/28375/28375_300.png");
        ImageView imageView = new ImageView(newImage);
        clickedButton.setGraphic(imageView);
        System.out.println("image modifier");
        /*FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("selectionnerPictogramme.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);*/
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
    void editTableauButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("creerSequentiel2.fxml"));
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
    void menuBurgerButton(ActionEvent event) {

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
    void savePageButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("BibliothèqueSequentiel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }

    @FXML
    void searchPictoButton(ActionEvent event) {
        System.out.println("hello");
    }

    @FXML
    void settingPageButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("Homepage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        System.out.println("Page non dev");
        stage.setScene(scene);

    }

    @FXML
    void titleSequentielBox(ActionEvent event) {

    }

}
