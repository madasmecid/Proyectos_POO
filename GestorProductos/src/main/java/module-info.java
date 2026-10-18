module com.example.gestorproductos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.gestorproductos to javafx.fxml;
    exports com.example.gestorproductos;
}