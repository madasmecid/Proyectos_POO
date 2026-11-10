package cl.duoc.sistemagimnasio.dao;

import cl.duoc.sistemagimnasio.modelo.Socio;

import java.util.List;

public interface IGimnasioDao {
    List<Socio> cargar();

    void guardar (List<Socio> lista);
}
