package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.ThreadClass1;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static controller.PlayfieldController.readCharacters;
import static controller.PlayfieldController.s;

public class BattleShipApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BattleShipApplication.class.getResource("/Playfield.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {


                if (readCharacters < 2 && PlayfieldController.result) {
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
                    System.out.println(s[readCharacters]);
                    readCharacters++;
                } else {
                    System.out.println("Ungültiges Zeichen");
                }

                System.out.println(Arrays.toString(s));
            }
        });
        stage.setTitle("Schiffe versenken");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        ThreadClass1 thread = new ThreadClass1("legendarymusic.mp3");
        Thread thread2 = new Thread(thread);
        thread2.start();
        launch();

    }
}