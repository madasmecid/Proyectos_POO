package cl.duoc.sistemagimnasio.dao;

import cl.duoc.sistemagimnasio.modelo.Socio;
import cl.duoc.sistemagimnasio.modelo.SocioEstudiante;
import cl.duoc.sistemagimnasio.modelo.SocioPro;
import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class GimnasiodaoImpl implements IGimnasioDao {

    private static final String ARCHIVO = "SOCIO.JSON";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public List<Socio> cargar() {
        List<Socio> lista = new ArrayList<>();
        File file = new File(ARCHIVO);

        // Si el archivo no existe aún, retorna la lista vacía sin dar error
        if (!file.exists()) {
            return lista;
        }

        try (FileReader reader = new FileReader(file)) {
            JsonElement parsed = JsonParser.parseReader(reader);
            if (parsed.isJsonArray()) {
                JsonArray array = parsed.getAsJsonArray();
                for (JsonElement e : array) {
                    JsonObject obj = e.getAsJsonObject();
                    String nombre = obj.get("nombre").getAsString();
                    String rut = obj.get("rut").getAsString();

                    if (obj.has("diasClases")) {
                        lista.add(new SocioEstudiante(rut, nombre, obj.get("diasClases").getAsInt()));
                    } else if (obj.has("mesesContratado")) {
                        lista.add(new SocioPro(rut, nombre, obj.get("mesesContratado").getAsInt()));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar JSON: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void guardar(List<Socio> lista) {
        // Implementación de la escritura en el archivo JSON
        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(lista, writer);
        } catch (Exception e) {
            System.out.println("Error al guardar JSON: " + e.getMessage());
        }
    }
}