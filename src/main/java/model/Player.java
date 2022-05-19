package model;

/**
 * @author david
 * Speichert den Namen und den Punktestand eines Spielers.
 */
public class Player {
    String name;
    int score = 0;

    /**
     * Im Konstruktor wird er Name des Spielers angelegt.
     * @param name -> Name des Spielers
     */
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    /**
     * Addiert die übergebene Variable zum Punktestand dazu.
     * @param x -> jener Wert, welcher zum Punktestand addiert wird
     */
    public void addScore(int x) {
        score += x;
    }
}