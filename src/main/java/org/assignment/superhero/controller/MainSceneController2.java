package org.assignment.superhero.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.assignment.superhero.Main;
import org.assignment.superhero.model.Superhero;

import java.io.IOException;
import java.util.List;

public class MainSceneController2 {

    @FXML
    public TextField searchTextField;
    @FXML
    public ImageView heroImageView;
    @FXML
    public Button btnDetails;
    @FXML
    private ListView<String> listView;

    private ObservableList<Superhero> allSuperheroes;

    public void initialize() throws IOException, InterruptedException {
//        // Fetch superhero data from the API
        btnDetails.setVisible(false);
        ApiController2 superheroAPIService = new ApiController2();
        allSuperheroes = FXCollections.observableArrayList(superheroAPIService.getAllSuperheroes());

        // Populate ListView with superhero names
        ObservableList<String> superheroNames = FXCollections.observableArrayList();
        for (Superhero superhero : allSuperheroes) {
            superheroNames.add(superhero.getName());
        }
        listView.setItems(superheroNames);

        // Add listener for ListView selection changes
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Retrieve superhero information based on the selected name
                Superhero selectedSuperhero = getSuperheroByName(newValue);
                if (selectedSuperhero != null) {
                    // Display the information or perform any action with the selected superhero
                    Image image = new Image(selectedSuperhero.getImages().getMd());
                    heroImageView.setImage(image);
                    btnDetails.setVisible(true);
                }else {
                    btnDetails.setVisible(false);
                }
            }
        });
    }
    private Superhero getSuperheroByName(String name) {
        for (Superhero superhero : allSuperheroes) {
            if (superhero.getName().equals(name)) {
                return superhero;
            }
        }
        return null;
    }

    @FXML
    private void onSearchTextChanged() {
        String searchText = searchTextField.getText().toLowerCase();
        ObservableList<String> filteredList = FXCollections.observableArrayList();
        for (Superhero superhero : allSuperheroes) {
            if (superhero.getName().toLowerCase().contains(searchText)) {
                filteredList.add(superhero.getName());
            }
        }
        listView.setItems(filteredList);
    }

    @FXML
    private void getHeroDetails(ActionEvent event) {
        try {
            String selectedHeroName = listView.getSelectionModel().getSelectedItem();
            Superhero selectedHero = getSuperheroByName(selectedHeroName);
            if (selectedHero != null) {
                // Change to the details view
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("heroDetails-view.fxml"));
                Parent root = loader.load();
                HeroDetailsController detailController = loader.getController();
                detailController.setSuperheroDetails(selectedHero);

                // Pass the selected hero's ID to the detailed view controller
                detailController.setSelectedHeroId(selectedHero.getId());

                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (log or display error message)
        }
    }
}
