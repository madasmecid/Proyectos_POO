package cl.duoc.registroalumnos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    private static final String ARCHIVO = "alumnos.json";
    private  Gson gson = new Gson();

    //Guardar la lista completa en el archivo JSON

    public void guardar(List<Alumno> lista){
        try (FileWriter writer = new FileWriter(ARCHIVO)){
            gson.toJson(lista,writer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Cargar los alumnos almacenados en el archivo JSON

    public List<Alumno> cargar() {
        try (FileReader reader = new FileReader(ARCHIVO)) {
            Type type = new TypeToken<ArrayList<Alumno>>() {}.getType();
            List<Alumno> lista = gson.fromJson(reader, type);
            return (lista != null) ? lista : new ArrayList<>();
        } catch (Exception e) {
            // si el archivo no existe aun, retorna lista vacia

            return new ArrayList<>();
        }
    }
}
