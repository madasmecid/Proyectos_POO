module com.example.fichamedica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fichamedica to javafx.fxml;
    exports com.example.fichamedica;
}