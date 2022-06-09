package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class SettingsController {

    public Button fnf;
    public ColorPicker colorpicker1;
    ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3);
    ArrayList<Image> shiplist;

    @FXML
    private TextArea namelabel;

    @FXML
    private GridPane gridpane;

    @FXML
    private ChoiceBox shipchoicebox;


    private Player player1;
    private Player player2;

    @FXML
    void okbnclicked(ActionEvent event) throws IOException {
        if (shipchoicebox.getValue() != null
                && namelabel.getText() != null) {
            String name = namelabel.getText().replaceAll("\n", "");

            Image ship = shiplist.get((int) shipchoicebox.getValue() - 1);

            if (player1 == null) {
                player1 = new Player(name, colorpicker1.getValue(), ship);
                System.out.println("erster: " + colorpicker1.getValue());
            } else if (player2 == null) {
                System.out.println("zweiter: " + colorpicker1.getValue());
                player2 = new Player(name, colorpicker1.getValue(), ship);
                change_scene();
            }

        }

    }

    @FXML
    public void initialize() {
        shipchoicebox.setTooltip(new Tooltip("Wähle ein Schiff"));

        shipchoicebox.setItems(list);

        gridpane.setPrefHeight(300);
        gridpane.setPrefWidth(300);


        Image ship1 = new Image("/Schiff_1.png", 70, 70, true, true);
        Image ship2 = new Image("/Schiff_2.png", 70, 70, true, true);
        Image ship3 = new Image("/Schiff_3.png", 70, 70, true, true);

        gridpane.add(new ImageView(ship1), 1, 0);
        gridpane.add(new ImageView(ship2), 1, 1);
        gridpane.add(new ImageView(ship3), 1, 2);


        shiplist = new ArrayList<>();
        shiplist.add(ship1);
        shiplist.add(ship2);
        shiplist.add(ship3);
    }

    public void change_scene() throws IOException {
        Stage stage = new Stage();

        Stage stageclose = (Stage) fnf.getScene().getWindow();
        stageclose.close();


        final FXMLLoader fxmlLoader = new FXMLLoader();

        URL u = BattleShipApplication.class.getResource("/Playfield.fxml");
        fxmlLoader.setLocation(u);
        Scene scene = new Scene(fxmlLoader.load());

        // TODO: get Controller Objekt from Stage
        // stageObject.setPlayer()


        PlayfieldController pc = fxmlLoader.<PlayfieldController>getController();
        pc.setUser1(player1);
        pc.setUser2(player2);


        stage.setTitle("Battleship");
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}