package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ThreadClass1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static controller.PlayfieldController.*;


public class BattleShipApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
     /*
        FXMLLoader fxmlLoader = new FXMLLoader(BattleShipApplication.class.getResource("/FXML/Splash-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
      */
        Parent pane = FXMLLoader.load(getClass().getResource("/FXML/Splash-view.fxml"));
        Scene scene = new Scene(pane);

        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);


        stage.setTitle("Schiffe versenken");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        ThreadClass1 thread = new ThreadClass1("musicfiles\\legendarymusic.mp3");
        Thread thread2 = new Thread(thread);
        thread2.start();
        launch();

    }
}