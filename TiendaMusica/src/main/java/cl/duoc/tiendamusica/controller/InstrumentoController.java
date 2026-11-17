package cl.duoc.tiendamusica.controller;

import cl.duoc.tiendamusica.model.Guitarra;
import cl.duoc.tiendamusica.model.Instrumento;
import cl.duoc.tiendamusica.model.Teclado;
import cl.duoc.tiendamusica.repository.InstrumentoRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class InstrumentoController {
    @FXML
    private TextField txtMarca, txtCodigo, txtDetalle;
    @FXML
    private Label lblMensaje, lblDetalle;
    @FXML
    private ComboBox<String> cmbDetalle;

    @FXML
    private TableView<Instrumento> tabla;
    @FXML
    private TableColumn<Instrumento, String> colMarca, colCodigo;
    @FXML
    private TableColumn<Instrumento, String> colDetalle, colPrecio;

    private InstrumentoRepository repo = new InstrumentoRepository();
    private ObservableList<Instrumento> obs =
            FXCollections.observableArrayList(repo.getMemoria());

    @FXML
    public void initialize(){
        tabla.setItems(obs);
        cmbDetalle.getItems().addAll("Guitarra", "Teclado");
        cmbDetalle.setOnAction(e -> lblDetalle.setText("Guitarra".equals(cmbDetalle.getValue())? "Cuerdas" :
                "Teclas"));
        cmbDetalle.getSelectionModel().selectFirst();

        colCodigo.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCodigo()));
        colMarca.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getMarca()));
        colPrecio.setCellValueFactory(d -> new SimpleStringProperty("$" + d.getValue().calcularPrecioArriendo()));


        colDetalle.setCellValueFactory(d -> {
            Instrumento i = d.getValue();
            return new SimpleStringProperty(i instanceof Guitarra ?
                    "cuerdas " + ((Guitarra)i).getCuerdas():
                    "teclas " + ((Teclado)i).getTeclas());

        });
    }

    public void agregar(){
        try{
            String codigo = txtCodigo.getText().trim();
            String marca = txtMarca.getText().trim();
            int detalle = Integer.parseInt(txtDetalle.getText());

            if (codigo.isEmpty() || marca.isEmpty()){
                mostarMensaje("complete todos los campos", true);
                return;
            }
            if (detalle <= 0){
                mostarMensaje("La cantidad no puede ser 0 o menor", true);
                return;
            }
            Instrumento nuevo = "Guitarra".equals(cmbDetalle.getValue()) ?
                    new Guitarra(marca,codigo,detalle):
                    new Teclado(marca,codigo,detalle);

            repo.agregar(nuevo);
            obs.add(nuevo);
            mostarMensaje("Agregado con exito", false);
            txtCodigo.clear();txtMarca.clear();txtDetalle.clear();
        }catch (NumberFormatException e){
            mostarMensaje("Valor ingresado debe ser un numero entero" , true);
        }catch (RuntimeException e){
            mostarMensaje("Error al guardar datos", true);
        }
    }

    public void eliminar(){
        Instrumento select = tabla.getSelectionModel().getSelectedItem();
        if(select == null){
            mostarMensaje("Debe seleccionar un elemento de la lista para eliminar", true);
            return;
        }
        try {
            repo.eliminar(select);
            obs.remove(select);
            mostarMensaje("Instrumento eliminado", false);
            tabla.getSelectionModel().clearSelection();
        }catch (RuntimeException e){
            mostarMensaje("Error al guardar datos", true);
        }
    }

    private void mostarMensaje(String mensaje, boolean esError){
        lblMensaje.setText(mensaje);
        lblMensaje.setStyle(esError ? "-fx-text-fill: red;" : "-fx-text-fill: green;" );
    }
}
