
package sistema.biblioteca;
import java.util.ArrayList;


public class Main {

  
    public static void main(String[] args) {
        
        ArrayList<Material> biblioteca = new ArrayList<>();
        
        
       Libro libro1 = new Libro("sss","ssdd", "wssdd", "ssds", "ssdad", "sssad", "sssss");
       
       Revista revista1 = new Revista("djfdf", "dfdewd", "dfwd", "dwowkfd","ddsfe", "dkjjj");
       
       Ebook ebook1 = new Ebook("fds","sda", "wdfsad", "dfasd", "fdsda", "wdfsad", "dwsda", 4.5);
       
       biblioteca.add(libro1);
       biblioteca.add(ebook1);
       biblioteca.add(revista1);
       
        //System.out.println(biblioteca.size());
        
        //System.out.println("primer elemento: " + biblioteca.get(0));
        
        for (int i = 0; i < biblioteca.size(); i++){
            
            
            biblioteca.get(i).prestar();
            
        }
     
    }
    
}
