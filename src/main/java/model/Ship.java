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
 * Es wird jede Koordinate eines Schiffes gespeichert,
 * sobald ein Schiff getroffen wird, wird die getroffene Koordinate geloescht
 */
public class Ship {

    private static Coordinate coord1 = null;
    private static Coordinate coord2 = null;
    private static Coordinate coord3 = null;
    private static Coordinate coord4 = null;
    private static Coordinate coord5 = null;
    private String shipname = "";

    ArrayList<Coordinate> coords = new ArrayList<Coordinate>();


    /**
     * Schiff mit der größe 2
     *
     * @param coord1 Koordinate 1
     * @param coord2 Koordinate 2
     * @param name   Name des Schiffes
     */
    public void ship(Coordinate coord1, Coordinate coord2, String name) {
        this.coord1 = coord1;
        this.coord2 = coord2;
        coords.add(coord1);
        coords.add(coord2);
        shipname = name;
    }

    /**
     * Schiff mit der größe 3
     *
     * @param coord1 Koordinate 1
     * @param coord2 Koordinate 2
     * @param coord3 Koordinate 3
     * @param name   Name des Schiffes
     */
    public void ship(Coordinate coord1, Coordinate coord2, Coordinate coord3, String name) {
        this.coord1 = coord1;
        this.coord2 = coord2;
        this.coord3 = coord3;
        coords.add(coord1);
        coords.add(coord2);
        coords.add(coord3);
        shipname = name;
    }

    /**
     * Schiff mit der größe 4
     *
     * @param coord1 Koordinate 1
     * @param coord2 Koordinate 2
     * @param coord3 Koordinate 3
     * @param coord4 Koordinate 4
     * @param name   Name des Schiffes
     */
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

    /**
     * Schiff mit der größe 5
     *
     * @param coord1 Koordinate 1
     * @param coord2 Koordinate 2
     * @param coord3 Koordinate 3
     * @param coord4 Koordinate 4
     * @param coord5 Koordinate 5
     * @param name   Name des Schiffes
     */
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


    /**
     * Ueberprueft ob ein Schiff getroffen wird
     *
     * @param coord auf diese Koordinate wird geschossen und geprueft ob hier Schiff ist
     */
    public void shipHit(Coordinate coord) {
        for (int i = 0; i < coords.size(); i++) {
            if (coords.get(i) == coord) {
                //Schiff wurde getroffen, Koordinate wird aus der ArrayList geloescht
                coords.remove(i);
            }
        }
    }

    /**
     * Ueberprueft ob von einem getroffenen Schiff noch eine Koordinate nicht getroffen wurde
     *
     * @return true -> wenn das Schiff komplett zerstoert wurde
     * false -> wenn das Schiff nicht komplett zerstoert wurde
     */
    public boolean areShipsLeft() {
        return coords.isEmpty();
    }

    /**
     * Ueberprueft ob ein Schiff auf den mitgegebenen Zeichen steht
     *
     * @param theCoord diese Koordinate wird ueberprueft
     * @return true -> Schiff steht darauf
     * false -> Schiff steht nicht darauf
     */
    public boolean hasCoordinates(Coordinate theCoord) {
        for (int i = 0; i < coords.size(); i++) {
            Coordinate coord = coords.get(i);
            if (coord == theCoord) {
                //   System.out.printf("Auf dieser Koordinate befindet sich ein Schiff");
                return true;
            }
        }
        return false;
    }


    /**
     * gibt den Namen des Schiffes zurueck
     * @return der Name des Schiffes
     */
    public String getShipname() {
        //  System.out.println(shipname);
        return shipname;
    }
}

