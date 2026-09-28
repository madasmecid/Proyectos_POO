/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempleadosremuneraciones;

/**
 *
 * @author Compu
 */
public class EmpleadoComision extends Empleado implements IBonificable{
    private double ventasMes;

    public EmpleadoComision() {
    }

    public EmpleadoComision(double ventasMes, String rut, double sueldoBase) {
        super(rut, sueldoBase);
        this.ventasMes = ventasMes;
    }

    public double getVentasMes() {
        return ventasMes;
    }

    public void setVentasMes(double ventasMes) {
        if(ventasMes < 0){
            throw new IllegalArgumentException("no puede ser menor a 0");
        }
        this.ventasMes = ventasMes;
    }

    @Override
    public double calcularSueldoLiquido() {
        double bonoVentas = ventasMes * ( 5.0/100.0);
        double descuentosLegales = super.getSueldoBase() * 0.2;
        double sueldoLiquido =(super.getSueldoBase()+ bonoVentas) - descuentosLegales;
        return sueldoLiquido;
    }

    @Override
    public boolean asignarBono(double porcentaje) {
        if(porcentaje <= 0 || ventasMes == 00){
            return false;
        }else{
            double bono = ventasMes *(porcentaje / 100.0);
            this.ventasMes += bono;
            return true;
        }
    }
    
    
    
}
