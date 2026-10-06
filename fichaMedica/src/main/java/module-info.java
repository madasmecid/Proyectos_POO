module com.example.fichamedica {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.fichamedica to javafx.fxml;
    exports com.example.fichamedica;
}