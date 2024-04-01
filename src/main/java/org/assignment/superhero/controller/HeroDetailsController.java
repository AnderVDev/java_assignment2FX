package org.assignment.superhero.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.assignment.superhero.Main;
import org.assignment.superhero.model.Powerstats;
import org.assignment.superhero.model.Superhero;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.assignment.superhero.model.Superhero;

import java.io.IOException;
import java.util.Map;

public class HeroDetailsController {

    @FXML
    public Button btnBack;
    @FXML
    private Label alignment;
    @FXML
    private Label publisher;
    @FXML
    private ImageView heroImageView;

    @FXML
    private Label nameLabel;

    @FXML
    private Label idLabel;

    @FXML
    private ListView<String> powersListView;

    private int selectedHeroId;

    public void setSuperheroDetails(Superhero superhero) {
        nameLabel.setText(superhero.getName());
        idLabel.setText(superhero.getBiography().getFullName());
        alignment.setText(superhero.getBiography().getAlignment());
        publisher.setText(superhero.getBiography().getPublisher());

        // Load and set the hero's image
        String imagePath = superhero.getImages().getMd();
        Image image = new Image(superhero.getImages().getLg());
        heroImageView.setImage(image);

        // Get the power stats of the superhero
        Powerstats powerStats = superhero.getPowerstats();

        // Add each power stat to the list view
        addPowerStat("Intelligence", String.valueOf(powerStats.getIntelligence()));
        addPowerStat("Strength", String.valueOf(powerStats.getStrength()));
        addPowerStat("Speed", String.valueOf(powerStats.getSpeed()));
        addPowerStat("Durability", String.valueOf(powerStats.getDurability()));
        addPowerStat("Power", String.valueOf(powerStats.getPower()));
        addPowerStat("Combat", String.valueOf(powerStats.getCombat()));
    }

    public void setSelectedHeroId(int selectedHeroId) {
        this.selectedHeroId = selectedHeroId;
    }

    private void addPowerStat(String powerName, String value) {
        powersListView.getItems().add(powerName + ": " + value);
    }

    public void getBack(ActionEvent actionEvent) {
        try {
            // Load the main scene
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("mainScene-view.fxml"));
            Parent root = loader.load();

            // Create the scene
            Scene scene = new Scene(root);

            // Get the stage from the button and set the scene
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

    }
}
