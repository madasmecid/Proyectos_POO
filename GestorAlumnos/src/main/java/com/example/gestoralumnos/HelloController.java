package com.example.gestoralumnos;

import javafx.beans.Observable;
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
    private  TableColumn<Alumno, Integer> colEdad;

    private ObservableList<Alumno> listaAlumnos = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        colRut.setCellValueFactory(new PropertyValueFactory<>("rut"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        tablaAlumnos.setItems(listaAlumnos);
    }

    @FXML
    protected void onGuardarClick(){

        String rut = txtRut.getText();
        String nombre = txtNombre.getText();
        int edad = Integer.parseInt(txtEdad.getText());

        Alumno nuevoAlumno = new Alumno(rut, nombre, edad);

        listaAlumnos.add(nuevoAlumno);

        txtEdad.clear();
        txtNombre.clear();
        txtRut.clear();
    }

}
