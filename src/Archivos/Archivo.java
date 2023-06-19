package Archivos;

import models.CategoriaDescuento;

import java.util.ArrayList;

public abstract class Archivo<T> {
    public abstract void crearArchivo(ArrayList<T> lista);

    public abstract void crearArchivo(ArrayList<T> listaCategoriasDesc);

    public abstract ArrayList<T> leerArchivo();
}
