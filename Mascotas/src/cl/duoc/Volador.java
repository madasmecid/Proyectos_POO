/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc;

/**
 *
 * @author Compu
 */
public class Volador extends Mascota {
    
    private int cantidadAlas;

    public Volador(int cantidadAlas) {
        this.cantidadAlas = cantidadAlas;
    }

    public Volador(int cantidadAlas, String nombre, String duenio, String ciudad) {
        super(nombre, duenio, ciudad);
        this.cantidadAlas = cantidadAlas;
    }

    public int getCantidadAlas() {
        return cantidadAlas;
    }

    public void setCantidadAlas(int cantidadAlas) {
        this.cantidadAlas = cantidadAlas;
    }

    @Override
    public String toString() {
        return super.toString()+ "Volador{" + "cantidadAlas=" + cantidadAlas + '}';
    }
    
    public void volar() {
        System.out.println(super.getNombre()+ " sale volando!!");
    }
    
    

    @Override
    void hacerSonido() {
        System.out.println("Hace ruido al aletear");
    }
    
}
