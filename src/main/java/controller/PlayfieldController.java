package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayfieldController {
    static String[] s = new String[2];
    static int readCharacters = 0;
    static boolean result=true;
    public GridPane boardView;
    public VBox vboxPlayfield;
    public AnchorPane apane2;
    public AnchorPane apne3;

    public void initialize() {
        Image background1 = new Image("/anchor.png", 100, 100, true, true);
        Image background2 = new Image("/treasure.png", 100, 100, true, true);
        apane2.getChildren().add(new ImageView(background1));
        apne3.getChildren().add(new ImageView(background2));

    }


}
