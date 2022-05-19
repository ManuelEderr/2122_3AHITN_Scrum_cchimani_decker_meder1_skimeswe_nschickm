package model;

import java.util.ArrayList;

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

    public void checkShip(Ship ship) {

    }

    public void placeShip(Ship ship) {

    }


}
