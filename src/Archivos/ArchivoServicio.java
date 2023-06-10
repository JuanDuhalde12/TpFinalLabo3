package Archivos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Servicio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ArchivoServicio {
    private ArrayList<Servicio> listaServicios;
    private Gson gson;
    private File file;

    public ArchivoServicio(){
        listaServicios = new ArrayList<Servicio>();
        gson = new Gson();
        file = new File("Archivos/servicios.json");

    }

    public void agregarServicio(Servicio servicio){
        this.listaServicios.add(servicio);
    }

    public void crearArchivo() {
        FileWriter writer = null;
        if(!file.exists()) {
            try {
                writer = new FileWriter(file);
                Gson gson = new Gson();
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
        }else{
            System.out.println("El archivo servicios.json ya existe");
        }
    }

    public void leerArchivo(){
        FileReader reader = null;
        if(file.exists()){
            try{
                reader = new FileReader(file);
                Gson gson = new Gson();
                Type clienteListType = new TypeToken<ArrayList<Servicio>>() {}.getType();
                this.listaServicios = gson.fromJson(reader, clienteListType);
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
    }

    public void listar(){
        for (Servicio s:this.listaServicios) {
            System.out.println(s.toString());
        }
    }
}
