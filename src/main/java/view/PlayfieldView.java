package view;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Player;
import model.Playfield;

import java.util.ArrayList;

public class PlayfieldView {
    Playfield feld;
    GridPane gridPane;
    ArrayList<ImageView> arrayList = new ArrayList<>();

    /**
     *
     * @param feld
     * @param gridPane
     */
    public PlayfieldView(Playfield feld, GridPane gridPane) {
        this.feld = feld;
        this.gridPane = gridPane;
    }

    /**
     * Die entsprechenden Bilder werden in das Playfield gesetzt.
     * @param player
     */
    public void drawPlayfield(Player player) {
        ImageView imageView;
        for (int i = 0; i < feld.feld.length; i++) {
            for (int j = 0; j < feld.feld[i].length; j++) {
                switch (feld.feld[i][j]) {
                    case 0:
                        break;
                    case 1:
                        ImageView imageView1 = new ImageView("missed.png");
                        imageView1.setFitHeight(33.8);
                        imageView1.setFitWidth(33.8);
                        gridPane.add(imageView1, i, j);
                        break;
                    case 2:
                        imageView = new ImageView(player.getShip());
                        imageView.setFitHeight(33.8);
                        imageView.setFitWidth(33.8);
                        gridPane.add(imageView, i, j);
                        arrayList.add(imageView);
                        break;
                    case 3:
                        ImageView imageView2 = new ImageView("Treffer.jpg");
                        imageView2.setFitWidth(33.8);
                        imageView2.setFitHeight(33.8);
                        gridPane.add(imageView2, i, j);
                        break;
                }
            }
        }
    }

    public void drawSecondPlayfield(Playfield pf2){

    }


    public void disable() {
        Node node = gridPane.getChildren().get(0);
        gridPane.getChildren().clear();
        gridPane.getChildren().add(0, node);
    }
}
