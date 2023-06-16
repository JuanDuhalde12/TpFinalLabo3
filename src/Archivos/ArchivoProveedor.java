package Archivos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Cuenta;
import models.Proveedor;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class ArchivoProveedor implements Serializable {
    private Gson gson;
    private File file;

    public ArchivoProveedor(){
        gson = new Gson();
        file = new File("Archivos/proveedores.json");
    }

    public void crearArchivo(HashMap<Integer, Proveedor> listaProveedores) {
        FileWriter writer = null;
        if(!listaProveedores.isEmpty()){
            try {
                writer = new FileWriter(file);
                gson.toJson(listaProveedores, writer);
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

    public HashMap<Integer, Proveedor> leerArchivo(){
        FileReader reader = null;
        HashMap<Integer, Proveedor> listaProveedores = null;
        if(file.exists()){
            try{
                reader = new FileReader(file);
                Type proveedorListType = new TypeToken<HashMap<Integer, Proveedor>>() {}.getType();
                listaProveedores = gson.fromJson(reader, proveedorListType);
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
            System.out.println("El archivo Proveedores.json no existe");
        }
        return listaProveedores;
    }

}
