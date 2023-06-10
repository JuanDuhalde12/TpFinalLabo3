package Coleccion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Coleccion <T> implements Serializable {
    private List<T> lista;

    public Coleccion() {
        this.lista = new ArrayList<T>();
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    public void agregar(T t){
        this.lista.add(t);
    }

    public void imprimir(){
        for (T t: lista) {
            System.out.println(t.toString());
        }
    }

    public void eliminar(T t){
        this.lista.remove(t);
    }

    public void listar(){
        for (T t:this.lista) {
            System.out.println(t.toString());
        }
    }
}
