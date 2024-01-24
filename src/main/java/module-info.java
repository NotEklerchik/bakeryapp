module com.bakeryteam.bakeryapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.bakeryteam.bakeryapp to javafx.fxml;
    exports com.bakeryteam.bakeryapp;
}