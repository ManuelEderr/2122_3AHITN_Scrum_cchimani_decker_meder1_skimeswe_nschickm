package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Coordinate;
import model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static controller.PlayfieldController.coordinates;


public class SettingsController {

    public Button fnf;
    @FXML
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
        if (colorpicker1.getValue() != null
                && namelabel.getText() != null) {
            String name = namelabel.getText().replaceAll("\n", "");
            Image ship = shiplist.get((int) shipchoicebox.getValue() - 1);

            if (player1 == null) {
                player1 = new Player(name, colorpicker1.getValue(), ship);
            } else if (player2 == null) {
                player2 = new Player(name, colorpicker1.getValue(), ship);

                change_scene();
            }
        }
    }

    @FXML
    public void initialize() {

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
        URL u = BattleShipApplication.class.getResource("/FXML/Playfield1.fxml");

        assert u != null;
        Scene scene = new Scene(fxmlLoader.load(u.openStream()));
        PlayfieldController pc = fxmlLoader.getController();

        pc.setUser1(player1);
        pc.setUser2(player2);
        pc.afterSwitch();

        stage.setTitle("Battleship ");
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            String s[] = new String[4];
            Integer x=0;
            Integer y=0;
            int readCharacters=0;
            int rot=0;


            @Override
            public void handle(KeyEvent keyEvent) {



                if (readCharacters < 3 && PlayfieldController.result) {
                    String str = keyEvent.getCode().toString();
                    if (str.contains("DIGIT")) {
                        str = str.substring(5);
                    }
                    String ver = "[A-J]|[0-9]";
                    Pattern pt = Pattern.compile(ver);
                    Matcher mt = pt.matcher(str);

                    PlayfieldController.result = mt.matches();
                    System.out.println(PlayfieldController.result);


                    s[readCharacters] = str;
                    readCharacters++;
                    System.out.println(s[readCharacters]);




                    if (Objects.equals(s[readCharacters], "A")) {
                       // coordinates[readCharacters].setX(1);
                        x=1;
                    }
                    if (s[readCharacters] == "B") {
                        //coordinates[readCharacters].setX(2);
                        x=2;
                    }
                    if (s[readCharacters] == "C") {
                       // coordinates[readCharacters].setX(3);
                        x=3;
                    }
                    if (s[readCharacters] == "D") {
                        //coordinates[readCharacters].setX(4);
                        x=4;
                    }
                    if (s[readCharacters] == "E") {
                        //coordinates[readCharacters].setX(5);
                        x=5;
                    }
                    if (s[readCharacters] == "F") {
                        //coordinates[readCharacters].setX(6);
                        x=6;
                    }
                    if (s[readCharacters] == "G") {
                        //coordinates[readCharacters].setX(7);
                        x=7;
                    }
                    if (s[readCharacters] == "H") {
                        //coordinates[readCharacters].setX(8);
                        x=8;
                    }
                    if (s[readCharacters] == "I") {
                        //coordinates[readCharacters].setX(9);
                        x=9;
                    }
                    if (s[readCharacters] == "J") {
                        //coordinates[readCharacters].setX(10);
                        x=10;
                    }
                    readCharacters++;


                    if (s[readCharacters] != null) {
                        //coordinates[readCharacters].setY(Integer.valueOf(s[readCharacters]));
                        y=Integer.valueOf(s[readCharacters]);
                    }


                    if (s[readCharacters] != null) {
                        System.out.println(s[readCharacters]);
                        //coordinates[readCharacters].setRotate(Integer.valueOf(s[readCharacters]));
                        rot=Integer.valueOf(s[readCharacters]);

                    }
                    Coordinate cd = new Coordinate(x,y,rot);

                } else {
                    System.out.println("Ungültiges Zeichen");
                    throw new ArithmeticException("Ungültiges Zeichen");
                }







               }});


    }
    }
