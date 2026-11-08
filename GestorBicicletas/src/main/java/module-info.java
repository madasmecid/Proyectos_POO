module cl.duoc.gestorbicicletas {
    requires javafx.controls;
    requires javafx.fxml;


    opens cl.duoc.gestorbicicletas.control to javafx.fxml;
    opens cl.duoc.gestorbicicletas.modelo to java.base;
    exports cl.duoc.gestorbicicletas;
}