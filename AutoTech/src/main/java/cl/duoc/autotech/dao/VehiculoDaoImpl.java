package cl.duoc.autotech.dao;

import cl.duoc.autotech.dao.VehiculoDao;
import cl.duoc.autotech.model.Vehiculo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VehiculoDaoImpl implements VehiculoDao {
    private static final Type LISTA_VEHICULOS_TYPE = new TypeToken<ArrayList<Vehiculo>>() {}.getType();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Path filePath = Path.of("products.json");

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        if (Files.notExists(filePath)) {
            return new ArrayList<>();
        }
        try (var reader = Files.newBufferedReader(filePath)) {
            List<Vehiculo> lista = gson.fromJson(reader, LISTA_VEHICULOS_TYPE);
            return Objects.requireNonNullElseGet(lista, ArrayList::new);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void guardar(List<Vehiculo> vehiculos) {
        try (var writer = Files.newBufferedWriter(filePath)) {
            gson.toJson(vehiculos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}