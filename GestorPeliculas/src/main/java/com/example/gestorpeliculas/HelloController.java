package com.example.gestorpeliculas;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtDirector;
    @FXML
    private TextField txtAnnio;

    @FXML
    private Label lblEstado;

    //lista guardar peliculas

    private final ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

    private ObservableList<Pelicula> mostrar = FXCollections.observableArrayList();



    @FXML
    protected void onGuardarCLick() {
        try{
            String titulo = txtTitulo.getText().trim();
            String director = txtDirector.getText().trim();

            if (titulo.isEmpty() || director.isEmpty()){
                lblEstado.setText("Complete campos director y titulo");
                return;
            }

            int annio = Integer.parseInt(txtAnnio.getText().trim());

            Pelicula nueva = new Pelicula(titulo, annio, director);
            listaPeliculas.add(nueva);

            lblEstado.setText("Pelicula guardada con exito: "+ titulo);

            txtAnnio.clear();
            txtDirector.clear();
            txtDirector.clear();
        }catch (NumberFormatException e ){
            lblEstado.setText("Error: annio debe ser un numero valido");
        }
    }
}
