package Archivos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.CategoriaDescuento;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ArchivoCategoriaDesc extends ArchivoArray<CategoriaDescuento> implements Serializable {
    private Gson gson;
    private File file;

    public ArchivoCategoriaDesc(){
        gson = new Gson();
        file = new File("Archivos/categoriadesc.json");
    }
    @Override
    public void crearArchivo(ArrayList<CategoriaDescuento> listaCategoriasDesc) {
        FileWriter writer = null;
        if(!listaCategoriasDesc.isEmpty()){
            try {
                writer = new FileWriter(file);
                gson.toJson(listaCategoriasDesc, writer);
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
    public ArrayList<CategoriaDescuento> leerArchivo(){
        FileReader reader = null;
        ArrayList<CategoriaDescuento> listaCategoriaDesc = null;
        if(file.exists()){
            try{
                reader = new FileReader(file);
                Type categoriaDescListType = new TypeToken<ArrayList<CategoriaDescuento>>() {}.getType();
                listaCategoriaDesc = gson.fromJson(reader, categoriaDescListType);
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
            System.out.println("El archivo categoriadesc.json no existe");
        }
        return listaCategoriaDesc;
    }

}
