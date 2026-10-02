package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtNumero1;

    @FXML
    private TextField txtNumero2;

    @FXML
    private Label lblResultado;

    @FXML
    private Label lblResultado2;

    @FXML
    private Label lblResultado3;

    @FXML
    protected void onSumarClick() {
        try {

            //Para obtener los textos de la caja 1 y 2
            String texto1 = txtNumero1.getText();
            String texto2 = txtNumero2.getText();

            //convertir esos textos en numeros
            double numero1 = Double.parseDouble(texto1);
            double numero2 = Double.parseDouble(texto2);

            //operacion matematica
            double suma = numero1 + numero2;
            double resta = numero1 - numero2;
            double multiplicacion = numero1 * numero2;

            //mostrar el resultado en el label
            lblResultado.setText("Resultado de la suma es: " + (long)suma);
            lblResultado2.setText("Resultado de la resta es: " + (long) resta);
            lblResultado3.setText("El resultado de la multiplicación es: "+ (long) multiplicacion);

        }catch (NumberFormatException e) {

        //Si el usuario deja vacio o ingresa letas
        lblResultado.setText("Error ingrese solo numeros validos");
    }


        }


    }

