module com.example.gestoralumnos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gestoralumnos to javafx.fxml;
    exports com.example.gestoralumnos;
}