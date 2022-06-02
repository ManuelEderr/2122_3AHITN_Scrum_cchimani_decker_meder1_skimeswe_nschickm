package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
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
    public AnchorPane apne3;
    public Button enterSettings;
    public Label currentPlayer;


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
    public void schiffsetzen(){
        int l=5;
        Ship ship;

        if (a[0].rotate==0){
            for (int i = a[0].x+1; i < a[0].x+6; i++) {
                for (int j = 1; j < l; j++) {
                    a[j].x=i;
                    a[j].y=a[0].y;
                }

            }

            ship = new Ship(a[0],a[1],a[2],a[3],a[4],"MAni");
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
}
