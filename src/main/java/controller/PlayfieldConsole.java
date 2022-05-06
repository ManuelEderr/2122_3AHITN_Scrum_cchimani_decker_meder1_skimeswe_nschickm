package controller;

import model.Playfield;
import view.PlayfieldView;

public class PlayfieldConsole {


    public static void main(String[] args) {
        Playfield pf = new Playfield();
        PlayfieldView pfv = new PlayfieldView(pf);
        pfv.drawPlayfield();

    }


}
