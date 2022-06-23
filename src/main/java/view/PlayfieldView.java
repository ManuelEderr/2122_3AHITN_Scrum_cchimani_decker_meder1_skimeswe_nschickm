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
    Playfield feld2;
    GridPane gridPane;
    ArrayList<ImageView> arrayList = new ArrayList<>();

    public PlayfieldView(Playfield feld, GridPane gridPane) {
        this.feld = feld;
        this.gridPane = gridPane;
    }

    public ArrayList<ImageView> getArrayList() {
        return arrayList;
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
                        arrayList.add(imageView);


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



    public void disable() {
        ObservableList<Node> childrens = gridPane.getChildren();
        for (int i = 0; i < feld.feld.length; i++) {
            for (int j = 0; j < feld.feld[i].length; j++) {
                for (Node node : childrens) {
                    if (node instanceof ImageView) {
                        ImageView imageView = new ImageView(); // use what you want to remove
                        gridPane.getChildren().remove(imageView);
                        break;
                    }
                }
            }
        }

    }
}
