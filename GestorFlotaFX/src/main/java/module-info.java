module com.example.gestorflotafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.gestorflotafx to javafx.fxml;
    opens com.example.gestorflotafx.model to com.fasterxml.jackson.databind;

    exports com.example.gestorflotafx;
    exports com.example.gestorflotafx.app;
}