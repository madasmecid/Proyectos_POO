/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servimaq;

/**
 *
 * @author Compu
 */
public class MantenimientoPreventivo extends OrdenMantenimiento implements ISErvicioUrgente{
    
    private String tipoRevision;
    private boolean esUrgente;

    public MantenimientoPreventivo() {
    }

    public MantenimientoPreventivo(String tipoRevision, boolean esUrgente, String CodigoOrden, int anioFabricacion, int horasTrabajo) {
        super(CodigoOrden, anioFabricacion, horasTrabajo);
        setTipoRevision(tipoRevision);
        this.esUrgente = esUrgente;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public void setTipoRevision(String tipoRevision) {
        if(tipoRevision == null|| tipoRevision.trim().isEmpty()){
            throw new IllegalArgumentException("tipo de revision mal ingresado. no puede estar vacio");
        }
        this.tipoRevision = tipoRevision;
    }

    public boolean isEsUrgente() {
        return esUrgente;
    }

    public void setEsUrgente(boolean esUrgente) {
        this.esUrgente = esUrgente;
    }
    
    

    @Override
    public double calcularCostoFinal() {
        double tarifaBase = 35000 * getHorasTrabajo();
        if(getHorasTrabajo() > 4){
            tarifaBase += tarifaBase *0.10;
        }
        if(esAtencionUrgente()){
            tarifaBase += 15000;
        }
        return tarifaBase;
    }

    @Override
    public boolean esAtencionUrgente() {
        return esUrgente;
    }
    
}
