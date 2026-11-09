package cl.duoc.registroalquilervehiculo.control;

import cl.duoc.registroalquilervehiculo.modelo.Auto;
import cl.duoc.registroalquilervehiculo.modelo.Camioneta;
import cl.duoc.registroalquilervehiculo.modelo.Vehiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class VehiculoControl {

    @FXML
    private Label lblDetalle, lblMensaje;
    @FXML
    private TextField txtDetalle, txtPatente, txtMarca;
    @FXML
    private ComboBox<String> cmbTipo;

    @FXML
    private TableView<Vehiculo> tabla;

    @FXML
    private TableColumn<Vehiculo, String> colPatente, colMarca, colCosto, colDetalle;

    private ObservableList<Vehiculo> lista = FXCollections.observableArrayList();


    @FXML
    public void initialize(){
        tabla.setItems(lista);
        cmbTipo.getItems().addAll("Auto", "Camioneta");

        cmbTipo.setOnAction(d -> lblDetalle.setText("Auto".equals(cmbTipo.getValue())? "N° Pasajeros: " : "Capacidad carga: "));
        cmbTipo.getSelectionModel().selectFirst();

        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colPatente.setCellValueFactory(new PropertyValueFactory<>("patente"));

        colCosto.setCellValueFactory(d -> new SimpleStringProperty("$" + d.getValue().calcularCostoDiario()));

        colDetalle.setCellValueFactory(d -> { Vehiculo v = d.getValue();
        return new SimpleStringProperty(v instanceof Auto ? "Pasajeros: " + ((Auto)v).getPasajeros(): "Capacidad carga: "+ ((Camioneta)v).getCapacidadCarga());
        });
    }

    @FXML
    protected void onClickGuardar(){
        try{
            String marca = txtMarca.getText().trim();
            String patente = txtPatente.getText().trim();
            String detalleTexto = txtDetalle.getText().trim();

            if(marca.isEmpty() || patente.isEmpty() || detalleTexto.isEmpty()){
                mostrarMensaje("Los campos no pueden quedar vacios", true);
                return;
            }

            int detalle = Integer.parseInt(detalleTexto);

            if (detalle < 0){
                mostrarMensaje("el valor no puede ser negativo", true);
                return;
            }
            Vehiculo nuevo = "Auto".equals(cmbTipo.getValue()) ? new Auto(patente,marca,detalle) : new Camioneta(patente,marca,detalle);
            lista.add(nuevo);
            mostrarMensaje("Vehiculo agregado", false);
            txtDetalle.clear();txtMarca.clear();txtPatente.clear();
        }catch (NumberFormatException e) {
            mostrarMensaje("Error al ingresar el valor numerico", true);
        }
    }

    @FXML
    protected void onClickEliminar(){
        Vehiculo sel = tabla.getSelectionModel().getSelectedItem();
        if(sel == null){
            mostrarMensaje("Seleccionar un elemento para eliminar", true);
            return;

        }
        lista.remove(sel);
        mostrarMensaje("Vehiculo eliminado correctamente", false);
        tabla.getSelectionModel().clearSelection();

    }

    public void limpiarMensaje(){
        lblMensaje.setText("");
    }


    protected void mostrarMensaje(String mensaje, boolean esError){
        lblMensaje.setText(mensaje);
        lblMensaje.setStyle(esError ? "-fx-text-fill:red; -fx-font-weight: bold" : "-fx-text-fill:green; -fx-font-weight: bold");
    }
}
