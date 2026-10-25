module cl.duoc.gestorlibros {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.junit.platform.commons;
    requires java.desktop;


    opens cl.duoc.gestorlibros to javafx.fxml, com.google.gson;
    exports cl.duoc.gestorlibros;
}