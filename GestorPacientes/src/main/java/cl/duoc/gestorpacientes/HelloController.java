package cl.duoc.gestorpacientes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtRut;
    @FXML
    private TextField txtEdad;

    @FXML
    private TableView<Paciente> tablaPacientes;

    @FXML
    private TableColumn<Paciente, String> colRut;
    @FXML
    private TableColumn<Paciente, String> colNombre;
    @FXML
    private TableColumn<Paciente, Integer> colEdad;

    private ObservableList<Paciente> listaPacientes = FXCollections.observableArrayList();
    private PacienteDAO pacientedao = new PacienteDAO();

    @FXML
    public void initialize(){
        colRut.setCellValueFactory(new PropertyValueFactory<>("rut"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        listaPacientes.addAll(pacientedao.cargar());

        tablaPacientes.setItems(listaPacientes);
    }


    @FXML
    protected void onGuardarClick(){
        String rut = txtRut.getText();
        String nombre = txtNombre.getText();
        int edad = Integer.parseInt(txtEdad.getText());

        Paciente nuevoPaciente = new Paciente(rut, nombre, edad);

        listaPacientes.add(nuevoPaciente);

        pacientedao.guardar(listaPacientes);

        txtEdad.clear();
        txtNombre.clear();
        txtRut.clear();


    }

    @FXML
    protected void onEliminarClick(){
        Paciente seleccionado = tablaPacientes.getSelectionModel().getSelectedItem();
        if(seleccionado != null){
            listaPacientes.remove(seleccionado);
            pacientedao.guardar(listaPacientes);
        }
    }
}
