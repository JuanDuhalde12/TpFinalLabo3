package Coleccion;

import Interfaz.IultimoId;
import models.CategoriaDescuento;
import models.Cliente;
import models.Servicio;
import models.Usuario;

import java.io.Serializable;
import java.util.ArrayList;

public class Coleccion <T> implements Serializable, IultimoId {
    private ArrayList<T> lista;

    public Coleccion() {
        this.lista = new ArrayList<T>();
    }

    public ArrayList<T> getLista() {
        return lista;
    }

    public void setLista(ArrayList<T> lista) {
        this.lista = lista;
    }

    public void agregar(T t){
        this.lista.add(t);
    }

    public void eliminar(T t){
        this.lista.remove(t);
    }

    public void imprimir(T t){
        System.out.println(t.toString());
    }

    @Override
    public int ultimoId() {
        return this.lista.size();
    }
}
