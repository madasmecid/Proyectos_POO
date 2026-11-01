module cl.duoc.gestorequipos {
    requires javafx.controls;
    requires javafx.fxml;


    opens cl.duoc.gestorequipos to javafx.fxml;
    exports cl.duoc.gestorequipos;
}