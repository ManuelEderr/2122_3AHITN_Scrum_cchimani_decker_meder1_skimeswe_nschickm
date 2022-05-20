package model;

import javafx.scene.image.Image;

/**
 * @author david
 * Speichert den Namen und den Punktestand eines Spielers.
 */
public class Player {
    String name;
    int score = 0;
    Image background;
    Image ship;

    /**
     * Im Konstruktor wird er Name des Spielers angelegt.
     *
     * @param name -> Name des Spielers
     */
    public Player(String name, Image background, Image ship) {
        this.name = name;
        this.background = background;
        this.ship = ship;
    }

    /**
     * @return -> gibt den Namen zurück
     */
    public String getName() {
        return name;
    }

    /**
     * @return -> gibt den Punktestand zurück
     */
    public int getScore() {
        return score;
    }

    /**
     * Addiert die übergebene Variable zum Punktestand dazu.
     *
     * @param x -> jener Wert, welcher zum Punktestand addiert wird
     */
    public void addScore(int x) {
        score += x;
    }
}