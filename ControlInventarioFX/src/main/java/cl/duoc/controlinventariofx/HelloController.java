package cl.duoc.controlinventariofx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtStock;

    @FXML
    private TableView<Producto> tablaProductos;
    @FXML
    private TableColumn<Producto, String> colCodigo;
    @FXML
    private TableColumn<Producto, String> colNombre;
    @FXML
    private TableColumn<Producto, Integer> colStock;

    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tablaProductos.setItems(listaProductos);
    }


    @FXML
    protected void onGuardarClick(){
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        int stock = Integer.parseInt(txtStock.getText());

        Producto productoNuevo = new Producto(codigo, nombre, stock);

        listaProductos.add(productoNuevo);

        txtCodigo.clear();
        txtNombre.clear();
        txtStock.clear();
    }

     @FXML
    protected void onEliminarClick(){
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();

        if(seleccionado != null){
            listaProductos.remove(seleccionado);
        }
     }
}
