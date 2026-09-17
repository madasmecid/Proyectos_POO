/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca2;

/**
 *
 * @author madas
 */
public abstract class Material {
    private String titulo;
    private int anioPublicacion;
    private int paginas;
    
    public Material(){
        
    }

    public Material(String titulo, int anioPublicacion, int paginas) {
        setTitulo(titulo);
        setAnioPublicacion (anioPublicacion);
        setPaginas (paginas);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("El titulo no puede ser null ni estar vacio");
        }
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        //rango del 1600 al 2026
        if(anioPublicacion < 1600 || anioPublicacion > 2026){
            throw new IllegalArgumentException("el año de publicacion debe encontrarse entre 1600 y 2026");
        }
        this.anioPublicacion = anioPublicacion;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        //El numero debe ser mayor a 0 ni tampoco puede ser 0
        if (paginas <= 0){
            throw new IllegalArgumentException("El numero de paginas debe ser mayor a 0");
        }
        this.paginas = paginas;
    }
    
    public abstract double calcularCostoReposicion();

    @Override
    public String toString() {
        return "Material{" + "titulo=" + titulo + ", anioPublicacion=" + anioPublicacion + '}';
    }
    
}
