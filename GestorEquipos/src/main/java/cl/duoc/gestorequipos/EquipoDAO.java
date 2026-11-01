package cl.duoc.gestorequipos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private static final String ARCHIVO = "equipos.json";
    private Gson gson = new Gson();

    public void guardar(List<Equipo> lista){
        try (FileWriter writer = new FileWriter(ARCHIVO)){
            gson.toJson(lista, writer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Equipo> cargar(){
        try(FileReader reader = new FileReader(ARCHIVO)){
            Type type = new TypeToken<ArrayList<Equipo>>(){}.getType();
            List<Equipo> lista = gson.fromJson(reader,type);
            return (lista != null) ? lista : new ArrayList<>();
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

}
