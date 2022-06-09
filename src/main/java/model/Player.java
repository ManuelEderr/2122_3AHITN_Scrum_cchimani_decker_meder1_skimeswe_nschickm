package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * @author david
 * Speichert den Namen und den Punktestand eines Spielers.
 */
public class Player {
    private String name;
    private int score = 0;
    private javafx.scene.paint.Color color;
    private Image ship;

    /**
     * Im Konstruktor wird er Name des Spielers angelegt.
     *
     * @param -> Name des Spielers
     */
    public Player(String name, javafx.scene.paint.Color value, Image ship) {
        this.name = name;
        this.color = value;
        this.ship = ship;

    }

    public Player() {

    }

    public Color getColor() {
        return color;
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