package cl.duoc.gestorequipos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label lblError;
    @FXML
    private TextField txtSerie;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtRam;
    @FXML
    private TableView<Equipo> tablaEquipos;
    @FXML
    private TableColumn<String,Equipo> colSerie;
    @FXML
    private TableColumn<String, Equipo> colModelo;
    @FXML
    private TableColumn<Integer, Equipo> colRam;

    private ObservableList<Equipo> listaEquipos = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
