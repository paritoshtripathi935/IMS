module JavaFxApplication {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires com.jfoenix;
    requires java.sql;
    requires java.desktop;
    opens MainClasses;
    opens ControllerClasses;
}