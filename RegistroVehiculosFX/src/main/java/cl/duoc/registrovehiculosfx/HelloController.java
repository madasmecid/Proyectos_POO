package cl.duoc.registrovehiculosfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField txtPatente;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtPrecio;

    @FXML
    private TableView<Vehiculo> tablaVehiculos;

    @FXML
    private TableColumn<Vehiculo, String> colPatente;
    @FXML
    private TableColumn<Vehiculo, String> colMarca;
    @FXML
    private TableColumn<Vehiculo, Integer> colPrecio;

    private ObservableList<Vehiculo> listaVehiculos = FXCollections.observableArrayList();

    private VehiculoDAO vehiculoDAO = new VehiculoDAO();


    @FXML
    public void initialize(){
        colPatente.setCellValueFactory(new PropertyValueFactory<>("patente"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        //CARGAR DATOS DESDE JSON A LA OBSERVABLELIST
        listaVehiculos.addAll(vehiculoDAO.cargar());

        tablaVehiculos.setItems(listaVehiculos);

    }


    @FXML
    protected void onGuardarClick(){
        String patente = txtPatente.getText();
        String marca = txtMarca.getText();
        int precio = Integer.parseInt(txtPrecio.getText());

        Vehiculo nuevoV = new Vehiculo(patente,precio,marca);

        listaVehiculos.add(nuevoV);

        //GUARDAR EN JSON
        vehiculoDAO.guardar(listaVehiculos);



        txtMarca.clear();
        txtPatente.clear();
        txtPrecio.clear();
    }

    @FXML
    protected void onEliminarClick(){
        Vehiculo seleccionado = tablaVehiculos.getSelectionModel().getSelectedItem();

        if(seleccionado != null){
            listaVehiculos.remove(seleccionado);

            vehiculoDAO.guardar(listaVehiculos);
        }
    }
}
