package Archivos;

import Coleccion.Coleccion;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Cliente;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.fasterxml.jackson.*;
import models.Usuario;

public class ArchivoCliente implements Serializable {
    private ArrayList<Cliente> listaClientes;
    private Gson gson;
    private File file;

    public ArchivoCliente(){
        listaClientes = new ArrayList<Cliente>();
        gson = new Gson();
        file = new File("Archivos/clientes.json");

    }

    public void agregarCliente(Cliente cliente){
        this.listaClientes.add(cliente);
    }

    public void crearArchivo() {
        FileWriter writer = null;
        if(!file.exists()) {
            try {
                writer = new FileWriter(file);
                Gson gson = new Gson();
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
                Type clienteListType = new TypeToken<ArrayList<Cliente>>() {}.getType();
                this.listaClientes = gson.fromJson(reader, clienteListType);
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

    public void listar(){
        for (Cliente c:this.listaClientes) {
            System.out.println(c.toString());
        }
    }

}
