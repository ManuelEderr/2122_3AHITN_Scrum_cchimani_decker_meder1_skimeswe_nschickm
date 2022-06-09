package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ThreadClass1;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static controller.PlayfieldController.*;


public class BattleShipApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BattleShipApplication.class.getResource("/FXML/Settings1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            String s[] = new String[2];

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
                    if (s[0] == "A") {
                        coordinates[0].setX(1);
                    }
                    if (s[0] == "B") {
                        coordinates[0].setX(2);
                    }
                    if (s[0] == "C") {
                        coordinates[0].setX(3);
                    }
                    if (s[0] == "D") {
                        coordinates[0].setX(4);
                    }
                    if (s[0] == "E") {
                        coordinates[0].setX(5);
                    }
                    if (s[0] == "F") {
                        coordinates[0].setX(6);
                    }
                    if (s[0] == "G") {
                        coordinates[0].setX(7);
                    }
                    if (s[0] == "H") {
                        coordinates[0].setX(8);
                    }
                    if (s[0] == "I") {
                        coordinates[0].setX(9);
                    }
                    if (s[0] == "J") {
                        coordinates[0].setX(10);
                    }


                    if (s[1] != null) {
                        coordinates[0].setY(Integer.valueOf(s[1]));
                    }
                    if (s[3] != null) {
                        coordinates[0].setRotate(Integer.valueOf(s[3]));

                    }

                } else {
                    System.out.println("Ungültiges Zeichen");
                    throw new ArithmeticException("Ungültiges Zeichen");
                }

                System.out.println(Arrays.toString(s));
            }
        });
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