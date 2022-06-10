module controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires soundPlay;
    requires javafx.swing;
    requires java.logging;


    opens controller to javafx.fxml;
    exports controller;
}