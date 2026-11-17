package cl.duoc.autotech.controller;

import cl.duoc.autotech.model.Vehiculo;
import cl.duoc.autotech.repository.VehiculoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class FormController {
    private static final String PATRON_PATENTE = "[A-Z0-9]{6}";
    private static final int ANIO_MINIMO = 1990;
    private static final String ALERTA_ERROR = "alert-danger";
    private static final String ALERTA_EXITO = "alert-success";

    private VehiculoRepository repository;

    @FXML private TextField txtPatente;
    @FXML private TextField txtMarca;
    @FXML private TextField txtModelo;
    @FXML private TextField txtAnio;
    @FXML private TextField txtPrecio;
    @FXML private CheckBox chkDisponible;
    @FXML private Label lblMensaje;
    @FXML private Button btnCancelar;
    @FXML private Button btnGuardar;

    public void setRepository(VehiculoRepository repository) {
        this.repository = repository;
    }

    @FXML
    private void onGuardar() {
        String patente = txtPatente.getText().trim().toUpperCase();
        String marca = txtMarca.getText().trim();
        String modelo = txtModelo.getText().trim();
        List<String> errores = new ArrayList<>();

        if (patente.isEmpty()) {
            errores.add("La patente es obligatoria.");
        } else if (!patente.matches(PATRON_PATENTE)) {
            errores.add("La patente debe tener 6 caracteres alfanuméricos (ej: BBCD12).");
        } else if (repository.existePatente(patente)) {
            errores.add("Ya existe un vehículo registrado con la patente " + patente + ".");
        }

        if (marca.isEmpty()) errores.add("La marca es obligatoria.");
        if (modelo.isEmpty()) errores.add("El modelo es obligatorio.");

        Integer anio = validarAnio(txtAnio.getText().trim(), errores);
        Double precio = validarPrecio(txtPrecio.getText().trim(), errores);

        if (!errores.isEmpty()) {
            mostrarMensaje(String.join("\n", errores), ALERTA_ERROR);
            return;
        }

        repository.agregarVehiculo(new Vehiculo(patente, marca, modelo, anio, precio, chkDisponible.isSelected()));
        repository.guardar();

        limpiarFormulario();
        mostrarMensaje("Vehículo " + patente + " registrado correctamente.", ALERTA_EXITO);
    }

    private Integer validarAnio(String texto, List<String> errores) {
        if (texto.isEmpty()) {
            errores.add("El año es obligatorio.");
            return null;
        }
        try {
            int anio = Integer.parseInt(texto);
            int anioMaximo = Year.now().getValue() + 1;
            if (anio < ANIO_MINIMO || anio > anioMaximo) {
                errores.add("El año debe estar entre " + ANIO_MINIMO + " y " + anioMaximo + ".");
            }
            return anio;
        } catch (NumberFormatException e) {
            errores.add("El año debe ser un número entero.");
            return null;
        }
    }

    private Double validarPrecio(String texto, List<String> errores) {
        if (texto.isEmpty()) {
            errores.add("El precio es obligatorio.");
            return null;
        }
        try {
            double precio = Double.parseDouble(texto.replace(',', '.'));
            if (precio <= 0) {
                errores.add("El precio debe ser mayor a cero.");
            }
            return precio;
        } catch (NumberFormatException e) {
            errores.add("El precio debe ser un valor numérico.");
            return null;
        }
    }

    @FXML
    private void onCancelar() {
        ((Stage) btnCancelar.getScene().getWindow()).close();
    }

    private void mostrarMensaje(String mensaje, String claseAlerta) {
        lblMensaje.getStyleClass().removeAll("alert", ALERTA_ERROR, ALERTA_EXITO);
        lblMensaje.getStyleClass().addAll("alert", claseAlerta);
        lblMensaje.setText(mensaje);
    }

    private void limpiarFormulario() {
        List.of(txtPatente, txtMarca, txtModelo, txtAnio, txtPrecio).forEach(TextField::clear);
        chkDisponible.setSelected(false);
        txtPatente.requestFocus();
    }
}