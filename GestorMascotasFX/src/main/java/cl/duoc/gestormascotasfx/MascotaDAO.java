package cl.duoc.gestormascotasfx;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {
    private static final String ARCHIVO = "mascotas.json";
    private Gson gson = new Gson();

    public void guardar(List<Mascota> lista){
        try(FileWriter writer = new FileWriter(ARCHIVO)){
            gson.toJson(lista, writer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Mascota> cargar(){
        try(FileReader reader = new FileReader(ARCHIVO)){
            Type type = new TypeToken<ArrayList<Mascota>>(){}.getType();
            List<Mascota> lista = gson.fromJson(reader, type);
            return (lista != null) ? lista : new ArrayList<>();
        }catch (Exception e){
            return  new ArrayList<>();
        }
    }
}
