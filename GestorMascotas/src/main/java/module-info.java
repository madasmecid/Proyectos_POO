module com.example.gestormascotas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gestormascotas to javafx.fxml;
    exports com.example.gestormascotas;
}