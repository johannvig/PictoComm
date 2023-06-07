package com.example.sae201;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.concurrent.CompletableFuture;

import javafx.scene.control.Label;


public class SelectionnerPictogramme {

    @FXML
    private Button goBefore;

    @FXML
    private Button goNextPage;

    @FXML
    private GridPane gridPanePicto;
    @FXML
    private TextField searchPicto;

    @FXML
    private Button searchPicto2;

    @FXML
    private Label compteurResult;

    private static String idButton;

    List<String> listNameImage = new ArrayList<>();

    @FXML
    void goBeforebutto(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("CreerSequentiel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }

    @FXML
    void goNextPageButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Homepage.class.getResource("PersonnalisationPictogramme.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }

    @FXML
    void searchPicto2button(ActionEvent event) {
        creerLaListe();
        gridPanePicto.getChildren().clear();
        for(int i=0; i<= (listNameImage.size()/4)-1;i++){
            for(int j=0;j<=6;){
                System.out.println(j);
                System.out.println(listNameImage.get(i*4+j/2));
                ImageView imageView = new ImageView(new Image("https://static.arasaac.org/pictograms/"+listNameImage.get(i*4+j/2)+"/"+listNameImage.get(i*4+j/2)+"_300.png"));//
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                System.out.println(j);
                gridPanePicto.add(imageView,j,i);
                j=j+2;
            }
        }
        for(int j=0;j<=(listNameImage.size()%4)*2-2;){
            System.out.println(listNameImage.get(listNameImage.size()/4*4+j/2));
            Button button = new Button();
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    idButton=button.getText();
                }
            });
            button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            ImageView imageView = new ImageView(new Image("https://static.arasaac.org/pictograms/"+listNameImage.get(listNameImage.size()/4*4+j/2)+"/"+listNameImage.get(listNameImage.size()/4*4+j/2)+"_300.png"));//
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            button.setGraphic(imageView);
            button.setText(listNameImage.get(listNameImage.size()/4*4+j/2));
            System.out.println(j);
            gridPanePicto.add(button,j,listNameImage.size()/4);
            j=j+2;
        }
        System.out.println("affiche");

    }
    public static String getIdButton(){
        return idButton;
    }
    public void creerLaListe(){
        try {
            // Création de l'URL
            URL apiURL = new URL("https://api.arasaac.org/api/pictograms/fr/search/" + searchPicto.getText());

            // Ouverture de la connexion HTTP
            HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Vérification du code de réponse
            int responseCode = connection.getResponseCode();
            StringBuilder response = null;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lecture de la réponse
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Affichage de la réponse JSON
                System.out.println(response);
                System.out.println(response.length());
            } else {
                System.out.println("Erreur lors de la requête. Code de réponse : " + responseCode);
            }

            // Vérification si la réponse est null avant de l'utiliser

            if (response != null) {
                JSONArray jsonArray = new JSONArray(response.toString());

                // récupération des ID + affichage
                listNameImage.clear();
                int i;
                for (i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("_id");
                    listNameImage.add(String.valueOf(id));
                    System.out.println("ID: " + id);
                }

                compteurResult.setText("Nous avons trouvé " + i + " résultats");
            } else {
                System.out.println("La réponse de l'API est null");
                compteurResult.setText("Nous n'avons trouvé aucun résulat");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //recherche l'image via url
        // à revoir
        /*try {
            int id = 12345;
            String imageURL = "https://static.arasaac.org/pictograms/"+id+"/"+id+"_300.png"; // Remplacez ceci par l'URL correcte de l'API Arasaac
            String completeUrl = imageURL + "/" + id;

            //recherche l'image via url
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }




    @FXML
    void searchPictoBox(ActionEvent event) {

    }

}
