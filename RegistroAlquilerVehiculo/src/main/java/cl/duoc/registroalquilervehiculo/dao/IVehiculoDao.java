package cl.duoc.registroalquilervehiculo.dao;

import cl.duoc.registroalquilervehiculo.modelo.Vehiculo;

import java.util.List;

public interface IVehiculoDao {
    List<Vehiculo> cargar();

    void guardar(List<Vehiculo> lista);
}
