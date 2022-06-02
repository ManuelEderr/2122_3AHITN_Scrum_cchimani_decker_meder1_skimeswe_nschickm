package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Player;

import java.util.ArrayList;


public class SettingsController {

    ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3);
    ArrayList<Image> backgroundlist;
    ArrayList<Image> shiplist;
    PlayfieldController playfieldController;

    @FXML
    private TextArea namelabel;

    @FXML
    private GridPane gridpane;

    @FXML
    private ChoiceBox backgroundchoicebox;

    @FXML
    private ChoiceBox shipchoicebox;

    private Player player1;
    private Player player2;

    @FXML
    void okbnclicked(ActionEvent event) {
        if (backgroundchoicebox.getValue() != null
                && shipchoicebox.getValue() != null
                && namelabel.getText() != null) {
            String name = namelabel.getText().replaceAll("\n", "");
            Image background = backgroundlist.get((int) backgroundchoicebox.getValue());
            Image ship = shiplist.get((int) shipchoicebox.getValue());

            if (player1 == null) {
                player1 = new Player(name, background, ship);
            } else if (player2 == null) {
                player2 = new Player(name, background, ship);
                 playfieldController = new PlayfieldController(player1, player2);
            }

        }
    }

    @FXML
    public void initialize() {
        backgroundchoicebox.setTooltip(new Tooltip("Wähle einen Hintergrund"));
        shipchoicebox.setTooltip(new Tooltip("Wähle ein Schiff"));

        backgroundchoicebox.setItems(list);
        shipchoicebox.setItems(list);

        gridpane.setPrefHeight(300);
        gridpane.setPrefWidth(300);

        Image background1 = new Image("/Hintergrund_1.jpg", 100, 100, true, true);
        Image background2 = new Image("/Hintergrund_2.jpg", 100, 100, true, true);
        Image background3 = new Image("/Hintergrund_3.jpg", 100, 100, true, true);

        gridpane.add(new ImageView(background1), 0, 0);
        gridpane.add(new ImageView(background2), 0, 1);
        gridpane.add(new ImageView(background3), 0, 2);

        Image ship1 = new Image("/Schiff_1.png", 70, 70, true, true);
        Image ship2 = new Image("/Schiff_2.png", 70, 70, true, true);
        Image ship3 = new Image("/Schiff_3.png", 70, 70, true, true);

        gridpane.add(new ImageView(ship1), 1, 0);
        gridpane.add(new ImageView(ship2), 1, 1);
        gridpane.add(new ImageView(ship3), 1, 2);

        backgroundlist = new ArrayList<>();
        backgroundlist.add(background1);
        backgroundlist.add(background2);
        backgroundlist.add(background3);

        shiplist = new ArrayList<>();
        shiplist.add(ship1);
        shiplist.add(ship2);
        shiplist.add(ship3);
    }
}