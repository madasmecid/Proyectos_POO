module cl.duoc.gestordemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens cl.duoc.gestordemo to javafx.fxml;
    exports cl.duoc.gestordemo;
}