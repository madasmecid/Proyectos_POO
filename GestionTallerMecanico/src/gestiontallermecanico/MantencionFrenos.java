/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiontallermecanico;

/**
 *
 * @author Compu
 */
public class MantencionFrenos extends Servicio implements IGarantiaExtendida{
    private String tipoLiquido;
    private boolean incluyeRectificado;
    private boolean garantiaExtendida;

    public MantencionFrenos() {
    }
    public MantencionFrenos(String tipoLiquido, boolean incluyeRectificado, boolean garantiaExtendida, String codigo, int anioVehiculo, int horasManoObra) {
        super(codigo, anioVehiculo, horasManoObra);
        setTipoLiquido(tipoLiquido);
        this.incluyeRectificado = incluyeRectificado;
        this.garantiaExtendida = garantiaExtendida;
    }

    public String getTipoLiquido() {
        return tipoLiquido;
    }

    public void setTipoLiquido(String tipoLiquido) {
        if(tipoLiquido == null || tipoLiquido.trim().isEmpty()){
            throw new IllegalArgumentException("No puede quedar vacio o nulo.");
        }
        this.tipoLiquido = tipoLiquido;
    }

    public boolean isIncluyeRectificado() {
        return incluyeRectificado;
    }

    public void setIncluyeRectificado(boolean incluyeRectificado) {
        this.incluyeRectificado = incluyeRectificado;
    }

    public boolean isGarantiaExtendida() {
        return garantiaExtendida;
    }

    public void setGarantiaExtendida(boolean garantiaExtendida) {
        this.garantiaExtendida = garantiaExtendida;
    }
    
    
    
    

    @Override
    public double calcularCostoTotal() {
        double tarifaBase = 45000;
        if(super.getHorasManoObra()> 3){
            tarifaBase += tarifaBase *0.2;
        }
       return tarifaBase;
    }

    @Override
    public boolean aplicarGarantiaExtendida() {
        return garantiaExtendida == true;
    }
    
}
