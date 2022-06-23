| Nr. | Datum      | Version | Geänderte Kapitel                                                                                | Art der Änderung | Autor             | Status |
|-----|------------|---------|--------------------------------------------------------------------------------------------------|------------------|-------------------|--------|
| 1   | 19.05.2022 | 1.0     | Coordinate Klasse, Einlesen von der Tastatur in anderer Klasse nueu Stage hat nicht funktioniert | Erstellung       | Christian Chimani | iB     |
| 2   | 20.05.2022 | 1.1     | Einlesen von der Tastatur, mit Regex, implementierung im Programm                                | bearbeitung      | Christian Chimani | fg     |
| 3   | 02.06.2022 | 1.2     | Schiffe setzen, Coordinate                                                                       | bearbeitung      | Christian Chimani | iB     |
| 4   | 02.06.2022 | 1.3     | Schiffe setzen                                                                                   | bearbeitung      | Christian Chimani | fg     |
| 5   | 10.06.2022 | 1.4     | Schiffe setzen                                                                                   | bearbeitung      | Christian Chimani | fg     

Tastatureingabe:

            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {


                if ( PlayfieldController.result) {
                    String str = keyEvent.getCode().toString();
                    if (str.contains("DIGIT")) {
                        str = str.substring(5);
                    }
                    String ver = "[A-J]|[0-9]";
                    Pattern pt = Pattern.compile(ver);
                    Matcher mt = pt.matcher(str);

                    PlayfieldController.result = mt.matches();



                    System.out.println(str);
                    s[readCharacters]=str;


                    if (s[0] != null) {
                        char[] a  = s[0].toCharArray();
                        x = (int)a[0];
                        s[0]=null;
                    }


                        if (s[1] != null) {
                            //coordinates[readCharacters].setY(Integer.valueOf(s[readCharacters]));
                            y = Integer.valueOf(s[1]);
                            s[1]=null;
                        }


                        if (s[2] != null) {
                            //coordinates[readCharacters].setRotate(Integer.valueOf(s[readCharacters]));
                            rot = Integer.valueOf(s[2]);
                            s[2]=null;

                        }

                        if(readCharacters==2){
                            pc.schiffsetzen(x,y,rot);
                            readCharacters=0;
                        }
                      readCharacters++;


                    }
                }

        });
    };
    public void schiffsetzen(int x, int y, int rot) {

        for (int j = 0; j < 30; j++) {
            coordinates[j].setX(x);
            coordinates[j].setY(y);
            coordinates[j].setRotate(rot);

        }

        Ship ship = null;

        if (k >= 0 && k <= 4) {
            length = 3;
        } else if (k >= 5 && k <= 7) {
            length = 4;
        } else if (k >= 8 && k <= 9) {
            length = 4;
        } else if (k == 10) {
            length = 4;
        }

        for (int f = coordinates[0].getX() + 1; f < coordinates[0].getX() + 3; f++) {
            for (int d = 1; d < length; d++) {
                if (coordinates[0].getRotate() == 0) {
                    coordinates[d].setX(f);
                    coordinates[d].setY(coordinates[0].getY());
                } else if (coordinates[0].getRotate() == 1) {
                    coordinates[d].setY(f);
                    coordinates[d].setX(coordinates[0].getY());
                }
            }
            k--;
        }

        switch (length) {
            case 2:
                ship = new Ship(coordinates[0], coordinates[1], "U-Boot");
            case 3:
                ship = new Ship(coordinates[0], coordinates[1], coordinates[2], "Zerstoerer");
            case 4:
                ship = new Ship(coordinates[0], coordinates[1], coordinates[2], coordinates[3], "Kreuzer");
            case 5:
                ship = new Ship(coordinates[0], coordinates[1], coordinates[2], coordinates[3], coordinates[4], "Schlachtschiff");
        }

        if (ship != null) {
            if (current == spieler1) {
                p1playfield1.placeShip(ship);
            } else {
                p2playfield1.placeShip(ship);
            }
        }
    }
