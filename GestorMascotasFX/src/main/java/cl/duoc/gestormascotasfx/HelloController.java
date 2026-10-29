package cl.duoc.gestormascotasfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField txtChip;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPeso;
    @FXML
    private ComboBox<String> cmbTipo;

    @FXML
    private TableView <Mascota> tablaMascotas;
    @FXML
    private TableColumn<String, Mascota> colChip;
    @FXML
    private TableColumn<String, Mascota> colNombre;
    @FXML
    private TableColumn<Integer, Mascota> colPeso;
    @FXML
    private TableColumn<String, Mascota> colTipo;

    private ObservableList<Mascota> listaMascotas = FXCollections.observableArrayList();

    private MascotaDAO mascotadao = new MascotaDAO();


    @FXML
    public void initialize(){
        cmbTipo.getItems().addAll("perro", "gato", "Gallina");
        colChip.setCellValueFactory(new PropertyValueFactory<>("chip"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        tablaMascotas.setItems(listaMascotas);
        listaMascotas.addAll(mascotadao.cargar());
    }
    @FXML
    protected void onGuardarClick(){
        String chip = txtChip.getText();
        String nombre = txtNombre.getText();
        int peso = Integer.parseInt(txtPeso.getText());
        String tipo = cmbTipo.getValue();
        if(tipo.isBlank() || tipo == null){
            return;
        }

        Mascota nuevaMascota = new Mascota(chip, nombre, peso, tipo);

        listaMascotas.add(nuevaMascota);
        txtChip.clear();
        txtNombre.clear();
        txtPeso.clear();
    }

    public void onEliminarClick(ActionEvent actionEvent) {
        Mascota seleccionado = tablaMascotas.getSelectionModel().getSelectedItem();
        if(seleccionado != null){
            listaMascotas.remove(seleccionado);
        }
    }

    public void onActualizarClick(ActionEvent actionEvent) {
    }
}
