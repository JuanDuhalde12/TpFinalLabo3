package Coleccion;

import models.Cuenta;
import models.Proveedor;

import java.io.Serializable;
import java.util.HashMap;

public class ListaProveedor implements Serializable {
    private HashMap<Integer, Proveedor> ListaProveedores;

    public ListaProveedor(HashMap<Integer, Proveedor> listaProveedores) {
        ListaProveedores = new HashMap<>();
    }

    public HashMap<Integer, Proveedor> getListaProveedores() {
        return ListaProveedores;
    }

    public void setListaProveedores(HashMap<Integer, Proveedor> listaProveedores) {
        ListaProveedores = listaProveedores;
    }
}
