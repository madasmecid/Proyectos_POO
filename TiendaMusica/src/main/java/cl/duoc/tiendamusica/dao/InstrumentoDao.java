package cl.duoc.tiendamusica.dao;

import cl.duoc.tiendamusica.model.Instrumento;

import java.util.List;

public interface InstrumentoDao {
    List<Instrumento> cargar();
    void guardar(List<Instrumento> lista);
}
