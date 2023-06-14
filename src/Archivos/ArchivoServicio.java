package Archivos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Cliente;
import models.Servicio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ArchivoServicio {
    private Gson gson;
    private File file;

    public ArchivoServicio(){
        gson = new Gson();
        file = new File("Archivos/servicios.json");

    }

    public void crearArchivo(ArrayList<Servicio> listaServicios) {
        FileWriter writer = null;
        if(!listaServicios.isEmpty()){
            try {
                writer = new FileWriter(file);
                gson.toJson(listaServicios, writer);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<Servicio> leerArchivo(){
        FileReader reader = null;
        ArrayList<Servicio> lista = null;
        if(file.exists()){
            try{
                reader = new FileReader(file);
                Type clienteListType = new TypeToken<ArrayList<Servicio>>() {}.getType();
                lista = gson.fromJson(reader, clienteListType);
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                try{
                    reader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("El archivo servicios.json no existe");
        }
        return lista;
    }

}
