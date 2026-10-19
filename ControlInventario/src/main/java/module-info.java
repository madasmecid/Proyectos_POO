module cl.duoc.controlinventario {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens cl.duoc.controlinventario to javafx.fxml;
    exports cl.duoc.controlinventario;
}