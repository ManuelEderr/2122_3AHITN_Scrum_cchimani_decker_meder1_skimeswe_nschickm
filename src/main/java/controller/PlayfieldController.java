package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Coordinate;
import model.Player;
import model.Ship;
import model.*;
import view.PlayfieldView;

import static javafx.embed.swing.SwingFXUtils.fromFXImage;

import java.io.File;
import javax.imageio.ImageIO;


import java.awt.image.RenderedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PlayfieldController {
    static ArrayList<Coordinate> coordinates = new ArrayList<>();
    public int readCharacters = 0;
    static boolean result = true;
    public GridPane boardView;
    public VBox vboxPlayfield;
    public AnchorPane apane2;
    public Button enterSettings;
    public Label currentPlayer;
    Playfield p1playfield1 = new Playfield();
    Playfield p2playfield1 = new Playfield();
    public GridPane boardView1;
    public Button helpBtn;
    public Button snapshotBttn;
    Player spieler1;
    Player spieler2;
    Player current = spieler1;
    int shipcounter = 10;
    PlayfieldView playfieldView;
    PlayfieldView playfieldView1;
    int length = 0;
    Ship[] ship = new Ship[10];
    private final String[] s = new String[4];
    private Integer x = 0;
    private Integer y = 0;
    private Integer rot = 0;

    private Integer playercounter = 0;

    private Integer boardView1Clickable = 1;


    /**
     * @param spieler1
     * @param spieler2
     * @author: skimeswe
     */
    public PlayfieldController(Player spieler1, Player spieler2) {
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
    }

    /**
     * @author: skimeswe
     * parameterloser Konstruktor ist fürs Laden des FXMLs notwenig
     */
    public PlayfieldController() {
    }

    public void setUser1(Player player) {
        spieler1 = player;
        current = spieler1;
    }

    public void setUser2(Player player1) {
        spieler2 = player1;
    }

    /**
     * @author: skimeswe, meder1
     * Die Methode die nach dem Scene wechseln aufgerufen wird. Ruft die togglePlayer Methode auf und setzt die Farben
     */
    public void afterSwitch() {
        enterSettings.setText("Settings");
        setColor(current);
        if (boardView1Clickable == 1) {
            boardView1.setOnMouseClicked(event -> {
                double x = 0;
                double y = 0;
                Coordinate cd = null;
                if (event.getButton() == MouseButton.PRIMARY) {
                    x = (event.getX() / 33.8);
                    x = Math.floor(x);
                    y = (event.getY() / 33.8);
                    y = Math.floor(y);
                    cd = new Coordinate((int) x, (int) y, 0);
                    schiffsetzen(cd);
                } else if (event.getButton() == MouseButton.SECONDARY) {
                    x = (event.getX() / 33.8);
                    x = Math.floor(x);
                    y = (event.getY() / 33.8);
                    y = Math.floor(y);
                    cd = new Coordinate((int) x, (int) y, 1);
                    schiffsetzen(cd);
                }
                if (current == spieler1) {
                    playfieldView.drawPlayfield(current);
                } else if (current == spieler2) {
                    playfieldView1.drawPlayfield(current);
                }
            });
        }
    }

    public void shotzFired(Coordinate cd, Player currentPlayer) {
        if (currentPlayer == spieler1) {
            p1playfield1.placeHit(cd);

            ThreadClass1 thread = new ThreadClass1("musicfiles\\bombsound.mp3");
            Thread thread2 = new Thread(thread);
            thread2.start();

            togglePlayer();
            for (Ship ship : p1playfield1.flotte) {
                System.out.println(ship.getShipname());
            }
            playfieldView.drawPlayfield(current);
        } else if (currentPlayer == spieler2) {
            p2playfield1.placeHit(cd);
            togglePlayer();
            for (Ship ship : p2playfield1.flotte) {
                System.out.println(ship.getShipname());
            }
            playfieldView1.drawPlayfield(current);
        }
    }


    /**
     * @author: skimeswe
     * die Farbe des Spieler wird gesetzt. das # ist notwendig um einen gültigen CSS-RGB code zu haben
     */
    public void setColor(Player player) {
        boardView.setStyle("-fx-background-color: #" + toRGBCode(player.getColor()));
        boardView1.setStyle("-fx-background-color: #" + toRGBCode(player.getColor()));
    }

    /**
     * @author: skimeswe
     * TogglePlayer-Methode wechselt den aktuellen Spieler und gibt diesen im Label aus.
     */
    public void togglePlayer() {
        if (current == spieler1) {
            currentPlayer.setText(spieler1.getName() + " ist an der Reihe");
            current = spieler2;
            setColor(current);
            playfieldView.disable();
        } else if (current == spieler2) {
            currentPlayer.setText(spieler2.getName() + " ist an der Reihe");
            current = spieler1;
            setColor(current);
            playfieldView1.disable();
        }
    }


    /**
     * @author: skimeswe
     * diese Methode returned einen vollständigen RGB CODE
     */
    private static String toRGBCode(Color color) {
        String returner = color.toString();
        returner = returner.substring(2);
        if (returner.contains("fff")) {
            returner = returner.substring(0, returner.length() - 2);
        } else {
            returner = returner.replace("ff", "");
        }
        return returner;
    }


    /*
     1 Schlachtschiff (5 Kästchen)
     2 Kreuzer (je 4 Kästchen)
     3 Zerstörer (je 3 Kästchen)
    4 U-Boote (je 2 Kästchen)
     */

    /**
     * @author: david, (*cchimani)
     */
    public void schiffsetzen(Coordinate coord) {
        if (shipcounter >= 0 && shipcounter <= 4) {
            length = 2;
        } else if (shipcounter >= 5 && shipcounter <= 7) {
            length = 3;
        } else if (shipcounter >= 8 && shipcounter <= 9) {
            length = 4;
        } else if (shipcounter == 10) {
            length = 5;
        }

        coordinates.clear();
        Coordinate[] coordinate = new Coordinate[length];
        if (coord.getRotate() == 0) {
            for (int i = 0; i < length; i++) {
                coordinate[i] = new Coordinate(coord.getX(), coord.getY() + i);
                coordinates.add(coordinate[i]);
            }
        } else if (coord.getRotate() == 1) {
            for (int i = 0; i < length; i++) {
                coordinate[i] = new Coordinate(coord.getX() + i, coord.getY());
                coordinates.add(coordinate[i]);
            }
        }

        if (length == 2) {
            ship[shipcounter - 1] = new Ship(coord, coordinates.get(1), "U-Boot");
        } else if (length == 3) {
            ship[shipcounter - 1] = new Ship(coord, coordinates.get(1), coordinates.get(2), "Zerstoerer");
        } else if (length == 4) {
            ship[shipcounter - 1] = new Ship(coord, coordinates.get(1), coordinates.get(2), coordinates.get(3), "Kreuzer");
        } else if (length == 5) {
            ship[shipcounter - 1] = new Ship(coord, coordinates.get(1), coordinates.get(2), coordinates.get(3), coordinates.get(4), "Schlachtschiff");
        }

        boolean isShip;
        if (ship[shipcounter - 1] != null) {
            if (current == spieler1) {
                isShip = p1playfield1.checkShip(ship[shipcounter - 1]);
                if (isShip) {
                    p1playfield1.placeShip(ship[shipcounter - 1]);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("!!!");
                    alert.setHeaderText(null);
                    alert.setContentText("An dieser Stelle befindet sich bereits ein Schiff");
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.showAndWait();
                    shipcounter++;
                }
            } else {
                isShip = p2playfield1.checkShip(ship[shipcounter - 1]);
                if (isShip) {
                    p2playfield1.placeShip(ship[shipcounter - 1]);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("!!!");
                    alert.setHeaderText(null);
                    alert.setContentText("An dieser Stelle befindet sich bereits ein Schiff");
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.showAndWait();
                    shipcounter++;
                }
            }
        }

        shipcounter--;
        if (shipcounter == 0) {
            shipcounter = 10;
            playercounter++;
            togglePlayer();
            if (playercounter == 2) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Spielbeginn");
                alert.setHeaderText("Alle Schiffe plaziert, Spiel beginnt");
                alert.showAndWait();
                boardView1Clickable = 0;

                boardView.setOnMouseClicked(event -> {
                    double x;
                    double y;
                    Coordinate cd;
                    if (event.getButton() == MouseButton.PRIMARY) {
                        x = (event.getX() / 33.8);
                        x = Math.floor(x);
                        y = (event.getY() / 33.8);
                        y = Math.floor(y);
                        cd = new Coordinate((int) x, (int) y);
                        shotzFired(cd, current);
                    }
                });

            }
        }
    }

    /**
     * @param actionEvent
     * @throws IOException
     * @author: skimeswe
     */
    public void settings(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        Stage stageclose = (Stage) enterSettings.getScene().getWindow();
        stageclose.close();

        final FXMLLoader fxmlLoader = new FXMLLoader();
        URL u = BattleShipApplication.class.getResource("/FXML/Settings1.fxml");
        fxmlLoader.setLocation(u);
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    /**
     * @param scene Die Scene wird vom Settings Controller in die methode tastatureingabe uebergeben, auf alle KeyEvents(Tastatur eingabe) wird solange die scene aktiv ist (geoeffnet ist) reagiert
     *              Alle key events werden im String str gespeichert
     *              Durch regular Expression werden nur gueltige Zeichen im string aktzeptiert
     *              Die zeichen werden in x,y,rotate aufgeteilt und mit einer Coordinate der methode schiffsetzen uebergeben
     * @author: cchimani
     */
    public void tastatureingabe(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {

                if (PlayfieldController.result) {
                    String str = keyEvent.getCode().toString();
                    if (str.contains("DIGIT")) {
                        str = str.substring(5);
                    }
                    String ver = "[A-J]|[0-9]";
                    Pattern pt = Pattern.compile(ver);
                    Matcher mt = pt.matcher(str);

                    if (!mt.matches()) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Ungueltiges Zeichen ");
                        alert.setHeaderText(null);
                        alert.setContentText("Ungueltiges Zeichen:\n" +
                                "Gueltige Zeichen A-J und 1-9");

                        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        alert.showAndWait();

                    } else {

                        PlayfieldController.result = mt.matches();
                        if (readCharacters == 3) {
                            readCharacters = 0;
                        }

                        s[readCharacters] = str;


                        if (s[0] != null) {
                            char[] a = s[0].toCharArray();
                            x = (int) a[0] - 65;
                            s[0] = null;
                        }


                        if (s[1] != null) {
                            y = Integer.parseInt(s[1]) - 1;
                            s[1] = null;
                        }


                        if (s[2] != null) {
                            rot = Integer.valueOf(s[2]);
                            s[2] = null;
                        }
                        Coordinate c;

                        if (readCharacters == 2) {
                            c = new Coordinate(x, y, rot);
                            schiffsetzen(c);
                        }
                        readCharacters++;
                        if (current == spieler1) {
                            playfieldView.drawPlayfield(current);
                        } else if (current == spieler2) {
                            playfieldView1.drawPlayfield(current);
                        }

                    }
                }
            }
        });

    }

    /**
     * @author: skimeswe, nschickm
     * Macht ein Bild von aktuellem Spielfeld
     * Speichert es in "\Pictures\pictures.png"
     * Wird bei jedem Snapshot ueberschrieben
     */
    public <BufferedImage> void snapen(ActionEvent actionEvent) throws IOException {
        File outputfile = new File("");

        WritableImage snapshot = vboxPlayfield.snapshot(new SnapshotParameters(), null);
        ImageView imageViewAdjusted = new ImageView(snapshot);
        File outputFile = new File(outputfile.getAbsolutePath() + "\\Pictures\\pictures.png");
        BufferedImage bufferedIMage = (BufferedImage) fromFXImage(imageViewAdjusted.snapshot(null, null), null);
        ImageIO.write((RenderedImage) bufferedIMage, "png", outputFile);
    }


    /**
     * @param actionEvent
     * @author: nschickm
     * Ein Help-PopUp Fenster oeffnet sich und erklaert das Spiel
     * -> wie Schiffe platziert werden
     * -> welche Groeße die Schiffe haben
     * -> wie auf Schiffe geschossen werden kann
     */
    public void helper(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Help Dialog ");
        alert.setHeaderText(null);
        alert.setContentText("Place ships:\n" +
                "A ship is set with a coordinate ( e.g. \"A\" and \"1\") and with \"0\" = horizontal or \"1\" = vertical.\n" +
                "A ship can be placed with a mouse click. \n" +
                "-> right mouse click => vertical\n" +
                "-> left mouse click => horizontal\n" +
                "Ships:\n" +
                "-> battleship is 5 boxes long, count: 1.\n" +
                "-> cruiser is 4 boxes long, count: 2.\n" +
                "-> destroyer is 3 boxes long, count: 3.\n" +
                "-> submarine is 2 boxes long, count: 4.\n" +
                "Shoot ships:\n" +
                "A ship can be shot at using console input or even clicking the field. " +
                "Only when a ship is completely destroyed you get the respective points for it (the bigger the ship the more points you get). " +
                "The game is over only when all ships of a player are destroyed.");

        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.showAndWait();
    }


    /**
     * Es werden die x und die y Koordinaten des Gridpanes zurückgegeben wenn diejenige Zelle geclicked wird.
     * Linksklick auf die Zelle: Rotation = 0
     * Rechtsklick auf die Zelle: Rotation = 1
     * First Click doesn't work
     */
