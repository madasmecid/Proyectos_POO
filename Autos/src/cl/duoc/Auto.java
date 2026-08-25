
package cl.duoc;



public class Auto extends Vehiculo {
    // Poner atributos en private es buena practica
   private int cantidadPuertas;
   
   public Auto(){
       super(); // LLama al constructor vacio de vheiculo
   }
   
   //Constructor completo
   
   public Auto(String marca, String modelo, int kilometros, int cantidadPuertas){
       //super debe ser siempre la primera linea y eso inicializara la parte de vheiculo de la super clase
       super(marca, modelo, kilometros);
       this.cantidadPuertas = cantidadPuertas;
   }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }
   
   public void abrirMaletero(){
       System.out.println("El maletero del auto " + getModelo()+ " ha sido abierto");
   }
   
   @Override
   public String toString(){
       return "auto{" + "marca=" + getMarca() + ", modelo= " + getModelo() +", kilometros= " + getKilometros() +", puertas=" + cantidadPuertas + '}';
   }

  
    
    
    
    
}
