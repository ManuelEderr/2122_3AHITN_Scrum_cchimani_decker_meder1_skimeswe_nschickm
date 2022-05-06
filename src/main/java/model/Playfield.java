package model;

import java.util.Arrays;

public class Playfield {

    private static final int reihen = 10;
    private static final int spalten = 10;
    public static final int EMPTY = 0;
    public static final int FIELDWITHSHIP = 1;
    public static final int HITSHIP = 2;
    public static final int HITWATER = 3;

    public int[][] feld;


    final static int MAXB = 10;
    final static int MAXL = 10;


    /**
     * Konstruktor
     */
    public Playfield() {
        feld = new int[reihen][spalten];

        for (int j = 0; j < MAXL; j++) {
            for (int i = 0; i < MAXB; i++) {
                feld[j][i] = EMPTY;
            }
        }
    }


    public void placeShip(Ship ship) {

    }


}
