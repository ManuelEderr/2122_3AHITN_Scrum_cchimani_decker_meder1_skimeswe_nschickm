package model;

public class Playfield {

    private static final int reihen = 10;
    private static final int spalten = 10;
    public int[][] feld;


    final static int MAXB = 10;
    final static int MAXL = 10;
    final static int MINB = 10;
    final static int MINL = 10;


    /**
     * Konstruktor
     * Gibt das Spielfeld aus
     */
    public Playfield() {
        feld = new int[reihen][spalten];

        for (int j = 0; j <= MAXL; j++) {
            for (int i = 0; i <= MAXB; i++) {
                feld[j][i] = 0;
            }
        }
    }

    /*
    public void placeShip(Ship ship){

    }

     */

}
