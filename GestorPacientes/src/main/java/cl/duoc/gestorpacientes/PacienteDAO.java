package cl.duoc.gestorpacientes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private static final String ARCHIVO = "pacientes.json";
    private Gson gson = new Gson();

    public void guardar(List<Paciente> lista) {

        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(lista, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Paciente> cargar() {
        try (FileReader reader = new FileReader(ARCHIVO)){
            Type type = new TypeToken<ArrayList<Paciente>>(){}.getType();
            List<Paciente> lista = gson.fromJson(reader, type);
            return (lista != null) ? lista : new ArrayList<>();
        }catch (Exception e){
            return new ArrayList<>();
        }
    }
}

