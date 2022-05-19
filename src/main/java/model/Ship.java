package model;

import java.util.ArrayList;

/**
 * @author nschickm
 * Schiffe:
 * 1 Schlachtschiff (5 Kästchen)
 * 2 Kreuzer (je 4 Kästchen)
 * 3 Zerstörer (je 3 Kästchen)
 * 4 U-Boote (je 2 Kästchen)
 * <p>
 * Die Ship Klasse speichert Start- und Endwert
 * <p>
 * Wittner:
 * Schiff ist Laenge, Position und Ausrichtung
 */
public class Ship {


    private static Coordinate coord1 = null;
    private static Coordinate coord2 = null;
    private static Coordinate coord3 = null;
    private static Coordinate coord4 = null;
    private static Coordinate coord5 = null;
    private String shipname = "";

    ArrayList<Coordinate> coords = new ArrayList<Coordinate>();

    //Schiff mit der größe 2
    public void ship(Coordinate coord1, Coordinate coord2, String name) {
        this.coord1 = coord1;
        this.coord2 = coord2;
        coords.add(coord1);
        coords.add(coord2);
        shipname = name;
    }

    //Schiff mit der größe 3
    public void ship(Coordinate coord1, Coordinate coord2, Coordinate coord3, String name) {
        this.coord1 = coord1;
        this.coord2 = coord2;
        this.coord3 = coord3;
        coords.add(coord1);
        coords.add(coord2);
        coords.add(coord3);
        shipname = name;
    }

    //Schiff mit der größe 4
    public void ship(Coordinate coord1, Coordinate coord2, Coordinate coord3, Coordinate coord4, String name) {
        this.coord1 = coord1;
        this.coord2 = coord2;
        this.coord3 = coord3;
        this.coord4 = coord4;
        coords.add(coord1);
        coords.add(coord2);
        coords.add(coord3);
        coords.add(coord4);
        shipname = name;
    }

    //Schiff mit der größe 5
    public void ship(Coordinate coord1, Coordinate coord2, Coordinate coord3, Coordinate coord4, Coordinate coord5, String name) {
        this.coord1 = coord1;
        this.coord2 = coord2;
        this.coord3 = coord3;
        this.coord4 = coord4;
        this.coord5 = coord5;
        coords.add(coord1);
        coords.add(coord2);
        coords.add(coord3);
        coords.add(coord4);
        coords.add(coord5);
        shipname = name;
    }


    //Ueberprueft ob ein Schiff getroffen wird fnef
    public void shipHit(Coordinate coord) {
        for (int i = 0; i < coords.size(); i++) {
         if(coords.get(i) == coord){
             //Schiff wurde getroffen, Koordinate wird aus der ArrayList geloescht
             coords.remove(i);
         }
        }
    }

    //Ueberprueft ob von einem getroffenen Schiff noch eine Koordinate nicht getroffen wurde
    // also ob noch etwas von einem getroffenen Schiff uebrig ist
    public boolean shipLeft() {
        return coords.isEmpty();
    }

    public boolean hasCoordinates(Coordinate theCoord){
        for (Coordinate coord : coords){
            if (coord == theCoord){
             //   System.out.printf("");
                return true;
            }
        }
        return false;
    }


    // gibt den Namen des Schiffes zurueck
    public String getShipname() {
        //  System.out.println(shipname);
        return shipname;
    }
}
