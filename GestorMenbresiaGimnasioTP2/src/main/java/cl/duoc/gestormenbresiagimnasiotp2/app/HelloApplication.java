package cl.duoc.gestormenbresiagimnasiotp2.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cl/duoc/gestormenbresiagimnasiotp2/vista/socio-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Gestion de socios tipo prueba 2");
        stage.setScene(scene);
        stage.show();
    }
}
