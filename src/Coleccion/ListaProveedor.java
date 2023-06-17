package Coleccion;

import Interfaz.IultimoId;
import models.Cuenta;
import models.Proveedor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ListaProveedor implements IultimoId {
    private HashMap<Integer, Proveedor> listaProveedores;

    public ListaProveedor() {
        this.listaProveedores = new HashMap<Integer,Proveedor>();
    }

    public HashMap<Integer, Proveedor> getLista() {
        return listaProveedores;
    }

    public void setLista(HashMap<Integer, Proveedor> lista) {
        this.listaProveedores = lista;
    }

    public void agregar(Proveedor proveedor) {
        this.listaProveedores.put(proveedor.getId(), proveedor);
    }

    public void eliminar(Proveedor proveedor) {
        this.listaProveedores.remove(proveedor.getId());
    }

    @Override
    public int ultimoId() {
        int id = 0;
        Iterator<Map.Entry<Integer, Proveedor>> it = listaProveedores.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Proveedor> mapa = (Map.Entry<Integer, Proveedor>) it.next();
            if(id < mapa.getValue().getId()){
                id=mapa.getValue().getId()+1;
            }
        }
        return id;
    }

    public void listar() {
        for (Map.Entry<Integer, Proveedor> entry : listaProveedores.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}