
package cl.duoc;


public class Main {

    public static void main(String[] args) {
        
        Terrestre auto1 = new Terrestre("Auto del jefe", "lambo", "gallardo", "345", 4);
        Aereo avion1 = new Aereo ("avion ejecutivo", "Trons", "agil", "3456", 234);
        
        System.out.println(auto1.toString());
        auto1.mantenimiento();
        auto1.detenerSemaforo();
        
        System.out.println("    ");
        
        System.out.println(avion1.toString());
        avion1.mantenimiento();
        avion1.despegar();
        
    }
    
}
