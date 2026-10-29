module cl.duoc.gestormascotasfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens cl.duoc.gestormascotasfx to javafx.fxml;
    exports cl.duoc.gestormascotasfx;
}