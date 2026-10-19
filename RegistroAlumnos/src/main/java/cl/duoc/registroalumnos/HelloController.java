package cl.duoc.registroalumnos;

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
    private TextField txtRut;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEdad;

    @FXML
    private TableView<Alumno> tablaAlumnos;
    @FXML
    private TableColumn<Alumno, String> colRut;
    @FXML
    private TableColumn<Alumno, String> colNombre;
    @FXML
    private TableColumn<Alumno, Integer> colEdad;

    //Lista observable que alimentará la tabla

    private ObservableList<Alumno> listaALumnos = FXCollections.observableArrayList();

    private AlumnoDAO alumnoDAO = new AlumnoDAO();

    @FXML
    public void initialize() {
        //conectar cada columna con los nombres de los atributos en Alumno.java(Getters)
        colRut.setCellValueFactory(new PropertyValueFactory<>("rut"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        //Cargar alumnos desde el archivo JSON
        listaALumnos.addAll(alumnoDAO.cargar());

        //Enlazar la lista observable a la tabla
        tablaAlumnos.setItems(listaALumnos);
        tablaAlumnos.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    protected void onGuardarClick() {
        //leer el texto ingresado en los campos
        String rut = txtRut.getText();
        String nombre = txtNombre.getText();
        int edad = Integer.parseInt(txtEdad.getText()); // convertir texto edad en entero

        //crear nuevo alumno con los datos ingresados

        Alumno nuevoAlumno = new Alumno(edad, nombre, rut);

        listaALumnos.add(nuevoAlumno);

        //Guardar la lista actualizada en el archivo JSON

        alumnoDAO.guardar(listaALumnos);

        txtEdad.clear();
        txtNombre.clear();
        txtRut.clear();
    }

}
