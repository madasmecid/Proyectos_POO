package cl.duoc.registrovehiculosfx;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

    private static final String ARCHIVO = "Vehiculos.json";
    private Gson gson = new Gson();

    //METODO GUARDAR LA LISTA COMPLETA EN EL JSON
    public void guardar(List<Vehiculo> lista){
        try (FileWriter writer = new FileWriter(ARCHIVO)){
            gson.toJson(lista, writer);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //METODO CARGAR LISTA DESDE EL JSON
    public List<Vehiculo> cargar(){
        try (FileReader reader = new FileReader(ARCHIVO)){
            Type type = new TypeToken<ArrayList<Vehiculo>>(){}.getType();
            List<Vehiculo> lista = gson.fromJson(reader, type);
            return (lista != null) ? lista :new ArrayList<>();
        } catch (Exception e){

            return new ArrayList<>();
        }
    }
}
