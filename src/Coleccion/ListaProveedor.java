package Coleccion;

import models.Cuenta;
import models.Proveedor;

import java.io.Serializable;
import java.util.HashMap;

public class ListaProveedor implements Serializable {
    private HashMap<Integer, Proveedor> listaProveedores;

    public ListaProveedor(HashMap<Integer, Proveedor> listaProveedores) {
        this.listaProveedores = new HashMap<>();
    }

}
