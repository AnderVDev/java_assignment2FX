package org.assignment.superhero;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.assignment.superhero.model.Superhero;
import org.assignment.superhero.model.SuperheroDeserializer;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Load FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainScene-view.fxml"));
//            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            Scene scene = new Scene(fxmlLoader.load());

            // Add CSS stylesheet
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());

            // Set title and icon
            stage.setTitle("Assignment 2 - SuperHeroes!");
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("favicon.png")));
            stage.getIcons().add(icon);

            // Set scene and show stage
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle FXML loading error
        }
    }

    public static void main(String[] args) {
        // Create Gson instance with custom deserializer
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Superhero.class, new SuperheroDeserializer())
                .create();
        launch(args);
    }
}