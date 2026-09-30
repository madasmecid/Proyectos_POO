/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallermecanicoautofix;

/**
 *
 * @author SB-Alumno
 */
public class Furgon extends Vehiculo {
    private double cargaTonelada;

    public Furgon() {
    }

    public Furgon(double cargaTonelada, String marca, int annioFabricacion, double kilometraje) {
        super(marca, annioFabricacion, kilometraje);
        setCargaTonelada(cargaTonelada);
    }

    public double getCargaTonelada() {
        return cargaTonelada;
    }

    public void setCargaTonelada(double cargaTonelada) {
        if(cargaTonelada <= 0){
            throw new IllegalArgumentException("Capacidad de carga debe ser mayor a 0.");
        }
        this.cargaTonelada = cargaTonelada;
    }
    
    

    @Override
    public double calcularCosto() {
        double costoBase = 35000;
        if(cargaTonelada > 1.5){
            double cargoTonelada = costoBase * 0.25;
            costoBase += cargoTonelada;
        }
        return costoBase;
      }

    @Override
    public String toString() {
        return "tipo: Furgon | marca: "+ super.getMarca()+ " | annio: "+ super.getAnnioFabricacion()+ " | kilometraje: "+ super.getKilometraje() +" | Capacidad: "+ getCargaTonelada()+" Toneladas | costo servicio: "+ calcularCosto();           
    }
    
    
    
}
