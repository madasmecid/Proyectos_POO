package cl.duoc.registroalquilervehiculo.dao;

import cl.duoc.registroalquilervehiculo.modelo.Vehiculo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class VehiculoDaoImpl implements IVehiculoDao {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public List<Vehiculo> cargar() {
        return List.of();
    }

    @Override
    public void guardar(List<Vehiculo> lista) {

    }
}
