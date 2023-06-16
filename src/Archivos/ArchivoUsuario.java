package Archivos;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.*;

public class ArchivoUsuario implements Serializable{
    private Gson gson;
    private File file;

    public ArchivoUsuario(){
        gson = new Gson();
        file = new File("Archivos/usuarios.json");
    }

    public void crearArchivoJson(ArrayList<Usuario> listaUsuarios){
        FileWriter writer = null;
        if(!listaUsuarios.isEmpty()) {
            try {
                writer = new FileWriter(file);
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

    public ArrayList<Usuario> leerArchivo(){
        FileReader reader = null;
        ArrayList<Usuario> lista = null;
        if(file.exists()){
            try{
                reader = new FileReader(file);
                Type clienteListType = new TypeToken<ArrayList<Usuario>>() {}.getType();
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
            System.out.println("El archivo usuarios.json no existe");
        }
        return lista;
    }
}
