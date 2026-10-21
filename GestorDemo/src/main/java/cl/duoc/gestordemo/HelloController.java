package cl.duoc.gestordemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtTipo;

    @FXML
    private TableView<bicicleca> tablaBicicleca;

    @FXML
    private TableColumn<bicicleca, String> colMarca;
    @FXML
    private TableColumn<bicicleca, String> colTipo;

    private ObservableList<bicicleca> listaBicis = FXCollections.observableArrayList();



     @FXML

     public  void initialize(){
         colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

         colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

         tablaBicicleca.setItems(listaBicis);
     }

    @FXML
    protected void onGuardarClick() {

         String marca = txtMarca.getText();
         String tipo = txtTipo.getText();

         bicicleca bici = new bicicleca(marca, tipo);

         listaBicis.add(bici);

         txtMarca.clear();
         txtTipo.clear();


    }
}
