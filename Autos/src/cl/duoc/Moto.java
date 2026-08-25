/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc;

/**
 *
 * @author Compu
 */
public class Moto extends Vehiculo {
    
    private boolean tieneParabrisas;
    
    public Moto(){
        super();
    }
    
    public Moto (String marca, String modelo, int kilometros, boolean tieneParabrisas){
        super (marca, modelo,kilometros);
        this.tieneParabrisas = tieneParabrisas;
    }
    
    public boolean isTieneParabrisas() {
        return tieneParabrisas;
    }
    
    public void setTieneParabrisas(boolean tieneParabrisas){
        this.tieneParabrisas = tieneParabrisas;
    }
    
    public void pararRueda(){
        System.out.println("La moto " + getModelo() + " paro rueda de forma espectacular");
    }
    
    @Override
    public String toString(){
        return "moto{" + "marca = " + getMarca() + ", modelo = " + getModelo() + ", kilometros = " + getKilometros() + ", parabrisas = " + tieneParabrisas + '}';
    }
    
    
}
