package cl.duoc.tiendamusica.repository;

import cl.duoc.tiendamusica.dao.InstrumentoDao;
import cl.duoc.tiendamusica.dao.InstrumentoDaoImpl;
import cl.duoc.tiendamusica.model.Instrumento;

import java.util.List;

public class InstrumentoRepository {
    private InstrumentoDao dao = new InstrumentoDaoImpl();
    private List<Instrumento> memoria = dao.cargar();

    public List<Instrumento> getMemoria(){
        return memoria;
    }

    public void agregar(Instrumento i){
        memoria.add(i);
        try{
            dao.guardar(memoria);
        }catch (RuntimeException e){
            memoria.remove(i);
            throw  e;
        }
    }

    public void eliminar (Instrumento i){
        memoria.remove(i);
        try{
            dao.guardar(memoria);
        }catch (RuntimeException e){
            memoria.add(i);
            throw e;
        }
    }
}
