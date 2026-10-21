module cl.duoc.registrovehiculos {
    requires javafx.controls;
    requires javafx.fxml;


    opens cl.duoc.registrovehiculos to javafx.fxml;
    exports cl.duoc.registrovehiculos;
}