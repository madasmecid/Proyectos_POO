module com.example.gestorpeliculas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gestorpeliculas to javafx.fxml;
    exports com.example.gestorpeliculas;
}