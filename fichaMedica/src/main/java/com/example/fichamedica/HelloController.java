package com.example.fichamedica;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
     private TextField txtBuscarRut;
     @FXML
     private Label lblEstado;

     private final ArrayList<Paciente> listaPacientes = new ArrayList<>();

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
}
