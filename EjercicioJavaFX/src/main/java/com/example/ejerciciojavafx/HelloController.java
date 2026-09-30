package com.example.ejerciciojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    // Enlazados con los fx:id del archivo FXML
    @FXML
    private TextField txtNombre;

    @FXML
    private CheckBox chkAcepto;

    @FXML
    private Label lblMensaje;

    // Vinculado con onAction="#onGuardarClick"
    @FXML
    protected void onGuardarClick() {
        String nombre = txtNombre.getText();

        if (nombre == null || nombre.trim().isEmpty()) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Por favor, ingrese un nombre válido.");
            return;
        }

        if (!chkAcepto.isSelected()) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Debe marcar la casilla de aceptación.");
            return;
        }

        lblMensaje.setStyle("-fx-text-fill: green;");
        lblMensaje.setText("¡Bienvenido/a, " + nombre.trim() + "!");
    }

    // Vinculado con onAction="#onLimpiarClick"
    @FXML
    protected void onLimpiarClick() {
        txtNombre.clear();
        chkAcepto.setSelected(false);
        lblMensaje.setText("");
    }
}