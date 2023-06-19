package Archivos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Cliente;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ArchivoCliente extends ArchivoArray<Cliente> implements Serializable {
    private Gson gson;
    private File file;

    public ArchivoCliente(){
        gson = new Gson();
        file = new File("Archivos/clientes.json");
    }

    @Override
    public void crearArchivo(ArrayList<Cliente> listaClientes) {
        FileWriter writer = null;
        if(!listaClientes.isEmpty()){
                try {
                    writer = new FileWriter(file);
                    gson.toJson(listaClientes, writer);
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

    @Override
    public ArrayList<Cliente> leerArchivo(){
        FileReader reader = null;
        ArrayList<Cliente> listaClientes = null;
        if(file.exists()){
            try{
                reader = new FileReader(file);
                Type clienteListType = new TypeToken<ArrayList<Cliente>>() {}.getType();
                listaClientes = gson.fromJson(reader, clienteListType);
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
            System.out.println("El archivo Cliente.json no existe");
        }
        return listaClientes;
    }

}
