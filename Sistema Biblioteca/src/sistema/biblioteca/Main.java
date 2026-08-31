
package sistema.biblioteca;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

  
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        String nombreBuscar = null;
        
        ArrayList<Material> biblioteca = new ArrayList<>();
        
        
       Libro libro1 = new Libro("stephen king","magica", "2.0", "503", "k6669", "payaso its", "1996");
       Libro libro2 = new Libro("jeny","harry", "9", "456", "h789", "harry potter 1", "2001");
       Libro libro3 = new Libro("fordo","miot", "3.1", "943", "l0998j", "el quijote", "1869");
       
       Revista revista1 = new Revista("djfdf", "dfdewd", "dfwd", "dwowkfd","ddsfe", "dkjjj");
       Revista revista2 = new Revista("rer", "oiijh", "hhj", "kkk","ggg", "dkhhhjjj");
       Revista revista3 = new Revista("tfyu", "hhhh", "dfgggwd", "dwhhhowkfd","ddkkksfe", "dkllljjj");
       
       Ebook ebook1 = new Ebook("fds","sda", "wdfsad", "dfasd", "fdsda", "wdfsad", "dwsda", 4.5);
       Ebook ebook2 = new Ebook("jjjjj","sdkjha", "wdfkhjsad", "dfahhsd", "fdjjsda", "wdfskkad", "dwsdlla", 6);
       Ebook ebook3 = new Ebook("hhhfds","skjhkda", "wdfjkhsad", "hjh", "fldsda", "wdfjjsad", "dwhhsda", 3.1);
       
       biblioteca.add(libro1);
       biblioteca.add(libro2);
       biblioteca.add(libro3);
       biblioteca.add(ebook1);
       biblioteca.add(ebook2);
       //biblioteca.add(ebook3);
       biblioteca.add(revista1);
       biblioteca.add(revista2);
       //biblioteca.add(revista3);
       
        System.out.println("\nEn inventario tenemos " + biblioteca.size()+ " materiales disponibles");
       
        //System.out.println(biblioteca.size());
        
        //System.out.println("primer elemento: " + biblioteca.get(0));
        
        for (int i = 0; i < biblioteca.size(); i++){
            
            
            biblioteca.get(i).prestar();
            
        }
        nombreBuscar = "payaso its";
        
        boolean encontrado = false;
        for (int e = 0; e < biblioteca.size(); e++){  
            //System.out.println(biblioteca.get(e));
            if (nombreBuscar.equals(biblioteca.get(e).getNombre())) {
                System.out.println("material encontrado " + biblioteca.get(e));
                encontrado = true;
            }
        }
        
        if (!encontrado){
            System.out.println("Material no encontrado");
        }
     
    }
    
}
