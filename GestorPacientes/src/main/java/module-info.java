module cl.duoc.gestorpacientes {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens cl.duoc.gestorpacientes to javafx.fxml,com.google.gson;
    exports cl.duoc.gestorpacientes;
}