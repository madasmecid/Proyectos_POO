package cl.duoc.autotech.controller;

import cl.duoc.autotech.model.Vehiculo;
import cl.duoc.autotech.repository.VehiculoRepository;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.stream.Stream;

public class MainController {
    private final VehiculoRepository repository = new VehiculoRepository();

    @FXML private TextField txtFiltro;
    @FXML private Button btnNuevo;
    @FXML private Button btnEliminar;
    @FXML private TableView<Vehiculo> tblVehiculos;
    @FXML private TableColumn<Vehiculo, String> colPatente;
    @FXML private TableColumn<Vehiculo, String> colMarca;
    @FXML private TableColumn<Vehiculo, String> colModelo;
    @FXML private TableColumn<Vehiculo, Integer> colAnio;
    @FXML private TableColumn<Vehiculo, Double> colPrecio;
    @FXML private TableColumn<Vehiculo, Boolean> colDisponible;

    private FilteredList<Vehiculo> vehiculosFiltrados;

    @FXML
    public void initialize() {
        colPatente.setCellValueFactory(c -> c.getValue().patenteProperty());
        colMarca.setCellValueFactory(c -> c.getValue().marcaProperty());
        colModelo.setCellValueFactory(c -> c.getValue().modeloProperty());
        colAnio.setCellValueFactory(c -> c.getValue().anioProperty().asObject());
        colPrecio.setCellValueFactory(c -> c.getValue().precioProperty().asObject());
        colDisponible.setCellValueFactory(c -> c.getValue().disponibleProperty());

        colDisponible.setCellFactory(CheckBoxTableCell.forTableColumn(colDisponible));
        tblVehiculos.setEditable(true);
        colDisponible.setEditable(true);

        vehiculosFiltrados = new FilteredList<>(repository.obtenerVehiculos(), v -> true);
        tblVehiculos.setItems(vehiculosFiltrados);

        repository.obtenerVehiculos().addListener((ListChangeListener<Vehiculo>) cambio -> {
            while (cambio.next()) {
                if (cambio.wasUpdated()) {
                    repository.guardar();
                    break;
                }
            }
        });

        txtFiltro.textProperty().addListener((obs, oldVal, newVal) -> filtrar(newVal));
        btnEliminar.disableProperty().bind(tblVehiculos.getSelectionModel().selectedItemProperty().isNull());
    }

    @FXML
    private void onNuevo() throws IOException {
        var loader = new FXMLLoader(getClass().getResource("/cl/duoc/autotech/view/form-view.fxml"));
        Parent root = loader.load();

        FormController formController = loader.getController();
        formController.setRepository(repository);

        var stage = new Stage();
        stage.setTitle("Nuevo vehículo");
        stage.initOwner(btnNuevo.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);

        var scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onEliminar() {
        Vehiculo seleccionado = tblVehiculos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            repository.quitarVehiculo(seleccionado);
            repository.guardar();
        }
    }

    private void filtrar(String texto) {
        String filtro = (texto == null) ? "" : texto.trim().toLowerCase();
        vehiculosFiltrados.setPredicate(v -> filtro.isEmpty() ||
                Stream.of(v.getPatente(), v.getMarca(), v.getModelo())
                        .anyMatch(campo -> campo != null && campo.toLowerCase().contains(filtro))
        );
    }
}