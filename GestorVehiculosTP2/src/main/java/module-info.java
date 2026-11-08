module cl.duoc.gestorvehiculostp2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;


    opens cl.duoc.gestorvehiculostp2 to javafx.fxml;
    opens cl.duoc.gestorvehiculostp2.modelo to javafx.base;
    opens cl.duoc.gestorvehiculostp2.control to javafx.fxml;
    exports cl.duoc.gestorvehiculostp2;

}