/*
    public void test(MouseEvent mouseEvent) {


        boardView1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            double x = 0;
            double y = 0;
            double rot = 0;
            Coordinate cd = null;
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                x = (mouseEvent.getX() / 33.8);
                x = Math.floor(x);
                y = (mouseEvent.getY() / 33.8);
                y = Math.floor(y);
                rot = 0;
                cd = new Coordinate((int) x, (int) y, 0);
                System.out.println(cd.toString());
            } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                x = (mouseEvent.getX() / 33.8);
                x = Math.floor(x);
                y = (mouseEvent.getY() / 33.8);
                y = Math.floor(y);
                rot = 1;
                cd = new Coordinate((int) x, (int) y, 1);
                System.out.println(cd.toString());
            }
        });

    }
 */
    public void initialize() {
        playfieldView = new PlayfieldView(p1playfield1, boardView1);
        playfieldView1 = new PlayfieldView(p2playfield1, boardView1);
    }

    /**
     * @author: nschickm
     * Checkt ob alle Schiffe zerstoert sind
     * <p>
     * allDestroyed = false wenn noch Schiffe uebrig sind
     * allDestroyed = true, wenn alle Schiffe zerstoert sind
     */
    public void checkifWon() {
        ArrayList<Ship> flotte = p1playfield1.flotte;
        boolean allDestroyed = true;

        for (Ship s : flotte) {
            if (s.areShipsLeft()) {
                allDestroyed = false;
            }
        }
    }
}
