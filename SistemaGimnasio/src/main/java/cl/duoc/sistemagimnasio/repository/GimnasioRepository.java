package cl.duoc.sistemagimnasio.repository;

import cl.duoc.sistemagimnasio.dao.GimnasiodaoImpl;
import cl.duoc.sistemagimnasio.dao.IGimnasioDao;
import cl.duoc.sistemagimnasio.modelo.Socio;

import java.util.List;

public class GimnasioRepository {
    private IGimnasioDao dao = new GimnasiodaoImpl();
    private List<Socio> memoria = dao.cargar();
    public List<Socio> getMemoria(){
        return memoria;
    }
    public void agregar (Socio s){
        memoria.add(s);
        dao.guardar(memoria);
    }

    public void eliminar(Socio s){
        memoria.remove(s);
        dao.guardar(memoria);
    }
}
