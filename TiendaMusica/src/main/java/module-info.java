module cl.duoc.tiendamusica {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens cl.duoc.tiendamusica to javafx.fxml;
    exports cl.duoc.tiendamusica;
    opens cl.duoc.tiendamusica.controller to javafx.fxml;
    opens cl.duoc.tiendamusica.model to com.google.gson, javafx.base;

}