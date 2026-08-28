/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.biblioteca;

/**
 *
 * @author Compu
 */
public class Ebook extends Libro {
    
    private double tamanoMb;

    public Ebook(String autor, String editorial, String version, String numPaginas, String codigoMaterial, String nombre, String fechaPublicacion, double tamanoMb) {
        super(autor, editorial, version, numPaginas, codigoMaterial, nombre, fechaPublicacion);
        this.tamanoMb = tamanoMb;
    }


    public double getTamanoMb() {
        return tamanoMb;
    }

    public void setTamanoMb(double tamanoMb) {
        this.tamanoMb = tamanoMb;
    }

    @Override
    public String toString() {
        return "Ebook{" + super.toString()+ " tamanoMb: " + tamanoMb + '}';
    }
    
    
    public void descargar() {
        System.out.println("El usuario descargo el libro: " + super.getNombre());
    }
    
    
    
}
