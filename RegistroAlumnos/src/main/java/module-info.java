module cl.duoc.registroalumnos {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens cl.duoc.registroalumnos to javafx.fxml, com.google.gson;
    exports cl.duoc.registroalumnos;
}