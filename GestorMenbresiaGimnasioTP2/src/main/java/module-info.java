module cl.duoc.gestormenbresiagimnasiotp2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    exports cl.duoc.gestormenbresiagimnasiotp2.app;
    opens cl.duoc.gestormenbresiagimnasiotp2.app to javafx.fxml;

    opens cl.duoc.gestormenbresiagimnasiotp2.control to javafx.fxml;

    opens cl.duoc.gestormenbresiagimnasiotp2.modelo to javafx.base;
}