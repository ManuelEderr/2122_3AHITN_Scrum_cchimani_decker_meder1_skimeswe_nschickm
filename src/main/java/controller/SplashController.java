package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author nschickm
 */
public class SplashController implements Initializable {

    @FXML
    private AnchorPane apane;
    private AnchorPane AnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        splash();
    }

    private void splash() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            AnchorPane = FXMLLoader.load(getClass().getResource("/FXML/Settings1.fxml"));
                            Stage stage = new Stage();
                            Scene scene = new Scene(AnchorPane);
                            stage.setTitle("Battleship");
                            stage.setScene(scene);
                            stage.setMinHeight(400);
                            stage.setMinWidth(600);
                            stage.show();
                            apane.getScene().getWindow().hide();
                        } catch (IOException ex) {
                            Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        }.start();
    }
}