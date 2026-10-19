module cl.duoc.registrovehiculosfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens cl.duoc.registrovehiculosfx to javafx.fxml, com.google.gson;
    exports cl.duoc.registrovehiculosfx;
}