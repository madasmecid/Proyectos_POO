/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemamantenimientoequipos;

/**
 *
 * @author Compu
 */
public class EquipoIndustrial extends Equipo implements IGarantizable{
    private int horasUso;

    public EquipoIndustrial() {
    }

    public EquipoIndustrial(int horasUso, String codigo, double costoBase) {
        super(codigo, costoBase);
        setHorasUso(horasUso);
    }

    public int getHorasUso() {
        return horasUso;
    }

    public void setHorasUso(int horasUso) {
        if(horasUso <= 0){
            throw new IllegalArgumentException("EL numero de horas de uso no puede ser 0 o menor que 0.");
        }
        this.horasUso = horasUso;
    }
    
    
    

    @Override
    public double calcularCostoMantencion() {
        double cargoPorHora = horasUso * 200;
        double cargoMantencion = getCostoBase() * 0.10;
        double costroTotal = getCostoBase() + cargoPorHora+ cargoMantencion;
        return Math.round(costroTotal);
    }

    @Override
    public boolean aplicarGarantia(double porcentaje) {
        double descuento = getCostoBase() * (porcentaje / 100.0);
        if(porcentaje <= 0 || porcentaje > 40){
            return false;
        }else{
            setCostoBase(getCostoBase() - descuento);
        }
        return true;
    }
    
    
    
}
