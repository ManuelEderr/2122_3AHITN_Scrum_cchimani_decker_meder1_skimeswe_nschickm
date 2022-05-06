package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PlayfieldController {
    @FXML
    private Button test1;


    @FXML
    private Label test;


    public void clcktest(ActionEvent event) {
        test.setText("Weee");
    }
}
