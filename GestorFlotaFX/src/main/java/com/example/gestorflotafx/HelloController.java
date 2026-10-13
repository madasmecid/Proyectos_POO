package com.example.gestorflotafx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    @FXML
    private ComboBox<String> cmbTipo;
    @FXML
    private TextField txtPatente;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtAnio;
    @FXML
    private TextField txtEspecifico;
    @FXML
    private Label lblEstado;

    @FXML
    private TableView<Vehiculo> tblVehiculos;
    @FXML
    private TableColumn<Vehiculo, String> colPatente;
    @FXML
    private TableColumn<Vehiculo, String> colMarca;
    @FXML
    private TableColumn<Vehiculo, Integer> colAnio;
    @FXML
    private TableColumn<Vehiculo, String> colDetalle;

    private final GestorFlota gestor = new GestorFlota();

    @FXML
    public void initialize() {
        cmbTipo.getItems().addAll("Auto", "Furgón");
        cmbTipo.getSelectionModel().selectFirst();

        // Enlaza las columnas con los getters: getPatente(), getMarca(), getAnio(), getDetalleEspecifico()
        colPatente.setCellValueFactory(new PropertyValueFactory<>("patente"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colDetalle.setCellValueFactory(new PropertyValueFactory<>("detalleEspecifico"));

        // Conecta la tabla a la lista observable del gestor
        tblVehiculos.setItems(gestor.getListaVehiculos());
    }

    @FXML
    private void onGuardarClick() {
        String tipo = cmbTipo.getValue();
        String patente = txtPatente.getText();
        String marca = txtMarca.getText();
        String anio = txtAnio.getText();
        String especifico = txtEspecifico.getText();

        try {
            if ("Auto".equals(tipo)) {
                gestor.agregarAuto(patente, marca, anio, especifico);
            } else if ("Furgón".equals(tipo)) {
                gestor.agregarFurgon(patente, marca, anio, especifico);
            }

            lblEstado.setText("Vehículo registrado con éxito.");
            lblEstado.setStyle("-fx-text-fill: green;");
            limpiarCampos();

        } catch (IllegalArgumentException e) {
            lblEstado.setText("Error: " + e.getMessage());
            lblEstado.setStyle("-fx-text-fill: red;");
        }
    }

    private void limpiarCampos() {
        txtPatente.clear();
        txtMarca.clear();
        txtAnio.clear();
        txtEspecifico.clear();
    }
}