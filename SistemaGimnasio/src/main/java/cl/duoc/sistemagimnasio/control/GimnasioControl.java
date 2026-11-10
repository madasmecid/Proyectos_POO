package cl.duoc.sistemagimnasio.control;

import cl.duoc.sistemagimnasio.modelo.Socio;
import cl.duoc.sistemagimnasio.modelo.SocioEstudiante;
import cl.duoc.sistemagimnasio.modelo.SocioPro;
import cl.duoc.sistemagimnasio.repository.GimnasioRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class GimnasioControl {
    @FXML
    private TextField txtRut, txtNombre, txtDetalle;

    @FXML
    private Label lblDetalle, lblMensaje;

    @FXML
    private ComboBox<String> cmbTipo;

    @FXML
    private TableView<Socio> tblSocios;

    @FXML
    private TableColumn<Socio, String> colRut, colNombre, colCuota, colDetalle;
    private GimnasioRepository repo = new GimnasioRepository();

    private ObservableList<Socio> listaSocios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        tblSocios.setItems(listaSocios);
        listaSocios.setAll(repo.getMemoria());

        cmbTipo.getItems().addAll("Seleccione", "Estudiante", "Pro");
        cmbTipo.getSelectionModel().selectFirst();
        cambiarTipo();

        // Columnas directas
        colRut.setCellValueFactory(new PropertyValueFactory<>("rut"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        // Columna calculada ($) usando calcularCostoMensual() de tu modelo
        colCuota.setCellValueFactory(d -> {
            int cuota = d.getValue().calcularCostoMensual();
            return new SimpleStringProperty(String.format("$%,d", cuota).replace(',', '.'));
        });

        // Columna detalle según tus atributos (diasClases / mesesContratado)
        colDetalle.setCellValueFactory(d -> {
            Socio s = d.getValue();
            if (s instanceof SocioEstudiante) {
                int dias = ((SocioEstudiante) s).getDiasClases();
                return new SimpleStringProperty("Días clase: " + dias);
            } else if (s instanceof SocioPro) {
                int meses = ((SocioPro) s).getMesesContratado();
                return new SimpleStringProperty("Meses: " + meses);
            }
            return new SimpleStringProperty("-");
        });
    }

    @FXML
    protected void onClickGuardar() {
        limpiarMensaje();
        try {
            String rut = txtRut.getText().trim();
            String nombre = txtNombre.getText().trim();
            String detalleTexto = txtDetalle.getText().trim();
            String tipo = cmbTipo.getValue();

            if (tipo == null || "Seleccione".equals(tipo)) {
                mostrarMensaje("Debe seleccionar un tipo de socio", true);
                return;
            }

            if (rut.isEmpty() || nombre.isEmpty() || detalleTexto.isEmpty()) {
                mostrarMensaje("Todos los campos son obligatorios", true);
                return;
            }

            // Ambos modelos esperan un entero en el detalle
            int valorDetalle = Integer.parseInt(detalleTexto);

            if (valorDetalle <= 0) {
                mostrarMensaje("El valor del detalle debe ser un número entero mayor a 0", true);
                return;
            }

            Socio nuevoSocio;

            if ("Estudiante".equals(tipo)) {
                nuevoSocio = new SocioEstudiante(rut, nombre, valorDetalle);
            } else {
                nuevoSocio = new SocioPro(rut, nombre, valorDetalle);
            }

            repo.agregar(nuevoSocio);
            listaSocios.setAll(repo.getMemoria());
            mostrarMensaje("Socio registrado exitosamente", false);
            limpiarFormulario();

        } catch (NumberFormatException e) {
            mostrarMensaje("El campo detalle debe ser un número entero válido", true);
        }
    }

    @FXML
    protected void onClickEliminar() {
        limpiarMensaje();
        Socio seleccionado = tblSocios.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarMensaje("Debe seleccionar un socio de la tabla para eliminar", true);
            return;
        }

        repo.eliminar(seleccionado);
        listaSocios.remove(seleccionado);
        tblSocios.getSelectionModel().clearSelection();
        mostrarMensaje("Socio eliminado correctamente", false);
    }

    @FXML
    public void cambiarTipo() {
        limpiarMensaje();
        String tipo = cmbTipo.getValue();

        if ("Estudiante".equals(tipo)) {
            lblDetalle.setText("Días de clases:");
            txtDetalle.setPromptText("Ej: 12");
        } else if ("Pro".equals(tipo)) {
            lblDetalle.setText("Meses contratados:");
            txtDetalle.setPromptText("Ej: 6");
        } else {
            lblDetalle.setText("Detalle:");
            txtDetalle.setPromptText("Seleccione tipo primero");
        }
    }

    private void limpiarFormulario() {
        txtRut.clear();
        txtNombre.clear();
        txtDetalle.clear();
        cmbTipo.getSelectionModel().selectFirst();
        cambiarTipo();
    }

    private void limpiarMensaje() {
        lblMensaje.setText("");
    }

    private void mostrarMensaje(String mensaje, boolean esError) {
        lblMensaje.setText(mensaje);
        lblMensaje.setStyle(esError ? "-fx-text-fill: red; -fx-font-weight: bold;"
                : "-fx-text-fill: green; -fx-font-weight: bold;");
    }
}

