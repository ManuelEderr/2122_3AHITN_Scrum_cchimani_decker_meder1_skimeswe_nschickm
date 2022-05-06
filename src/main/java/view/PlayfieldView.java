package view;

import model.Playfield;

public class PlayfieldView {
    Playfield feld;

    public PlayfieldView(Playfield feld) {
        this.feld = feld;
    }

    public void drawPlayfield() {
        for (int i = 0; i < feld.feld.length; i++) {
            for (int j = 0; j < feld.feld[i].length; j++) {

                System.out.print("| " + feld.feld[i][j] + " |");

            }
            System.out.println();
        }

    }


}
