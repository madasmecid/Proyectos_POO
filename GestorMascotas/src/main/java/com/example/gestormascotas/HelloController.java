package com.example.gestormascotas;

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
    private TextField txtChip;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEspecie;

    @FXML
    private TableView<Mascota> tablaMascotas;
    @FXML
    private TableColumn<Mascota, String> colChip;
    @FXML
    private TableColumn<Mascota, String> colNombre;
    @FXML
    private TableColumn<Mascota, String> colEspecie;

    private ObservableList<Mascota> listaMascotas = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        colChip.setCellValueFactory(new PropertyValueFactory<>("chip"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));

        tablaMascotas.setItems(listaMascotas);
    }

    @FXML
    protected void onGuardarClick(){
        String chip = txtChip.getText();
        String nombre = txtNombre.getText();
        String especie = txtEspecie.getText();

        Mascota mascotaNueva = new Mascota(chip,nombre, especie);

        listaMascotas.add(mascotaNueva);

        txtChip.clear();
        txtNombre.clear();
        txtEspecie.clear();

    }
}
