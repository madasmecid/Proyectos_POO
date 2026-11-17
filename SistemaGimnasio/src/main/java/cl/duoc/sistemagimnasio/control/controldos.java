package cl.duoc.sistemagimnasio.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class controldos {
    @FXML
    private Label lblSaludo;

    @FXML
    protected void onClickVolver(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cl/duoc/sistemagimnasio/vista/gimnasio-vista.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) lblSaludo.getScene().getWindow();
            stage.setScene(new Scene(root,500, 450));
            stage.setTitle("Holi");
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
