module controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires soundPlay;
    requires javafx.swing;


    opens controller to javafx.fxml;
    exports controller;
}