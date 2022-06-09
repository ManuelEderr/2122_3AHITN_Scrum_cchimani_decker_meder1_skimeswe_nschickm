package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Coordinate;
import model.MusicPlayer;
import model.Player;
import model.Ship;
import model.*;

import java.io.File;
import javax.imageio.ImageIO;


import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import static javafx.embed.swing.SwingFXUtils.fromFXImage;


public class PlayfieldController {
    static Coordinate[] a = new Coordinate[10];
    static int readCharacters = 0;
    static boolean result = true;
    public GridPane boardView;
    public VBox vboxPlayfield;
    public AnchorPane apane2;
    public AnchorPane apne3;
    public Button enterSettings;
    public Label currentPlayer;
    Playfield p1playfield1;
    public GridPane boardView1;
    public Button helpBtn;
    public Button snapshotBttn;


    Player spieler1;
    Player spieler2;


    Player curry = spieler1;

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
        System.out.println("ich bin hier");
        spieler1 = player;
    }

    public void setUser2(Player player1) {
        spieler2 = player1;
    }

    public void initialize() throws IOException {

        enterSettings.setText("Settings");

        System.out.println("Test: " +
                "" + toRGBCode(spieler1.getColor()));


        //currentPlayer.setText();

        //       boardView.getChildren().add(new ImageView("C:\\Users\\simon\\Desktop\\Simon\\HTL 3ahitn\\SEW\\2122_3AHITN_Scrum_cchimani_decker_meder1_skimeswe_nschickm\\src\\main\\resources\\Hintergrund_1.jpg"));
        //boardView1.getChildren().add(new ImageView(spieler2.getBackground()));


    }

    public void togglePlayer() {
        if (curry == spieler1) {
            currentPlayer.setText(spieler1.getName());
            curry = spieler2;
        } else if (curry == spieler2) {
            currentPlayer.setText(spieler2.getName());
            curry = spieler1;
        }
    }

    private static String toRGBCode(Color color) {
        return "#" + color.getRed() + color.getGreen() + color.getBlue();
    }

    /*
     1 Schlachtschiff (5 Kästchen)
     2 Kreuzer (je 4 Kästchen)
     3 Zerstörer (je 3 Kästchen)
    4 U-Boote (je 2 Kästchen)
     */
    public void schiffsetzen() {
        int l = 5;
        int k = 10;
        Ship ship;

        if (a[0].getRotate() == 0) {
            while (k > 0) {
                for (int f = a[0].getX() + 1; f < a[0].getX() + 3; f++) {
                    for (int d = 1; d < 3; d++) {
                        a[d].setX(f);
                        a[d].setY(a[0].getY());
                    }
                    k--;
                    ship = new Ship(a[0], a[1], "U-Boote");

                    p1playfield1.placeShip(ship);

                }
            }
            while (k >= 5) {
                for (int v = a[0].getX() + 1; v < a[0].getX() + 4; v++) {
                    for (int y = 1; y < 4; y++) {
                        a[y].setX(v);
                        a[y].setY(a[0].getY());
                    }
                    k--;
                    ship = new Ship(a[0], a[1], a[2], "Zerstoerer");
                    p1playfield1.placeShip(ship);

                }
                while (k >= 8) {
                    for (int n = a[0].getX() + 1; n < a[0].getX() + 5; n++) {
                        for (int b = 1; b < 5; b++) {
                            a[b].setX(n);
                            a[b].setY(a[0].getY());
                        }
                        k--;
                        ship = new Ship(a[0], a[1], a[2], a[3], "Kreuzer");
                        p1playfield1.placeShip(ship);

                    }
                    while (k == 10) {
                        for (int o = a[0].getX() + 1; o < a[0].getX() + 6; o++) {
                            for (int m = 1; m < 6; m++) {
                                a[m].setX(o);
                                a[m].setY(a[0].getY());
                            }
                            k--;
                            ship = new Ship(a[0], a[1], a[2], a[3], a[4], "Schlachtschiff");
                            p1playfield1.placeShip(ship);

                        }
                    }


                }
            }
        } else if (a[0].getRotate() == 1) {
            while (k >= 8) {
                for (int z = a[0].getY() + 1; z < a[0].getY() + 5; z++) {
                    for (int u = 1; u < l; u++) {
                        a[u].setX(a[0].getX());
                        a[u].setY(z);
                    }
                    k--;
                    ship = new Ship(a[0], a[1], "U-Boote");
                    p1playfield1.placeShip(ship);


                }
                while (k > 0) {
                    for (int e = a[0].getY() + 1; e < a[0].getY() + 3; e++) {
                        for (int t = 1; t < l; t++) {
                            a[t].setX(a[0].getX());
                            a[t].setY(e);
                        }
                        k--;
                        ship = new Ship(a[0], a[1], a[2], "Zerstoerer");
                        p1playfield1.placeShip(ship);

                    }
                }
                while (k >= 5) {
                    for (int w = a[0].getY() + 1; w < a[0].getY() + 4; w++) {
                        for (int r = 1; r < l; r++) {
                            a[r].setX(a[0].getX());
                            a[r].setY(w);
                        }
                        k--;
                        ship = new Ship(a[0], a[1], a[2], a[3], "Kreuzer");
                        p1playfield1.placeShip(ship);

                    }
                    while (k == 10) {
                        for (int s = a[0].getY() + 1; s < a[0].getY() + 6; s++) {
                            for (int q = 1; q < l; q++) {
                                a[q].setX(a[0].getX());
                                a[q].setY(s);
                            }
                            k--;
                            ship = new Ship(a[0], a[1], a[2], a[3], a[4], "Schlachtschiff");
                            p1playfield1.placeShip(ship);

                        }
                    }


                }


            }
        }
    }

    public void settings(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        Stage stageclose = (Stage) enterSettings.getScene().getWindow();
        stageclose.close();

        final FXMLLoader fxmlLoader = new FXMLLoader();
        URL u = BattleShipApplication.class.getResource("/Settings.fxml");
        fxmlLoader.setLocation(u);
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Macht ein Bild von aktuellem Spielfeld
     *
     * @param actionEvent
     * @param <BufferedImage>
     * @throws IOException
     */
    public <BufferedImage> void snapen(ActionEvent actionEvent) throws IOException {
        // vboxPlayfield (ganzes Bild) oder boardView (nur ein Spieldfeld)
        WritableImage snapshot = vboxPlayfield.snapshot(new SnapshotParameters(), null);
        ImageView imageViewAdjusted = new ImageView(snapshot);
        // Jeder hat einen anderen Pfad
        //  File outputFile = new File("C:\\Users\\43670/formattedPicture.png");
        // BufferedImage bufferedIMage = (BufferedImage) fromFXImage(imageViewAdjusted.snapshot(null, null), null);
        File outputFile = new File("C:\\Users\\43670/formattedPicture.png");
        BufferedImage bufferedIMage = (BufferedImage) fromFXImage(imageViewAdjusted.snapshot(null, null), null);

        ImageIO.write((RenderedImage) bufferedIMage, "png", outputFile);
        //  ImageIO.write((RenderedImage) bufferedIMage, "png", outputFile);
    }

    /**
     * Ein PopUp Fenster oeffnet sich und erklaert das Spiel
     *
     * @param actionEvent
     */
    public void helper(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Help Dialog");
        alert.setHeaderText(null);
        alert.setContentText("A ship is set with a coordinate ( e.g. \"A\" and \"1\") and with \"0\" = horizontal or \"1\" = vertical.\n" +
                "-> battleship is 5 boxes long, count: 1.\n" +
                "-> cruiser is 4 boxes long, count: 2.\n" +
                "-> destroyer is 3 squares long, count: 3.\n" +
                "-> submarine is 2 boxes long, count: 4.\n" +
                "A ship can be shot at using console input or even clicking the field. " +
                "Only when a ship is completely destroyed you get the respective points for it (the bigger the ship the more points you get). " +
                "The game is over only when all ships of a player are destroyed.");
        /*
                "Auf ein Schiff kann mittels Konsolenaufgabe oder auch Klicken des Feldes geschossen werden." +
                        "Erst wenn ein Schiff vollständig zerstört ist bekommt man die jeweiligen Punkte dafür (je größer das Schiff desto mehr Punkte bekommt man)." +
                        "Das Spiel ist erst zu Ende wenn von einem Spieler alle Schiffe zerstört sind");
         */

        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.showAndWait();
    }
}
