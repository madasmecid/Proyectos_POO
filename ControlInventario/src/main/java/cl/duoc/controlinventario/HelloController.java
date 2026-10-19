package cl.duoc.controlinventario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import javax.swing.text.TabableView;

public class HelloController {
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtStock;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> colCodigo;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colStock;
    @FXML
    private TableColumn<Producto, Integer> colPrecio;

    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tablaProductos.setItems(listaProductos);
    }

    @FXML
    protected void onGuardarClick(){
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        int stock = Integer.parseInt(txtStock.getText());
        int precio = Integer.parseInt(txtPrecio.getText());

        Producto productoNuevo = new Producto(codigo, nombre, stock, precio);

        listaProductos.add(productoNuevo);

        txtCodigo.clear();
        txtNombre.clear();
        txtStock.clear();
        txtPrecio.clear();
    }


}

