package model;

import java.util.ArrayList;

/**
 * @author nschickm
 * Schiffe:
 * ein Schlachtschiff (5 Kästchen)
 * zwei Kreuzer (je 4 Kästchen)
 * drei Zerstörer (je 3 Kästchen)
 * vier U-Boote (je 2 Kästchen)
 */
public class Ship {

    Playfield playfield = new Playfield();


    Playfield[][] ShipTest = new Playfield[3][4];
    Playfield[][] ShipTest2 = new Playfield[3][7];

    private Playfield[][] start;
    private Playfield[][] end;


    public void placeShips(Playfield ShipTest, Playfield ShipTest2) {

    }

    public boolean isShip(int x, int y){
        boolean r = false;
        //if ()
        return r;
    }
}
