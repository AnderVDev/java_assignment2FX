package org.assignment.superhero.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.assignment.superhero.Main;

import java.io.IOException;

public class SceneController {
    public static void changeScenes(ActionEvent event, String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());

        //get the Stage from the ActionEvent
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

//    public static void changeScenes(ActionEvent event, String fxmlFileName, String id) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
//        Scene scene = new Scene(fxmlLoader.load());
//
//        //get the Controller for the destination view and call the "loadMovie()" method
//        MovieLoader controller = fxmlLoader.getController();
//        controller.loadMovie(imdbID);
//
//        //get the Stage from the ActionEvent
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//
//        stage.setScene(scene);
//        stage.show();
//    }
}
