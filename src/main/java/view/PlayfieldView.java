package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Player;
import model.Playfield;

import java.util.GregorianCalendar;

public class PlayfieldView {
    Playfield feld;
    GridPane gridPane;

    public PlayfieldView(Playfield feld, GridPane gridPane) {
        this.feld = feld;
        this.gridPane = gridPane;
    }

    public void drawPlayfield(Player player) {
        ImageView imageView;
        for (int i = 0; i < feld.feld.length; i++) {
            for (int j = 0; j < feld.feld[i].length; j++) {
                switch (feld.feld[i][j]) {
                    case 0:
                        break;
                    case 1:
                        gridPane.add(new ImageView("missed.png"), i, j);
                        break;
                    case 2:
                        imageView = new ImageView(player.getShip());
                        imageView.setFitHeight(33.8);
                        imageView.setFitWidth(33.8);
                        gridPane.add(imageView, i, j);
                        break;
                    case 3:
                        gridPane.add(new ImageView("Treffer.jpg"), i, j);
                        break;
                }
            }
        }
    }

    public void drawSecondPlayfield() {
        for (int i = 0; i < feld.feld.length; i++) {
            for (int j = 0; j < feld.feld[i].length; j++) {

            }
        }
    }


}
