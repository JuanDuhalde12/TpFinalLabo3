package Archivos;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.*;

public class ArchivoUsuario {
    private ArrayList<Usuario> listaUsuarios;
    private File file;

    public ArchivoUsuario(){
        this.listaUsuarios = new ArrayList<>();
        file = new File("Archivos/usuarios.json");
    }

    public void crearArchivoJson(){
        FileWriter writer = null;
        if(!file.exists()) {
            try {
                writer = new FileWriter(file);
                Gson gson = new Gson();
                gson.toJson(listaUsuarios, writer);
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
            System.out.println("El archivo usuarios.json ya existe");
        }
    }

    public void leerArchivo(){
        FileReader reader = null;
        if(file.exists()){
            try{
                reader = new FileReader(file);
                Gson gson = new Gson();
                Type clienteListType = new TypeToken<ArrayList<Usuario>>() {}.getType();
                this.listaUsuarios = gson.fromJson(reader, clienteListType);
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
            System.out.println("El archivo usuarios.json no existe");
        }
    }
    public void agregarUsuario(Usuario c){
        this.listaUsuarios.add(c);
    }

    public void listarPersonas(){
        for (Usuario c:listaUsuarios) {
            System.out.println(c.toString());
        }
    }
}
