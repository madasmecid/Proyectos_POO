module cl.duoc.autotech {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;


    opens cl.duoc.autotech to javafx.fxml;
    exports cl.duoc.autotech;
    exports cl.duoc.autotech.controller;
    opens cl.duoc.autotech.controller to javafx.fxml;

    opens cl.duoc.autotech.model to javafx.base, com.google.gson;
}