package cl.duoc.tiendamusica.dao;

import cl.duoc.tiendamusica.model.Guitarra;
import cl.duoc.tiendamusica.model.Instrumento;
import cl.duoc.tiendamusica.model.Teclado;
import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class InstrumentoDaoImpl implements InstrumentoDao{
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public List<Instrumento> cargar() {
        List<Instrumento> lista = new ArrayList<>();
        try{
            JsonArray array = JsonParser.parseReader(new FileReader("instrumentos.json")).getAsJsonArray();
            for (JsonElement e : array){
                JsonObject obj = e.getAsJsonObject();
                String codigo = obj.get("codigo").getAsString();
                String marca = obj.get("marca").getAsString();


                if(obj.has("cuerdas")){
                    lista.add(new Guitarra(marca,codigo, obj.get("cuerdas").getAsInt()));
                }else{
                    lista.add(new Teclado(marca,codigo,obj.get("teclas").getAsInt()));
                }
            }
        }catch (Exception e){
            //falla silenciosa
        }
        return lista;
    }

    @Override
    public void guardar(List<Instrumento> lista) {
        try (Writer w = new FileWriter("instrumentos.json")){
            gson.toJson(lista, w);
        }catch (Exception e){
            throw  new RuntimeException("Error al guardar en el archivo JSON");
        }
    }
}

