module de.ufo.tracktable {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens de.ufo.tracktable to javafx.fxml;
    exports de.ufo.tracktable;
}