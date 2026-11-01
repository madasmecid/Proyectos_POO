package cl.duoc.gestorequipos;

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
    private Label lblError;
    @FXML
    private TextField txtSerie;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtRam;
    @FXML
    private TableView<Equipo> tablaEquipos;
    @FXML
    private TableColumn<String,Equipo> colSerie;
    @FXML
    private TableColumn<String, Equipo> colMarca;
    @FXML
    private TableColumn<Integer, Equipo> colRam;

    private ObservableList<Equipo> listaEquipos = FXCollections.observableArrayList();

    EquipoDAO equipoDAO = new EquipoDAO();

   @FXML
    public void initialize(){
       colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
       colRam.setCellValueFactory(new PropertyValueFactory<>("ram"));
       colSerie.setCellValueFactory(new PropertyValueFactory<>("serie"));

       tablaEquipos.setItems(listaEquipos);

       listaEquipos.addAll(equipoDAO.cargar());
   }

   @FXML
    protected void onGuardarClick() {
       String serie = txtSerie.getText();
       if (serie.isBlank()) {
           lblError.setText("serie incorrecta");
           return;
       }
       String marca = txtMarca.getText();
       if (marca.isBlank()) {
           lblError.setText("Marca ingresa es incorrecta");
           return;
       }

       int ram;
       try{
           ram = Integer.parseInt(txtRam.getText().trim());
       }catch (NumberFormatException e){
           lblError.setText("La ram debe ser un numero valido");
           return;
       }

       lblError.setText("");


       Equipo nuevoEquipo = new Equipo(serie, marca, ram);

       listaEquipos.add(nuevoEquipo);
       equipoDAO.guardar(listaEquipos);
       txtMarca.clear();
       txtRam.clear();
       txtSerie.clear();
   }

   @FXML
    protected void onEliminarClick(){
       Equipo seleccionado = tablaEquipos.getSelectionModel().getSelectedItem();
       if(seleccionado != null){
           listaEquipos.remove(seleccionado);

           equipoDAO.guardar(listaEquipos);
       }
   }
}
