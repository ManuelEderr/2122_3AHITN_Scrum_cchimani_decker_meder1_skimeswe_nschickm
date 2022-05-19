package model;

import java.util.ArrayList;

/**
 * @author nschickm
 * Schiffe:
 * 1 Schlachtschiff (5 Kästchen)
 * 2 Kreuzer (je 4 Kästchen)
 * 3 Zerstörer (je 3 Kästchen)
 * 4 U-Boote (je 2 Kästchen)
 *
 * Die Ship Klasse speichert Start- und Endwert
 *
 * Wittner:
 * Schiff ist Laenge, Position und Ausrichtung
 *
 */
public class Ship {



    private static Coordinate coord1 = null;
    private static Coordinate coord2 = null;
    private static Coordinate coord3 = null;
    private static Coordinate coord4 = null;
    private static Coordinate coord5 = null;
    private String shipname = "";

    ArrayList<Coordinate> coord = new ArrayList<>();

    //Schiff mit der größe 2
    public void ship(Coordinate coord1, Coordinate coord2, String name){
        this.coord1 = coord1;
        this.coord2 = coord2;
        coord.add(coord1);
        coord.add(coord2);
        shipname = name;
    }

    //Schiff mit der größe 3
    public void ship(Coordinate coord1, Coordinate coord2, Coordinate coord3, String name){
        this.coord1 = coord1;
        this.coord2 = coord2;
        this.coord3 = coord3;
        coord.add(coord1);
        coord.add(coord2);
        coord.add(coord3);
        shipname = name;
    }

    //Schiff mit der größe 4
    public void ship(Coordinate coord1, Coordinate coord2, Coordinate coord3, Coordinate coord4, String name){
        this.coord1 = coord1;
        this.coord2 = coord2;
        this.coord3 = coord3;
        this.coord4 = coord4;
        coord.add(coord1);
        coord.add(coord2);
        coord.add(coord3);
        coord.add(coord4);
        shipname = name;
    }

    //Schiff mit der größe 5
    public void ship(Coordinate coord1, Coordinate coord2, Coordinate coord3, Coordinate coord4, Coordinate coord5, String name){
        this.coord1 = coord1;
        this.coord2 = coord2;
        this.coord3 = coord3;
        this.coord4 = coord4;
        this.coord5 = coord5;
        coord.add(coord1);
        coord.add(coord2);
        coord.add(coord3);
        coord.add(coord4);
        coord.add(coord5);
        shipname = name;
    }


    public void shipHit(Coordinate coord){

    }


    public String getShipname() {
        return shipname;
    }
}
