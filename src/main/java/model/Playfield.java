package model;

import java.util.ArrayList;
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
     * Diese Methode prüft, ob sich auf der gewählten Position ein Schiff befindet.
     *
     * @param ship
     * @author: skimeswe
     */
    public boolean checkShip(Ship ship) {
        boolean rv = true;
        Iterator<Coordinate> iterator = ship.coords.iterator();
        while (iterator.hasNext()) {
            Coordinate field = iterator.next();
            if (field.getX() >= MAX_X || field.getY() >= MAX_Y) {
                rv = false;
            }
            if (feld[field.getX()][field.getY()] != 0) { //Falls sich etwas anderes als Wasser auf der Position befindet.
                rv = false;
            }
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
     * @param coordinate Die zu überprüfende Koordinate
     * @return Falls die Koordinate EMPTY oder SCHIFF aufweist, returnt diese Funktion true, ansonsten false
     * @author: skimeswe
     */
    public boolean checkHit(Coordinate coordinate) {
        boolean rv = false;
        int position = feld[coordinate.getX()][coordinate.getY()];
        if (position == EMPTY || position == SHIP) {
            rv = true;
        }
        return rv;

    }

    /**
     * Ein Schuss wird platziert.
     *
     * @author: skimeswe, decker, asoenmez
     */
    public int placeHit(Coordinate coordinate) {
        if (feld[coordinate.getX()][coordinate.getY()] == HITWATER || feld[coordinate.getX()][coordinate.getY()] == HITSHIP) {
            System.out.println("bereits getroffen");
        } else if (feld[coordinate.getX()][coordinate.getY()] == EMPTY) {
            feld[coordinate.getX()][coordinate.getY()] = HITWATER;
            System.out.println("Wasser");
        } else {
            feld[coordinate.getX()][coordinate.getY()] = HITSHIP;
        }

        return 1;
    }

}
