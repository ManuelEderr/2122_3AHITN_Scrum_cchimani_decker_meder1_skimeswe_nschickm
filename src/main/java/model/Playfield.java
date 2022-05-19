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

    ArrayList<Ship> flotte = new ArrayList<Ship>();


    /**
     * Konstruktor
     */
    public Playfield() {
        feld = new int[reihen][spalten];

        for (int j = 0; j < MAX_Y; j++) {
            for (int i = 0; i < MAX_X; i++) {
                //Das gesamte Spielfeld wird mit 0er gefüllt. (EMPTY)
                feld[j][i] = EMPTY;
            }
        }
    }

    /**
     * Diese Methode prüft, ob sich auf der gewählten Position ein Schiff befindet.
     *
     * @param ship
     */
    public boolean checkShip(Ship ship) {
        boolean rv = true;
        Iterator<Coordinate> iterator = ship.coord.iterator();
        while (iterator.hasNext()) {
            Coordinate field = iterator.next();
            if (field.x >= MAX_X || field.y >= MAX_Y) {
                rv = false;

            }
            if (feld[field.x][field.y] != 0) {
                rv = false;
            }

        }
        return rv;


    }

    public void placeShip(Ship ship) {
        Iterator<Coordinate> iterator = ship.coord.iterator();
        while (iterator.hasNext()) {
            Coordinate place = iterator.next();
            if (feld[place.x][place.y] != 0) {
                System.out.println("Feld bereits belegt");
            } else {
                feld[place.x][place.y] = 2;
            }
        }
        flotte.add(ship);
    }

    public boolean checkHit(Coordinate coordinate) {
        boolean rv = false;
        int position = feld[coordinate.x][coordinate.y];
        if (position == 0 || position == 2) {
            rv = true;
        }
        return rv;

    }

    public int placeHit(Coordinate coordinate) {
        if (feld[coordinate.x][coordinate.y] == 1 || feld[coordinate.x][coordinate.y] == 3) {
            System.out.println("bereits getroffen");
        } else if (feld[coordinate.x][coordinate.y] == 0) {
            System.out.println("Wasser");

        } else if (feld[coordinate.x][coordinate.y] == 2) {

        }

        return 1;
    }

}

