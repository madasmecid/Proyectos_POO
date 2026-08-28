
package sistema.biblioteca;


public class Main {

  
    public static void main(String[] args) {
        
        
       Libro libro1 = new Libro("sss","ssdd", "wssdd", "ssds", "ssdad", "sssad", "sssss");
       
       Revista revista1 = new Revista("djfdf", "dfdewd", "dfwd", "dwowkfd","ddsfe", "dkjjj");
       
       Ebook ebook1 = new Ebook("fds","sda", "wdfsad", "dfasd", "fdsda", "wdfsad", "dwsda", 4.5);
       
       libro1.prestar();
       revista1.prestar();
       libro1.buscarLibrosMismoAutor();
       revista1.consultarMismoContenido();
       
       ebook1.descargar();
       ebook1.buscarLibrosMismoAutor();
       
        System.out.println("\n "+ libro1.toString());
        System.out.println("\n "+ ebook1.toString());

        System.out.println("\n "+ revista1.toString());

     
    }
    
}
