module cl.duoc.gestorequipos {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens cl.duoc.gestorequipos to javafx.fxml, com.google.gson;
    exports cl.duoc.gestorequipos;
}