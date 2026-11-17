package cl.duoc.autotech.model;

import javafx.beans.property.*;

public class Vehiculo {
    private String patente = "";
    private String marca = "";
    private String modelo = "";
    private int anio = 0;
    private double precio = 0.0;
    private boolean disponible = false;

    // 'transient' hace que Gson ignore estas propiedades de JavaFX al leer/escribir JSON
    private transient StringProperty patenteProp;
    private transient StringProperty marcaProp;
    private transient StringProperty modeloProp;
    private transient IntegerProperty anioProp;
    private transient DoubleProperty precioProp;
    private transient BooleanProperty disponibleProp;

    public Vehiculo() {
    }

    public Vehiculo(String patente, String marca, String modelo, int anio, double precio, boolean disponible) {
        setPatente(patente);
        setMarca(marca);
        setModelo(modelo);
        setAnio(anio);
        setPrecio(precio);
        setDisponible(disponible);
    }

    public String getPatente() { return patente; }
    public void setPatente(String patente) {
        this.patente = patente;
        if (patenteProp != null) patenteProp.set(patente);
    }
    public StringProperty patenteProperty() {
        if (patenteProp == null) patenteProp = new SimpleStringProperty(patente);
        return patenteProp;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) {
        this.marca = marca;
        if (marcaProp != null) marcaProp.set(marca);
    }
    public StringProperty marcaProperty() {
        if (marcaProp == null) marcaProp = new SimpleStringProperty(marca);
        return marcaProp;
    }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) {
        this.modelo = modelo;
        if (modeloProp != null) modeloProp.set(modelo);
    }
    public StringProperty modeloProperty() {
        if (modeloProp == null) modeloProp = new SimpleStringProperty(modelo);
        return modeloProp;
    }

    public int getAnio() { return anio; }
    public void setAnio(int anio) {
        this.anio = anio;
        if (anioProp != null) anioProp.set(anio);
    }
    public IntegerProperty anioProperty() {
        if (anioProp == null) anioProp = new SimpleIntegerProperty(anio);
        return anioProp;
    }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        this.precio = precio;
        if (precioProp != null) precioProp.set(precio);
    }
    public DoubleProperty precioProperty() {
        if (precioProp == null) precioProp = new SimpleDoubleProperty(precio);
        return precioProp;
    }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
        if (disponibleProp != null) disponibleProp.set(disponible);
    }
    public BooleanProperty disponibleProperty() {
        if (disponibleProp == null) {
            disponibleProp = new SimpleBooleanProperty(disponible);
            // Sincroniza el campo 'disponible' cuando el usuario marca/desmarca el CheckBox en la tabla
            disponibleProp.addListener((obs, oldVal, newVal) -> this.disponible = newVal);
        }
        return disponibleProp;
    }
}