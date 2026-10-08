package com.example.gestorflotafx;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GestorFlota {

    //1- lista observable reactiva que se conectará a la tabla

    private final ObservableList<Vehiculo> listaVehiculos = FXCollections.observableArrayList();

    //2 Metodo para que el controlador pueda pedir la lista



    public ObservableList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    //3 metodo para agregar un Auto con validacion de negocio

    public void agregarAuto(String patente, String marca, String anioTexto, String puertasTexto){
        validarCamposComunes(patente, marca, anioTexto);

        int anio = convertirEntero(anioTexto, "El año");
        validarRangoAnio(anio);

        int puertas = convertirEntero(puertasTexto, "La cantidad de puertas" );
        if(puertas < 2 || puertas > 7){
            throw  new IllegalArgumentException("La cantidad de puertas debe estar entre 2 y 7");
        }

        // SI PASA TODAS LAS VALIDACIONES, CREAMOS EL AUTO Y LO AGREGAMOS

        Auto auto = new Auto(patente, marca, anio, puertas);
        listaVehiculos.add(auto);
    }

    // 4 AGREGAR UN FURGON CON VALIDACIONES

    public void agregarFurgon (String patente, String marca, String anioTexto, String cargaTexto){
        validarCamposComunes(patente, marca, anioTexto);

        int anio = convertirEntero(anioTexto, "El año");
        validarRangoAnio(anio);

        double carga;
        try{
            carga = Double.parseDouble(cargaTexto.trim());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("La capacidad de carga debe ser un numero decimal valido");
        }

        if (carga <= 0){
            throw new IllegalArgumentException("La capacidad de carga debe ser mayor a 0");
        }

        //SI PASA TODAS LAS VALIDACIONES CREAMOS EL FURGON Y LO AGREGAMOS
        Furgon furgon = new Furgon(patente, marca, anio, carga );
        listaVehiculos.add(furgon);
    }


    //Metodos auxiliares de validacion

    private void validarCamposComunes(String patente, String marca, String anioTexto){
        if (patente == null || patente.isBlank() || marca == null || marca.isBlank() ||
                anioTexto == null || anioTexto.isBlank()) {
            throw new IllegalArgumentException("Todos los campos obligatorios deben completarse");
        }
    }

    private int convertirEntero(String texto, String nombreCampo){
        try{
            return Integer.parseInt(texto.trim());
        }catch (NumberFormatException e ){
            throw new IllegalArgumentException(nombreCampo + " debe ser un numero entero");
        }
    }

    private void validarRangoAnio(int anio){
        if (anio < 1960 || anio > 2030){
            throw  new IllegalArgumentException("El año debe estar entre 1960 y 2030");
        }
    }
}
