module cl.duoc.registroalquilervehiculo {
    requires javafx.controls;
    requires javafx.fxml;


  exports cl.duoc.registroalquilervehiculo.app;
  opens cl.duoc.registroalquilervehiculo.app to javafx.fxml;

  opens cl.duoc.registroalquilervehiculo.control to javafx.fxml;

  opens cl.duoc.registroalquilervehiculo.modelo to javafx.base;
}