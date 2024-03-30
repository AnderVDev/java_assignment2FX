package org.assignment.superhero;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainSceneController {

    @FXML
    private Label msgLabel;
    @FXML
    private ImageView posterImageView;
    @FXML
    private VBox selectedVBox;
    @FXML
    private Button fetchAllButton;
    @FXML
    private Label resultsMsgLabel;
    @FXML
    private ListView listView;
    @FXML
    private VBox titlesVBox;
    @FXML
    private HBox resultsBox;
    @FXML
    private TextField searchTextField;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}