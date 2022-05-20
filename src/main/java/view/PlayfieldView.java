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
                if (feld.feld[i][j] == 0) {
                    System.out.print("|   |");
                } else if (feld.feld[i][j] == 1) {
                    System.out.print("| O |");
                } else if (feld.feld[i][j] == 2) {
                    System.out.print("| ⬛ |");
                } else if (feld.feld[i][j] == 3) {
                    System.out.print("| 🔺 |");
                }

            }
            System.out.println();
        }

    }


}
