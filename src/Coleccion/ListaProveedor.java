package Coleccion;

import models.Cuenta;
import models.Proveedor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListaProveedor {
    private HashMap<Integer, Proveedor> listaProveedores;

    public ListaProveedor() {
        this.listaProveedores = new HashMap<>();
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

    public void listar() {
        for (Map.Entry<Integer, Proveedor> entry : listaProveedores.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}