package cl.duoc.autotech.dao;

import cl.duoc.autotech.model.Vehiculo;
import java.util.List;

/**
 * Acceso a datos de vehículos (patrón DAO).
 * Define cómo se leen y escriben los vehículos, sin atarse a un medio de almacenamiento concreto.
 */
public interface VehiculoDao {

    /**
     * Lee todos los vehículos almacenados.
     *
     * @return lista de vehículos; vacía si no hay datos o no se pudieron leer
     */
    List<Vehiculo> obtenerVehiculos();

    /**
     * Guarda la lista completa de vehículos y reemplaza lo almacenado.
     *
     * @param vehiculos vehículos a guardar
     */
    void guardar(List<Vehiculo> vehiculos);
}