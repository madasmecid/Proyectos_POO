/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca2;

/**
 *
 * @author madas
 */
public class Revista extends Material implements IPrestamoExtendio {
        
        private int numeroEdicion;
        private boolean circulacionEspecial;
        private boolean dispiniblePrestamoExtendido;

    public Revista() {
    }

    public Revista(int numeroEdicion, boolean circulacionEspecial, boolean dispiniblePrestamoExtendido, String titulo, int anioPublicacion, int paginas) {
        super(titulo, anioPublicacion, paginas);
        this.numeroEdicion = numeroEdicion;
        this.circulacionEspecial = circulacionEspecial;
        this.dispiniblePrestamoExtendido = dispiniblePrestamoExtendido;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion){
        if(numeroEdicion <= 0){
            throw new IllegalArgumentException (
            "El numero de edicion debe ser un numero entero mayor a 0");
        }
        this.numeroEdicion = numeroEdicion;
    }

    public boolean isCirculacionEspecial() {
        return circulacionEspecial;
    }

    public void setCirculacionEspecial(boolean circulacionEspecial) {
        this.circulacionEspecial = circulacionEspecial;
    }

    public boolean isDispiniblePrestamoExtendido() {
        return dispiniblePrestamoExtendido;
    }

    public void setDispiniblePrestamoExtendido(boolean dispiniblePrestamoExtendido) {
        this.dispiniblePrestamoExtendido = dispiniblePrestamoExtendido;
    }
        
        
    


    @Override
    public double calcularCostoReposicion() {
        double costo = 8000;
        if(circulacionEspecial){
            costo += costo *0.25;
        }
        return costo;
    }

    @Override
    public boolean esDisponibleParaPrestamoExtendido() {
        return dispiniblePrestamoExtendido = true;

    }

    @Override
    public void marcarDisponibleParaPrestamoExtendido() {
        this.dispiniblePrestamoExtendido = true;
    }
    
}
