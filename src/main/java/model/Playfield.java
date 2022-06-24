package model;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Playfield {

    private static final int reihen = 10;
    private static final int spalten = 10;
    public static final int EMPTY = 0;
    public static final int HITWATER = 1;
    public static final int SHIP = 2;
    public static final int HITSHIP = 3;
    public int[][] feld;


    final static int MAX_X = 10;
    final static int MAX_Y = 10;

    public ArrayList<Ship> flotte = new ArrayList<Ship>();

    public ArrayList<Ship> getFlotte() {
        return flotte;
    }

    /**
     * Konstruktor
     * Feld mit Reihen und Spalten wird angelegt
     * Gesamtes Spielfeld wird mit 0er gefüllt. (EMPTHY)
     */
    public Playfield() {
        feld = new int[reihen][spalten];

        for (int j = 0; j < MAX_Y; j++) {
            for (int i = 0; i < MAX_X; i++) {
                feld[j][i] = EMPTY;
            }
        }
    }

    /**
     * Diese Methode prüft, ob sich auf der gewaehlten Position ein Schiff befindet und
     * ob das Schiff am Feld plaziert wurde
     * Falls das schiff ungueltig plaziert ist, wird es geloescht
     *
     * @param ship
     * @author: skimeswe, cchimani
     *
     *
     */
    public boolean checkShip(Ship ship) {
        boolean rv = true;
        Iterator<Coordinate> iterator = ship.coords.iterator();
        while (iterator.hasNext()) {
            Coordinate field = iterator.next();
           if (field.getX() >= MAX_X || field.getY() >= MAX_Y||feld[field.getX()][field.getY()] != 0) {
               field.setX(null);
               field.setY(null);
               field.setRotate(null);
                    rv=false;
            }

        }
        if (rv==false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler ");
            alert.setHeaderText(null);
            alert.setContentText("Schiff muss im Feld plaziert werden\n");

            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();

        }
        return rv;

    }

    /**
     * @param ship
     * @author: skimeswe
     * diese Methode plaziert die Schiffe mittels der Koordinaten
     */
    public void placeShip(Ship ship) {

        for (Coordinate place : ship.coords) {
            if (feld[place.getX()][place.getY()] == EMPTY) {
                feld[place.getX()][place.getY()] = SHIP;
            }
        }
        flotte.add(ship);

    }


    /**
     * Ein Schuss wird platziert.
     *
     * @author: skimeswe, decker
     */
    public int placeHit(Coordinate coordinate) {
        if (feld[coordinate.getX()][coordinate.getY()] == HITWATER || feld[coordinate.getX()][coordinate.getY()] == HITSHIP) {
            System.out.println("bereits getroffen");
        } else if (feld[coordinate.getX()][coordinate.getY()] == EMPTY) {
            System.out.println("wasser getroffen");
            feld[coordinate.getX()][coordinate.getY()] = HITWATER;
        } else {
            System.out.println("schiff getroffen");
            feld[coordinate.getX()][coordinate.getY()] = HITSHIP;
        }

        return 1;
    }

}
