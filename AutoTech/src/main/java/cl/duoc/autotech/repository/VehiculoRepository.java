package cl.duoc.autotech.repository;

import cl.duoc.autotech.dao.VehiculoDao;
import cl.duoc.autotech.dao.VehiculoDaoImpl;
import cl.duoc.autotech.model.Vehiculo;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VehiculoRepository {
    private final Vehiculo dao = new VehiculoDaoImpl();
    private final ObservableList<Vehiculo> vehiculos =
            FXCollections.observableArrayList(v -> new Observable[]{v.disponibleProperty()});

    public VehiculoRepository() {
        vehiculos.setAll(dao.obte());
    }

    public ObservableList<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }

    public boolean existePatente(String patente) {
        if (patente == null || patente.isBlank()) return false;
        String buscada = patente.trim();
        return vehiculos.stream()
                .map(Vehiculo::getPatente)
                .filter(p -> p != null)
                .anyMatch(p -> p.trim().equalsIgnoreCase(buscada));
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (existePatente(vehiculo.getPatente())) {
            throw new IllegalArgumentException("Ya existe un vehículo con la patente " + vehiculo.getPatente());
        }
        vehiculos.add(vehiculo);
    }

    public void quitarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void guardar() {
        dao.guardar(vehiculos);
    }
}