package Archivos;

import java.util.ArrayList;

public abstract class ArchivoArray<T> {

    public abstract void crearArchivo(ArrayList<T> lista);

    public abstract ArrayList<T> leerArchivo();
}
