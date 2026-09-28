/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorenvioslogisticas;

/**
 *
 * @author Compu
 */
public class EnvioAereo extends Envio implements IPromocionable{
    private double pesoKg;

    public EnvioAereo() {
    }

    public EnvioAereo(double pesoKg, String codigoSeguimiento, double costoBase) {
        super(codigoSeguimiento, costoBase);
        setPesoKg(pesoKg);
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        if(pesoKg <= 0){
            throw new IllegalArgumentException("EL peso no puede ser 0 o menor. Intente nuevamente.");
        }
        this.pesoKg = pesoKg;
    }

    @Override
    public double calcularCostoTotal() {
        double recargoCombustible = 12.0 / 100.0;
        double recargoKg = getPesoKg() * 3500;
        double costoTotal = super.getCostoBase()+(super.getCostoBase() * recargoCombustible) + recargoKg;
        return Math.round(costoTotal);
    }

    @Override
    public boolean aplicarDescuento(double porcentaje) {
        if(porcentaje <= 0 || porcentaje > 50){
            return false;
        }else{
            double descuento = super.getCostoBase()* (porcentaje /100.0);
            super.setCostoBase(super.getCostoBase() - descuento);
            return true;
        }
    }
    
    
}
