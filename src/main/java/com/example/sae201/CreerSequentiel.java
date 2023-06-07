package com.example.sae201;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CreerSequentiel {


    @FXML
    private TextField searchPicto;
    @FXML
    private Button Home;

    @FXML
    private Button SavePage;

    @FXML
    private Label compteurResult;

    @FXML
    private Button bibliothequeSequentiel;

    @FXML
    private Button buttonAddColumn;

    @FXML
    private Button buttonAddRow;

    @FXML
    private Button editTableau;

    @FXML
    private GridPane gridSequentiel;

    @FXML
    private Button menuBurger;

    @FXML
    private Button newSequentiel;

    @FXML
    private Button settingPage;

    @FXML
    private TextField titreSequentiel;

    List<String> listNameImage = new ArrayList<>();

    @FXML
    private GridPane gridPanePicto;
    private static String idButton;
    @FXML
    void addPictoColonne(ActionEvent event) {
        System.out.println("hello");
        addColumnRow(true);
    }
    @FXML
    void addPictoLigne(ActionEvent event) {
        System.out.println("hello2");
        addColumnRow(false);
    }


    static int indexColumn = 1;
    static int indexRow = 1;
    private void addColumnRow(boolean isColumn){
        for(int i=0; i<(isColumn?indexRow:indexColumn); i++) {
            ImageView imageView = new ImageView();
            imageView.setFitHeight(90);
            imageView.setFitWidth(90);
            imageView.setPickOnBounds(true);

            gridSequentiel.getChildren().add(imageView);
            GridPane.setColumnIndex(imageView, (isColumn?indexColumn:i));
            GridPane.setRowIndex(imageView, (isColumn?i:indexRow));
        }
        if (isColumn){
            gridSequentiel.getColumnConstraints().add(new ColumnConstraints(90));
            indexColumn= indexColumn+2;
            Button button = new Button();
            button.setGraphic(new ImageView(new Image("E:\\test_projet\\SAE201\\src\\main\\resources\\com\\example\\sae201\\Image\\boutton.png")));
            GridPane.setColumnIndex(button,indexColumn-1);
            GridPane.setColumnIndex(buttonAddColumn,indexColumn );
        }else {
            gridSequentiel.getRowConstraints().add(new RowConstraints(90));
            indexRow= indexRow+2;
            Button button = new Button();
            button.setGraphic(new ImageView(new Image("E:\\test_projet\\SAE201\\src\\main\\resources\\com\\example\\sae201\\Image\\boutton.png")));
            gridSequentiel.add(button,3,3);
            GridPane.setRowIndex(buttonAddRow, indexRow);
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
    @FXML
    void searchPicto2button(ActionEvent event) {
        creerLaListe();
        gridPanePicto.getChildren().clear();
        if (!((listNameImage.size()/3)-1==0)){
            for(int i=0; i<= (listNameImage.size()/3)-1;i++){
                System.out.println("passe");
                for(int j=0;j<=2;j++){
                    System.out.println(j);
                    System.out.println(listNameImage.get(i*3+j));
                    ImageView imageView = new ImageView(new Image("https://static.arasaac.org/pictograms/"+listNameImage.get(i*3+j)+"/"+listNameImage.get(i*3+j)+"_300.png"));//
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);
                    System.out.println(j);
                    gridPanePicto.add(imageView,j,i);
                }
            }
        }else{
            for(int j=0;j<=(listNameImage.size()%3);j++){
                System.out.println("passe2");
                ImageView imageView = new ImageView(new Image("https://static.arasaac.org/pictograms/"+listNameImage.get(listNameImage.size()/3+j)+"/"+listNameImage.get(listNameImage.size()/3+j)+"_300.png"));//
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                gridPanePicto.add(imageView,j,listNameImage.size()/3);
            }
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
    }
}
