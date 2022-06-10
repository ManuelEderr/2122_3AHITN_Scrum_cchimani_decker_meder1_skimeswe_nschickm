package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

import static javafx.embed.swing.SwingFXUtils.fromFXImage;

import java.io.File;
import javax.imageio.ImageIO;


import java.awt.image.RenderedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class PlayfieldController {
    static Coordinate[] coordinates = new Coordinate[10];
    static int readCharacters = 0;
    static boolean result = true;
    public GridPane boardView;
    public VBox vboxPlayfield;
    public AnchorPane apane2;
    public Button enterSettings;
    public Label currentPlayer;
    Playfield p1playfield1;
    Playfield p2playfield1;
    public GridPane boardView1;
    public Button helpBtn;
    public Button snapshotBttn;

    Player spieler1;
    Player spieler2;

    Player current = spieler1;
    int k = 10;
    int lenght = 3;

    public PlayfieldController(Player spieler1, Player spieler2) {
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
        /*
        konstruktor
         */
    }

    public PlayfieldController() {
        /*
        konstruktor für das FXML zum Laden
         */
    }

    public void setUser1(Player player) {
        spieler1 = player;
        current = spieler1;
    }

    public void setUser2(Player player1) {
        spieler2 = player1;
    }

    public void afterSwitch() {
        enterSettings.setText("Settings");
        togglePlayer();
        setColor();
    }

    public void setColor() {
        boardView.setStyle("-fx-background-color: #" + toRGBCode(spieler1.getColor()));
        boardView1.setStyle("-fx-background-color: #" + toRGBCode(spieler2.getColor()));
    }

    public void togglePlayer() {
        if (current == spieler1) {
            currentPlayer.setText(spieler1.getName() + " ist an der Reihe");
            current = spieler2;
        } else if (current == spieler2) {
            currentPlayer.setText(spieler2.getName() + " ist an der Reihe");
            current = spieler1;
        }
    }

    private static String toRGBCode(Color color) {
        String returner = color.toString();
        returner = returner.substring(2);
        if (returner.contains("fff")) {
            returner = returner.substring(0, returner.length() - 2);
        } else {
            returner = returner.replace("ff", "");
        }
        return returner;
    }

    /*
     1 Schlachtschiff (5 Kästchen)
     2 Kreuzer (je 4 Kästchen)
     3 Zerstörer (je 3 Kästchen)
    4 U-Boote (je 2 Kästchen)
     */
    public void schiffsetzen() {
        Ship ship = null;

        if (k >= 0 && k <= 4) {
            lenght = 3;
        } else if (k >= 5 && k <= 7) {
            lenght = 4;
        } else if (k >= 8 && k <= 9) {
            lenght = 4;
        } else if (k == 10) {
            lenght = 4;
        }

        for (int f = coordinates[0].getX() + 1; f < coordinates[0].getX() + 3; f++) {
            for (int d = 1; d < lenght; d++) {
                if (coordinates[0].getRotate() == 0) {
                    coordinates[d].setX(f);
                    coordinates[d].setY(coordinates[0].getY());
                } else if (coordinates[0].getRotate() == 1) {
                    coordinates[d].setY(f);
                    coordinates[d].setX(coordinates[0].getY());
                }
            }
            k--;
        }

        switch (lenght) {
            case 2:
                ship = new Ship(coordinates[0], coordinates[1], "U-Boot");
            case 3:
                ship = new Ship(coordinates[0], coordinates[1], coordinates[2], "Zerstoerer");
            case 4:
                ship = new Ship(coordinates[0], coordinates[1], coordinates[2], coordinates[3], "Kreuzer");
            case 5:
                ship = new Ship(coordinates[0], coordinates[1], coordinates[2], coordinates[3], coordinates[4], "Schlachtschiff");
        }

        if (ship != null) {
            if (current == spieler1) {
                p1playfield1.placeShip(ship);
            } else {
                p2playfield1.placeShip(ship);
            }
        }


    }

    public void settings(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        Stage stageclose = (Stage) enterSettings.getScene().getWindow();
        stageclose.close();

        final FXMLLoader fxmlLoader = new FXMLLoader();
        URL u = BattleShipApplication.class.getResource("/FXML/Settings1.fxml");
        fxmlLoader.setLocation(u);
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param actionEvent
     * @param <BufferedImage>
     * @throws IOException
     * @auther skimeswe, nschickm
     * Macht ein Bild von aktuellem Spielfeld
     * Speichert es in "\Pictures\pictures.png"
     * Wird bei jedem Snapshot ueberschrieben
     */
    public <BufferedImage> void snapen(ActionEvent actionEvent) throws IOException {
        File outputfile = new File("");

        WritableImage snapshot = vboxPlayfield.snapshot(new SnapshotParameters(), null);
        ImageView imageViewAdjusted = new ImageView(snapshot);
        File outputFile = new File(outputfile.getAbsolutePath() + "\\Pictures\\pictures.png");
        BufferedImage bufferedIMage = (BufferedImage) fromFXImage(imageViewAdjusted.snapshot(null, null), null);

        ImageIO.write((RenderedImage) bufferedIMage, "png", outputFile);
    }

    /**
     * @param actionEvent
     * @auther nschickm
     * Ein Help-PopUp Fenster oeffnet sich und erklaert das Spiel
     */
    public void helper(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Help Dialog ");
        alert.setHeaderText(null);
        alert.setContentText("A ship is set with a coordinate ( e.g. \"A\" and \"1\") and with \"0\" = horizontal or \"1\" = vertical.\n" + "-> battleship is 5 boxes long, count: 1.\n" + "-> cruiser is 4 boxes long, count: 2.\n" + "-> destroyer is 3 squares long, count: 3.\n" + "-> submarine is 2 boxes long, count: 4.\n" + "A ship can be shot at using console input or even clicking the field. " + "Only when a ship is completely destroyed you get the respective points for it (the bigger the ship the more points you get). " + "The game is over only when all ships of a player are destroyed.");

        /* "Auf ein Schiff kann mittels Konsolenaufgabe oder auch Klicken des Feldes geschossen werden." +
           "Erst wenn ein Schiff vollständig zerstört ist bekommt man die jeweiligen Punkte dafür (je größer das Schiff desto mehr Punkte bekommt man)." +
           "Das Spiel ist erst zu Ende wenn von einem Spieler alle Schiffe zerstört sind");
         */

        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.showAndWait();
    }
}
