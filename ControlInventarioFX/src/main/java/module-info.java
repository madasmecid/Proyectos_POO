module cl.duoc.controlinventariofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens cl.duoc.controlinventariofx to javafx.fxml;
    exports cl.duoc.controlinventariofx;
}