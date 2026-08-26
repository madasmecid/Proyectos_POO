/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc;

/**
 *
 * @author Compu
 */
public class Terrestre extends Mascota {
    
    private int numPatas;

    public Terrestre(int numPatas) {
        this.numPatas = numPatas;
    }

    public Terrestre(int numPatas, String nombre, String duenio, String ciudad) {
        super(nombre, duenio, ciudad);
        this.numPatas = numPatas;
    }
    
    

    public int getNumPatas() {
        return numPatas;
    }

    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }

    @Override
    public String toString() {
        return super.toString() + "Terrestre{" + "numPatas=" + numPatas + '}';
    }
    
    public void correr(){
        System.out.println(super.getNombre() + " sale corriendo!!");
    }

    @Override
    void hacerSonido() {
        System.out.println("Hace ruido al caminar");
    }
    
    
    
    
    
    

  
    
    
   
   
    
}
