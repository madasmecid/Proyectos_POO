module cl.duoc.holamundo {
    requires javafx.controls;
    requires javafx.fxml;


    opens cl.duoc.holamundo to javafx.fxml;
    exports cl.duoc.holamundo;
}