package cl.duoc.gestorlibros;

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
    private TextField txtIsbn;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtPaginas;

    @FXML
    private TableView<Libro> tablaLibros;
    @FXML
    private TableColumn<String, Libro> colIsbn;
    @FXML
    private TableColumn<String, Libro> colTitulo;
    @FXML
    private TableColumn<Integer, Libro> colPaginas;

    ObservableList<Libro> listaLibros = FXCollections.observableArrayList();

    private LIbrosDAO librosdao = new LIbrosDAO();


    @FXML
    public void initialize(){
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colPaginas.setCellValueFactory(new PropertyValueFactory<>("paginas"));

        tablaLibros.setItems(listaLibros);
        listaLibros.addAll(librosdao.cargar());

        tablaLibros.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) ->{
            if (seleccionado != null){
                txtIsbn.setText(seleccionado.getIsbn());
                txtTitulo.setText(seleccionado.getTitulo());
                txtPaginas.setText(String.valueOf(seleccionado.getPaginas()));

            }
        });


    }

    @FXML
    protected void onGuardarClick(){
        String isbn = txtIsbn.getText();
        String titulo = txtTitulo.getText();
        int paginas = Integer.parseInt(txtPaginas.getText());

        Libro nuevoLibro = new Libro(isbn, titulo,paginas);
        listaLibros.add(nuevoLibro);

        librosdao.guardar(listaLibros);
    }

    @FXML
    protected void onEliminarClick(){
        Libro seleccionado = tablaLibros.getSelectionModel().getSelectedItem();
        if (seleccionado != null){
            listaLibros.remove(seleccionado);

            librosdao.guardar(listaLibros);
        }
    }

    @FXML
    protected  void onActualizarClick(){
        Libro seleccionado = tablaLibros.getSelectionModel().getSelectedItem();
        if (seleccionado != null){
            seleccionado.setIsbn((txtIsbn.getText()));
            seleccionado.setTitulo(txtTitulo.getText());
            seleccionado.setPaginas(Integer.parseInt(txtPaginas.getText()));

            tablaLibros.refresh();
            librosdao.guardar(listaLibros);

            txtPaginas.clear();
            txtTitulo.clear();
            txtIsbn.clear();
        }
    }
}
