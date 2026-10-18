package com.example.gestorproductos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrecio;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> colCodigo;
    @FXML
    private TableColumn<Producto, String> colNombre;
    @FXML
    private TableColumn<Producto, Integer> colPrecio;

    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();


    public void initialize(){
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tablaProductos.setItems(listaProductos);
    }

    @FXML
    protected void onGuardarClick(){

        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        int precio = Integer.parseInt(txtPrecio.getText());


        Producto nuevoProducto = new Producto(codigo,nombre, precio);

        listaProductos.add(nuevoProducto);

        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
    }
}
