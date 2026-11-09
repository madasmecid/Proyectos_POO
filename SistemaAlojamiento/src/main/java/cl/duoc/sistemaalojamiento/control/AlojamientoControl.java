package cl.duoc.sistemaalojamiento.control;

import cl.duoc.sistemaalojamiento.modelo.Alojamiento;
import cl.duoc.sistemaalojamiento.modelo.Cabana;
import cl.duoc.sistemaalojamiento.modelo.Habitacion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AlojamientoControl {
    @FXML
    private Label lblDetalle, lblMensaje;
    @FXML
    private TextField txtCodigo, txtNombre, txtDetalle;
    @FXML
    private TableView<Alojamiento> tabla;
    @FXML
    private TableColumn<Alojamiento, String> colCodigo, colNombre, colPrecio, colDetalle;

    @FXML
    private ComboBox<String> cmbTipo;

    private ObservableList<Alojamiento> lista = FXCollections.observableArrayList();
    @FXML
    public void initialize(){
        tabla.setItems(lista);
        cmbTipo.getItems().addAll("Habitacion", "Cabaña");
        cmbTipo.setOnAction(e -> lblDetalle.setText("Habitacion".equals(cmbTipo.getValue())? "es vip: " : "N° de personas: "));
        cmbTipo.getSelectionModel().selectFirst();

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        colPrecio.setCellValueFactory(d -> new SimpleStringProperty("$" + d.getValue().calcularPrecioNoche()));

        colDetalle.setCellValueFactory(d -> {Alojamiento a = d.getValue();
        return new SimpleStringProperty(a instanceof Habitacion ? "Es vip: " + ((Habitacion)a).isEsVip(): "pasajeros: " + ((Cabana)a).getCapacidadPersonas());
        });
    }

    protected void mostrarMensaje(String mensaje, boolean esError){
        lblMensaje.setText(mensaje);
        lblMensaje.setStyle(esError ? "-fx-text-fill:red;-fx-font-weight:bold": "-fx-text-fill:green;-fx-font-weight: bold");
    }


    @FXML
    protected void onClickGuardar(){
        try{
            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();
            String detalle = txtDetalle.getText().trim();

            if(codigo.isEmpty() || nombre.isEmpty() || detalle.isEmpty()){
                mostrarMensaje("Debe completar todos los campos", true);
                return;
            }
            Alojamiento nuevo;

            if ("Habitacion".equals(cmbTipo.getValue())){
                boolean esVip = detalle.equalsIgnoreCase("si") || detalle.equalsIgnoreCase("true");
                nuevo = new Habitacion(codigo, nombre,esVip);
            }else{
                int capacidad = Integer.parseInt(detalle);

                if(capacidad <= 0){
                    mostrarMensaje("La capacidad de personas debe ser mayor a 0", true);
                    return;
                }
                nuevo = new Cabana(codigo,nombre,capacidad);
            }
            lista.add(nuevo);
            mostrarMensaje("alojamiento registrado exitosamente", false);

            txtCodigo.clear();txtDetalle.clear();txtNombre.clear();
        }catch (NumberFormatException e){
            mostrarMensaje("para cabaña debe ingresar un valor numerico entero", true);
        }
    }

    @FXML
    protected void onClickEliminar(){
        Alojamiento sel = tabla.getSelectionModel().getSelectedItem();
        if(sel == null){
            mostrarMensaje("Debe seleccionar un elemento para eliminar", true);
            return;
        }
        lista.remove(sel);
        mostrarMensaje("Eliminado correctamente", false);
        tabla.getSelectionModel().clearSelection();
    }
}
