module com.example.gestorflotafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens com.example.gestorflotafx to javafx.fxml, com.fasterxml.jackson.databind;
    exports com.example.gestorflotafx;
}