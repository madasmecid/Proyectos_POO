/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempleadosremuneraciones;

import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;

/**
 *
 * @author Compu
 */
public class EmpresaGestor {
    private ArrayList<Empleado> empleados;

    public EmpresaGestor() {
        this.empleados = new ArrayList<>();
    }
    
    public void agregarEmpleado(Empleado e){
        if(e == null){
            throw new IllegalArgumentException("Empleado a agregar no puede ser nulo");
        }else{
            empleados.add(e);
            System.out.println("Nuevo empleado agregado: " + e.getRut());
        }
    }
    
    public void pagarBonos(){
        for(Empleado e : empleados){
            if(e instanceof EmpleadoComision c){
                c.asignarBono(10);
                System.out.println("Se le pago bono al trabajador rut: "+ c.getRut());
            }
        }
    }
    
    public void mostrarPlanilla(){
        for(Empleado e : empleados){
            System.out.println("Rut: " + e.getRut()+" Sueldo base: $"+ (long)e.getSueldoBase()+ " sueldo liquido: $"+ (long)e.calcularSueldoLiquido());
        }
    }
    
    
    
}
