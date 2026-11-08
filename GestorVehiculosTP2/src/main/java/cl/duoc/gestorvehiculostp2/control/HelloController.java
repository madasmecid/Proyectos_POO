package cl.duoc.gestorvehiculostp2.control;

import cl.duoc.gestorvehiculostp2.modelo.Auto;
import cl.duoc.gestorvehiculostp2.modelo.Camioneta;
import cl.duoc.gestorvehiculostp2.modelo.Vehiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField txtMarca, txtPatente, txtDetalle;
    @FXML
    private Label lblDetalle, lblMensaje;
    @FXML
    private TableView<Vehiculo> tabla;
    @FXML
    private TableColumn<Vehiculo, String> colPatente, colMarca, colCosto, colDetalle;
    @FXML
    ComboBox<String> cmbTipo;

    private ObservableList<Vehiculo> lista = FXCollections.observableArrayList();


    @FXML
    public void initialize(){
        tabla.setItems(lista);
        cmbTipo.getItems().addAll("Auto", "Camioneta");
        cmbTipo.setOnAction(e -> lblDetalle.setText("Auto".equals(cmbTipo.getValue()) ? "N° PAsajeros" : "Capacidad"));
        cmbTipo.getSelectionModel().selectFirst();

        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colPatente.setCellValueFactory(new PropertyValueFactory<>("patente"));

        colCosto.setCellValueFactory( d -> new SimpleStringProperty("$" + d.getValue().calcularCostoDiario()));

        colDetalle.setCellValueFactory(d -> { Vehiculo v = d.getValue();
        return new SimpleStringProperty(v instanceof Auto ? "Pasajeros: " + ((Auto) v ).getNumeroPasajeros(): "Capacidad carga: " + ((Camioneta)v).getCapacidadCarga());
        });
    }

    @FXML
    protected void onClickGuardar(){
        try{
            String marca = txtMarca.getText().trim();
            String patente = txtPatente.getText().trim();
            int detalle = Integer.parseInt(txtDetalle.getText());
            if(marca.isEmpty() || patente.isEmpty()){
                mostrarMensaje("Campos obligatorios", true);
                return;
            }

            Vehiculo nuevo = "Auto".equals(cmbTipo.getValue())? new Auto(patente, marca, detalle) : new Camioneta(patente, marca, detalle);
            lista.add(nuevo);
            mostrarMensaje("Nuevo Vehiculo registrado", false);
            txtDetalle.clear();txtMarca.clear();txtPatente.clear();
        }catch (NumberFormatException e){
            mostrarMensaje("Valor ingresado debe ser numerico", true);
        }
    }

    @FXML
    protected void onClickEliminar(){
        Vehiculo sel = tabla.getSelectionModel().getSelectedItem();
        if (sel == null){
            mostrarMensaje("Debe seleccionar un vehiculo para eliminar", true);
            return;
        }
        lista.remove(sel);
        mostrarMensaje("Vehiculo elimininado", false);
    }

    private void mostrarMensaje(String mensaje, boolean esError){
        lblMensaje.setText(mensaje);
        lblMensaje.setStyle(esError ? "-fx-text-fill:red;fx-font-wieght:bold": "-fx-text-fill:green; -fx-font-weight: bold");
    }
}
