package cl.duoc.gestormenbresiagimnasiotp2.control;

import cl.duoc.gestormenbresiagimnasiotp2.modelo.Socio;
import cl.duoc.gestormenbresiagimnasiotp2.modelo.SocioEstandar;
import cl.duoc.gestormenbresiagimnasiotp2.modelo.SocioVip;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private Label lblMensaje, lblDetalle;
    @FXML
    private TextField txtNombre, txtRut, txtDetalle;
    @FXML
    private ComboBox<String> cmbTipo;
    @FXML
    private TableView<Socio> tabla;
    @FXML
    private TableColumn<Socio, String> colRut,colNombre, colCosto, colDetalle;

    private ObservableList<Socio> lista = FXCollections.observableArrayList();


    public void initialize(){
        tabla.setItems(lista);
        cmbTipo.getItems().addAll("Estandar", "VIP");
        cmbTipo.setOnAction(e -> lblDetalle.setText("Estandar".equals(cmbTipo.getValue()) ? "tiene locker ?" : "N° sesiones perzonalizadas"));

        cmbTipo.getSelectionModel().selectFirst();

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colRut.setCellValueFactory(new PropertyValueFactory<>("rut"));


        colCosto.setCellValueFactory(d -> new SimpleStringProperty("$" + d.getValue().calcularCuotaMensual()));

        colDetalle.setCellValueFactory(d -> {Socio s = d.getValue();
        return new SimpleStringProperty(s instanceof SocioEstandar ? "dias con locker:  " + ((SocioEstandar)s).getAccesoLocker(): "N° sesiones perzonalizadas: " + ((SocioVip)s).getSesionesPerzonalizadas());
        });
    }

    @FXML
    public void onClickGuardar(){
        try {
            String nombre = txtNombre.getText().trim();
            String rut = txtRut.getText().trim();
            int detalle = Integer.parseInt(txtDetalle.getText());

            if (nombre.isEmpty() || rut.isEmpty()) {
                mostrarMensaje("Todos los campos son obligatorios", true);
                return;
            }
            Socio nuevo = "Estandar".equals(cmbTipo.getValue()) ? new SocioEstandar(rut, nombre, detalle) : new SocioVip(rut, nombre, detalle);
            lista.add(nuevo);
            mostrarMensaje("Socio agregado correctamente", false);
            txtDetalle.clear();
            txtNombre.clear();
            txtRut.clear();
        }catch (NumberFormatException e){
            mostrarMensaje("El valor ingresado debe ser numerico", true);
        }
    }

    @FXML
    public void onClickEliminar(){
        Socio sel = tabla.getSelectionModel().getSelectedItem();
        if(sel == null){
            mostrarMensaje("Debe seleccionar un socio para eliminar", true);
            return;
        }
        lista.remove(sel);
        mostrarMensaje("Socio eliminado correctamente", false);
    }





    protected void mostrarMensaje(String mensaje, boolean esError){
        lblMensaje.setText(mensaje);
        lblMensaje.setStyle(esError ? "-fx-text-fill:red;fx-font-weight:bold" : "-fx-text-fill:green;-fx-font-weight: bold");
    }
}
