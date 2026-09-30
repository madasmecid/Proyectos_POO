/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallermecanicoautofix;

/**
 *
 * @author SB-Alumno
 */
public class Auto extends Vehiculo implements IGarantizable{
    private String modelo;
    private boolean vigenciaGarantia;
    private boolean garantiaActiva;

    public Auto() {
    }

    public Auto(String modelo, boolean vigenciaGarantia, boolean garantiaActiva, String marca, int annioFabricacion, double kilometraje) {
        super(marca, annioFabricacion, kilometraje);
        setModelo(modelo);
        this.vigenciaGarantia = vigenciaGarantia;
        this.garantiaActiva = garantiaActiva;
    }

    
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if(modelo == null | modelo.trim().isEmpty()){
            throw new IllegalArgumentException("Modelo no puede ser nulo ni vacío.");
        }
        this.modelo = modelo;
    }

    public boolean isVigenciaGarantia() {
        return vigenciaGarantia;
    }

    public void setVigenciaGarantia(boolean vigenciaGarantia) {
        this.vigenciaGarantia = vigenciaGarantia;
    }
    
    
    public boolean isGarantiaActiva() {
        return garantiaActiva;
    }

    public void setGarantiaActiva(boolean garantiaActiva) {
        this.garantiaActiva = garantiaActiva;
    }
    
    

    @Override
    public boolean tieneGarantia() {
        return this.garantiaActiva;
    }

    @Override
    public boolean activarGarantia() {
        return this.vigenciaGarantia;
    }

    @Override
    public double calcularCosto() {
        double costoBase = 25000;
        if(!vigenciaGarantia){
            double CargoGarantia =costoBase * 0.30;
            costoBase += CargoGarantia;
        }
        return costoBase;
    }

    @Override
    public String toString() {
        
        String garantia = garantiaActiva ? "Si": "No";
        String garantiaVigente = vigenciaGarantia ? "Si": "No";
        
        return "tipo: Auto | " + "marca: "+ super.getMarca()+ " | annio: "+ super.getAnnioFabricacion()+ " | kilometraje: "+ super.getKilometraje()+" "
                + "| modelo: "+ getModelo()+ " | garantia vigente: "+ garantiaVigente+ " | garantia activa: "+ garantia+" | costo servicio: "+ calcularCosto();
    }
    
    
}
