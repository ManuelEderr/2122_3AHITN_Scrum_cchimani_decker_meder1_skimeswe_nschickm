package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Player;

import java.io.IOException;

public class SettingsController {

    @FXML
    private TextArea namelabel;

    @FXML
    private GridPane gridpane;

    private Player player1;
    private Player player2;

    @FXML
    void okbnclicked(ActionEvent event) {

    }

    public void initialize() {
        gridpane.setPrefHeight(350);
        gridpane.setPrefWidth(350);

        Image background1 = new Image("/Hintergrund_1.jpg", 100, 100, true, true);
        Image background2 = new Image("/Hintergrund_2.jpg", 100, 100, true, true);
        Image background3 = new Image("/Hintergrund_3.jpg", 100, 100, true, true);

        gridpane.add(new ImageView(background1), 0, 0);
        gridpane.add(new ImageView(background2), 0, 1);
        gridpane.add(new ImageView(background3), 0, 2);

        Image ship1 = new Image("/Schiff_1.png", 100, 100, true, true);
        Image ship2 = new Image("/Schiff_2.png", 100, 100, true, true);
        Image ship3 = new Image("/Schiff_3.png", 100, 100, true, true);

        gridpane.add(new ImageView(ship1), 1, 0);
        gridpane.add(new ImageView(ship2), 1, 1);
        gridpane.add(new ImageView(ship3), 1, 2);
    }
}