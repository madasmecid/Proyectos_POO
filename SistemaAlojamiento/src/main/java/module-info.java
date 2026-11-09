module cl.duoc.sistemaalojamiento {
    requires javafx.controls;
    requires javafx.fxml;


    exports cl.duoc.sistemaalojamiento.app;

    opens cl.duoc.sistemaalojamiento.app to javafx.fxml;
    opens cl.duoc.sistemaalojamiento.control to javafx.fxml;
    opens cl.duoc.sistemaalojamiento.modelo to javafx.base;
}