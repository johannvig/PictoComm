package com.example.sae201;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.json.JSONArray;
import javafx.embed.swing.SwingFXUtils;

import org.json.JSONObject;

import javax.imageio.ImageIO;
//import javax.swing.text.Document;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.SnapshotParameters;
import javafx.scene.paint.Color;



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
    private ListView<String> filtreList;

    @FXML
    private GridPane gridSequentiel;

    @FXML
    private CheckBox filtrePicto;

    @FXML
    private ScrollPane scrollPanesearch;

    @FXML
    private Button validerFiltre;

    @FXML
    private Button PdfPage;


    @FXML
    private Button menuBurger;

    @FXML
    private Button newSequentiel;

    @FXML
    private Button settingPage;

    @FXML
    private Button searchPicto2;

    @FXML
    private TextField titreSequentiel;

    List<String> listNameImage = new ArrayList<>();

    public String newValue;



    @FXML
    private GridPane gridPanePicto;
    private static String idButton;
    @FXML
    void addPictoColonne(ActionEvent event) throws IOException {
        System.out.println("hello");
        addColumnRow(true);
    }
    @FXML
    void addPictoLigne(ActionEvent event) throws IOException {
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

            gridSequentiel.getColumnConstraints().add(new ColumnConstraints(120));
            indexColumn++;
            Button button = new Button();
            //button.setGraphic(new ImageView(new Image("E:\\test_projet\\SAE201\\src\\main\\resources\\com\\example\\sae201\\Image\\boutton.png")));
            GridPane.setColumnIndex(button,indexColumn-1);
            GridPane.setColumnIndex(buttonAddColumn,indexColumn );
        }else {


            gridSequentiel.getRowConstraints().add(new RowConstraints(120));

            indexRow++;
            Button button = new Button();
            //button.setGraphic(new ImageView(new Image("E:\\test_projet\\SAE201\\src\\main\\resources\\com\\example\\sae201\\Image\\boutton.png")));
            gridSequentiel.add(button,3,3);
            GridPane.setRowIndex(buttonAddRow, indexRow);
        }

    }
    private void handleImagePress(MouseEvent event) {
        ImageView imageView = (ImageView) event.getSource();
        Image image = imageView.getImage();

        gridSequentiel.getScene().setCursor(new ImageCursor(image));
    }
    private void handleImageRelease(MouseEvent event) {
        Scene scene = ((Node) event.getSource()).getScene();
        PickResult pickResult = event.getPickResult();
        Node intersectedNode = pickResult.getIntersectedNode();

        if (intersectedNode instanceof ImageView imageView && intersectedNode.getParent() == gridSequentiel) {
            Image img = ((ImageCursor) scene.getCursor()).getImage();
            ImageView currentImageView = (ImageView) event.getSource();

            currentImageView.setImage(imageView.getImage());
            currentImageView.setOnMousePressed(this::handleImagePress);
            currentImageView.setOnMouseReleased(this::handleImageRelease);

            imageView.setImage(img);
            imageView.setOnMousePressed(this::handleImagePress);
            imageView.setOnMouseReleased(this::handleImageRelease);

        }
        gridSequentiel.getScene().setCursor(Cursor.DEFAULT);
    }
    private ImageView createImageView(String imageName) {
        String imageUrl = "https://static.arasaac.org/pictograms/"+imageName+"/"+imageName+"_300.png";
        ImageView imageView = new ImageView();
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setOnMousePressed(this::handleImagePress);
        imageView.setOnMouseReleased(this::handleImageRelease);

        CompletableFuture.runAsync(() -> {
            try {
                Image image = new Image(imageUrl);
                Platform.runLater(() -> imageView.setImage(image));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return imageView;
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
        int rows = (int)Math.ceil(listNameImage.size() / 3.0); // calcule le nombre de lignes nécessaires
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 3; j++) {
                int index = i * 3 + j; // calcule l'index dans listNameImage

                // vérifie si l'index est à l'intérieur des limites de listNameImage
                if (index < listNameImage.size()) {
                    ImageView imageView = createImageView(listNameImage.get(index));
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);
                    gridPanePicto.add(imageView, j, i);
                }
            }
        }



        System.out.println("affiche");

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

    @FXML
    void filtrePictoCheckBox(ActionEvent event) {

        if (filtrePicto.isSelected()) {
            searchPicto2.setVisible(false);
            searchPicto.setVisible(false);
            compteurResult.setVisible(false);
            scrollPanesearch.setVisible(false);
            validerFiltre.setVisible(true);
            filtreList.setVisible(true);


        } else {
            searchPicto2.setVisible(true);
            searchPicto.setVisible(true);
            compteurResult.setVisible(true);
            scrollPanesearch.setVisible(true);
            validerFiltre.setVisible(false);
            filtreList.setVisible(false);
            //afficher un message d'erreur
        }

    }

    @FXML
    void validerFiltreButton(ActionEvent event) {

        searchPicto2.setVisible(true);
        searchPicto.setVisible(true);
        compteurResult.setVisible(true);
        scrollPanesearch.setVisible(true);
        validerFiltre.setVisible(false);
        filtreList.setVisible(false);
    }

    @FXML
    public void initialize() {
        // Ajout d'éléments à filtreList
        filtreList.getItems().addAll("Alimentation","Viande","poisson","Fruit de la mer","Fruit","Végétaux","Fruit sec","Legume","Cereal","Epices", "loisirs", "Place","Education","Temps","Divers","Mobilté","Religion","Travail","Communication","Document","Objet");

        // Création d'un écouteur pour les sélections de l'utilisateur
        filtreList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Faites quelque chose avec la nouvelle valeur sélectionnée
            System.out.println("L'utilisateur a sélectionné : " + newValue);
                    searchPicto.setText(newValue);
                    System.out.println(searchPicto.getText());
        }
        );

    }

    @FXML
    void filtrelistView(ActionEvent event) {

    }


    @FXML
    void pdfPageButton(ActionEvent event) {

        System.out.println("hello");

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);  // Set the background to be transparent

        WritableImage fxImage = new WritableImage((int) Math.round(gridSequentiel.getWidth()), (int) Math.round(gridSequentiel.getHeight()));
        gridSequentiel.snapshot(params, fxImage);

        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(fxImage, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            byte[] imageInByte = byteArrayOutputStream.toByteArray();

            com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(imageInByte); // Utiliser le nom complet ici
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("gridpane.pdf"));
            document.open();
            document.add(img);  // La méthode add fonctionnera maintenant, car img est du type correct.
            document.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }


}


