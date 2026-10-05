package com.example.fichamedica;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private TextField txtRut;
    @FXML
    private TextField txtNombre;
     @FXML
     private TextField txtEdad;
     @FXML
     private TextField txtPeso;

     @FXML
     private ListView<String> listaUno;


     @FXML
     private TextField txtBuscarRut;
     @FXML
     private Label lblEstado;

     private final ArrayList<Paciente> listaPacientes = new ArrayList<>();

     private ObservableList<Paciente> listaNueva = FXCollections.observableArrayList();

    @FXML
    private void onGuardarClick() {
        try {
            String rut = txtRut.getText().trim();
            String nombre = txtNombre.getText().trim();

            if (rut.isEmpty() || nombre.isEmpty()) {
                lblEstado.setText("Complete rut y Nombre.");
                return;
            }

            int edad = Integer.parseInt(txtEdad.getText().trim());
            double peso = Double.parseDouble(txtPeso.getText().trim());

            Paciente nuevo = new Paciente(rut, nombre, edad, peso);
            listaPacientes.add(nuevo);

            lblEstado.setText("Guardado con exito: " + nombre);

            txtRut.clear();
            txtNombre.clear();
            txtEdad.clear();
            txtPeso.clear();
        } catch (NumberFormatException e) {
            lblEstado.setText("Error: edad y peso deben ser numeros validos");
        }
    }

    @FXML
    private void onBuscarClick(){
        String rutConsulta = txtBuscarRut.getText().trim();

        if(rutConsulta.isEmpty()){
            lblEstado.setText("ingrese rut para buscar.");
            return;
        }

        for(Paciente p : listaPacientes){
            if(p.getRut().equalsIgnoreCase(rutConsulta)){
                lblEstado.setText("paciente: "+ p.getNombre() + " edad: "+ p.getEdad());
                return;
            }
        }
        lblEstado.setText("no se encontro paciente con ese rut.");
    }

    @FXML
    private void onListarCLick() {
        try {
            // Limpiamos los elementos visuales usando la variable correcta
            listaUno.getItems().clear();

            // Si no hay pacientes guardados, avisamos
            if (listaPacientes.isEmpty()) {
                lblEstado.setText("No hay pacientes registrados para listar.");
                return;
            }

            // Recorremos tu ArrayList y los metemos al ListView
            for (Paciente p : listaPacientes) {
                String fila = "RUT: " + p.getRut() + " - " + p.getNombre() + " (" + p.getEdad() + " años)";
                listaUno.getItems().add(fila);
            }

            lblEstado.setText("Lista actualizada con " + listaPacientes.size() + " pacientes.");
        } catch (Exception e) {
            lblEstado.setText("Error en la aplicación.");
            e.printStackTrace();
        }
    }
}
