module cl.duoc.sistemagimnasio {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    exports cl.duoc.sistemagimnasio.app;

    opens cl.duoc.sistemagimnasio.app to javafx.fxml;

    opens cl.duoc.sistemagimnasio.control to javafx.fxml;

    opens cl.duoc.sistemagimnasio.dao to  com.google.gson;

    opens  cl.duoc.sistemagimnasio.modelo to javafx.base, com.google.gson;
}