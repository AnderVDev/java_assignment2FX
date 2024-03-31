//package org.assignment.superhero.controller;
//
//import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import org.assignment.superhero.Main;
//import org.assignment.superhero.model.ApiResponse;
//import org.assignment.superhero.model.Superhero;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.util.Objects;
//import java.util.TreeSet;
//
//public class MainSceneController {
//
//    @FXML
//    private Label msgLabel;
//    @FXML
//    private ImageView posterImageView;
//    @FXML
//    private VBox selectedVBox;
//    @FXML
//    private Button fetchAllButton;
//    @FXML
//    private Label resultsMsgLabel;
//    @FXML
//    private ListView listView;
//    @FXML
//    private VBox titlesVBox;
//    @FXML
//    private HBox resultsBox;
//    @FXML
//    private TextField searchTextField;
//    @FXML
//    private ProgressBar progressBar;
//
//    private int totalNumOfHeroes;
//
//    @FXML
//    private void initialize()
//    {
//        progressBar.setVisible(false);
//        selectedVBox.setVisible(false);
//        titlesVBox.setVisible(false);
//        msgLabel.setVisible(false);
//
//        listView.getSelectionModel()
//                .selectedItemProperty()
//                .addListener((obs, oldValue, superheroSelected) ->{
//                    if (superheroSelected != null)
//                    {
//                        selectedVBox.setVisible(true);
//                        try {
//                            posterImageView.setImage(new Image(superheroSelected.get));
//                        } catch (IllegalArgumentException e)
//                        {
//                            posterImageView.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/default_poster.png"))));
//                        }
//                    }
//                    else
//                    {
//                        selectedVBox.setVisible(false);
//                    }
//                });
//    }
//
//    @FXML
//    private void searchForHeroes(ActionEvent event) throws IOException, InterruptedException, URISyntaxException {
//        String superheroName = searchTextField.getText().trim();
//        ApiResponse apiResponse = ApiController.callAPI(superheroName);
//        totalNumOfHeroes = Integer.parseInt(apiResponse.getTotalResults());
//
//        if (apiResponse.getSuperheroes() != null)
//        {
//            titlesVBox.setVisible(true);
//            listView.getItems().clear();
//            listView.getItems().addAll(apiResponse.getSuperheroes());
//
//            TreeSet<Superhero> sortedSuperheroSet = new TreeSet<>();
//            sortedSuperheroSet.addAll(listView.getItems());
//            System.out.println(Integer.toString(sortedSuperheroSet.size()) + sortedSuperheroSet);
//
//            updateLabels();
//        }
//        else
//        {
//            titlesVBox.setVisible(false);
//            msgLabel.setVisible(true);
//            msgLabel.setText("Enter a movie title and click \"Search\"");
//        }
//    }
//
//    private void updateLabels()
//    {
//        resultsMsgLabel.setText("Showing " + listView.getItems().size() + " of " +totalNumOfHeroes);
//        fetchAllButton.setVisible(listView.getItems().size() < totalNumOfHeroes);
//    }
//
//    @FXML
//    void getSuperheroDetails(ActionEvent event) throws IOException {
//        Superhero superheroSelected = (Superhero) listView.getSelectionModel().getSelectedItem();
//        SceneController.changeScenes(event, "info-view.fxml", superheroSelected.getId());
//    }
//
//    @FXML
//    void fetchAllHeroes()  {
//        Thread fetchThread = new Thread(()->{
//            progressBar.setVisible(true);
//            try {
//                ApiResponse apiResponse = ApiController.callAPI(searchTextField.getText().trim());
//                listView.getItems().addAll(apiResponse.getSuperheroes());
//
//                Platform.runLater(()->{
//                    updateLabels();
//                    progressBar.setProgress((double)listView.getItems().size()/totalNumOfHeroes);
//                });
//
//            } catch (IOException | InterruptedException e) {
//                throw new RuntimeException(e);
//            } catch (URISyntaxException e) {
//                throw new RuntimeException(e);
//            }
//
//            if (listView.getItems().size()<totalNumOfHeroes)
//                fetchAllHeroes();
//            else
//                progressBar.setVisible(false);
//        });
//        fetchThread.start();
//    }
//}