/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiontallermecanico;

/**
 *
 * @author Compu
 */
public class CambioAceite extends Servicio {
    private String tipoAceite;
    private boolean filtroPremium;

    public CambioAceite() {
    }

    public CambioAceite(String tipoAceite, boolean filtroPremium, String codigo, int anioVehiculo, int horasManoObra) {
        super(codigo, anioVehiculo, horasManoObra);
        setTipoAceite(tipoAceite);
        this.filtroPremium = filtroPremium;
    }

    public String getTipoAceite() {
        return tipoAceite;
    }

    public void setTipoAceite(String tipoAceite) {
        if(tipoAceite == null || tipoAceite.trim().isEmpty()){
            throw new IllegalArgumentException("Tipo de aceite no puede quedar vacio");
        }
        this.tipoAceite = tipoAceite;
    }

    public boolean isFiltroPremium() {
        return filtroPremium;
    }

    public void setFiltroPremium(boolean filtroPremium) {
        this.filtroPremium = filtroPremium;
    }
    
    
    
    

    @Override
    public double calcularCostoTotal() {
        double tarifaBase = 30000;
        if (filtroPremium){
            tarifaBase += tarifaBase *0.25;
        }
        return tarifaBase;
    }
    
}
