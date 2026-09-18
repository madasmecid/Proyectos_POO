/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarriendovehiculos;

/**
 *
 * @author Compu
 */
public abstract class Vehiculo {
    private String patente;
    private int annio;
    private int diasArriendo;

    public Vehiculo() {
    }

    public Vehiculo(String patente, int annio, int diasArriendo) {
        setPatente(patente);
        setAnnio(annio);
        setDiasArriendo(diasArriendo);
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        if(patente == null || patente.trim().isEmpty()){
            throw new IllegalArgumentException("valor ingresado incorrectamente, no puede quedar vacio en patente");
        }
        this.patente = patente;
    }

    public int getAnnio() {
        return annio;
    }

    public void setAnnio(int annio) {
        if(annio < 2000 || annio > 2026 ){
            throw new IllegalArgumentException("El año debe estar entre el 2000 y 2026");
        }
        this.annio = annio;
    }

    public int getDiasArriendo() {
        return diasArriendo;
    }

    public void setDiasArriendo(int diasArriendo) {
        if(diasArriendo <= 0){
            throw new IllegalArgumentException("Los dias de arriendo deben ser mayor a 0");
        }
        this.diasArriendo = diasArriendo;
    }

    @Override
    public String toString() {
        return "patente: " + patente + " -- annio=" + annio;
    }
    
    public abstract double calcularTotalArriendo();
    
    
    
}
