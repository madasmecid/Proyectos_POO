/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiontallermecanico;

/**
 *
 * @author Compu
 */
public abstract class Servicio {
    
    private String codigo;
    private int anioVehiculo;
    private int horasManoObra;

    public Servicio() {
    }

    public Servicio(String codigo, int anioVehiculo, int horasManoObra) {
        setCodigo(codigo);
        setAnioVehiculo(anioVehiculo);
        setHorasManoObra(horasManoObra);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("el Codigo No puede ser nulo ni estar vacio");
        }
        this.codigo = codigo;
    }

    public int getAnioVehiculo() {
        return anioVehiculo;
    }

    public void setAnioVehiculo(int anioVehiculo) {
        if(anioVehiculo < 1990 || anioVehiculo > 2026){
            throw new IllegalArgumentException("El anio debe encontrarse entre 1990 y 2026");
        }
        this.anioVehiculo = anioVehiculo;
    }

    public int getHorasManoObra() {
        return horasManoObra;
    }

    public void setHorasManoObra(int horasManoObra) {
        if(horasManoObra <= 0){
            throw new IllegalArgumentException("Debe ser mayor a 0");
        }
        this.horasManoObra = horasManoObra;
    }
    
    public abstract double calcularCostoTotal();

    @Override
    public String toString() {
        return "codigo: " + codigo + " --- anioVehiculo: " + anioVehiculo;
    }
    
    
    
}
