package model;

import javafx.scene.image.Image;

/**
 * @author david
 * Speichert den Namen und den Punktestand eines Spielers.
 */
public class Player {
    private String name;
    private int score = 0;
    private Image background;
    private Image ship;

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

    public Player() {

    }

    public Image getBackground() {
        return background;
    }

    public Image getShip() {
        return ship;
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