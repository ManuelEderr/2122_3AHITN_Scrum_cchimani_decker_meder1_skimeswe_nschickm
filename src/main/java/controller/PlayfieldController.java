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

import static javafx.embed.swing.SwingFXUtils.fromFXImage;

import model.Player;
import model.Ship;

import java.io.File;
import javax.imageio.ImageIO;


import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class PlayfieldController {
    static Coordinate[] a = new Coordinate[10];
    static int readCharacters = 0;
    static boolean result = true;
    public GridPane boardView;
    public VBox vboxPlayfield;
    public AnchorPane apane2;
    public Button enterSettings;
    public Label currentPlayer;
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


    public void initialize() throws IOException {

        enterSettings.setText("Settings");
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

    public void schiffsetzen() {
        int l = 5;
        Ship ship;

        if (a[0].rotate == 0) {
            for (int i = a[0].x + 1; i < a[0].x + 6; i++) {
                for (int j = 1; j < l; j++) {
                    a[j].x = i;
                    a[j].y = a[0].y;
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
     * Macht ein Bild von aktuellen Spielfeld
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
        File outputFile = new File("C:\\Users\\43670/formattedPicture.png");
        BufferedImage bufferedIMage = (BufferedImage) fromFXImage(imageViewAdjusted.snapshot(null, null), null);

        ImageIO.write((RenderedImage) bufferedIMage, "png", outputFile);
    }

    /**
     * Ein PopUp Fenster oeffnet sich und erklärt das Spiel
     *
     * @param actionEvent
     */
    public void helper(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Help Dialog");
        alert.setHeaderText(null);
        alert.setContentText("A ship is set with a coordinate ( e.g. \"A\" and \"1\") and with \"0\" = horizontal or \"1\" = vertical.\n" +
                "A battleship is 5 boxes long, count: 1.\n" +
                "A cruiser is 4 boxes long, count: 2.\n" +
                "A destroyer is 3 squares long, count: 3.\n" +
                "A submarine is 2 boxes long, count: 4.\n" +
                "Auf ein Schiff kann mittels Konsolenaufgabe oder auch Klicken des Feldes geschossen werden." +
                "Erst wenn ein Schiff vollständig zerstört ist bekommt man die jeweiligen Punkte dafür (je größer das Schiff desto mehr Punkte bekommt man)." +
                "");

        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.showAndWait();
    }
}
