
package cl.duoc;


public class Main {

   
    public static void main(String[] args) {
        
        Auto auto1 = new Auto ("Suzuki", "Maruti", 5000, 5);
        
        System.out.println(auto1.toString());
        
        
        System.out.println("Marca heredada: "+ auto1.getMarca());
        auto1.avanzar(1500);
        
        auto1.abrirMaletero();
        
        
        Moto moto1 = new Moto ("Kawazaky", "termineitor", 3000, true);
        
        System.out.println(moto1.toString());
        
        
        System.out.println("Marca heredada: " + moto1.getMarca());
        
        moto1.avanzar(6000);
        
        moto1.pararRueda();
        
        
        
        
    }
    
}
