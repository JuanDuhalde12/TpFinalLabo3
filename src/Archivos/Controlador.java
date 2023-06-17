package Archivos;

import Coleccion.*;
import models.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Controlador {
    private ArchivoServicio servicios;
    private ArchivoCliente clientes;
    private ArchivoUsuario usuarios;
    private ArchivoCategoriaDesc categoriaDesc;
    private ArchivoProveedor proveedores;

    public Controlador() {
        this.servicios = new ArchivoServicio();
        this.clientes = new ArchivoCliente();
        this.usuarios = new ArchivoUsuario();
        this.categoriaDesc = new ArchivoCategoriaDesc();
        this.proveedores = new ArchivoProveedor();
    }

    public ArrayList<Cliente> obtenerClientes(){
        ArrayList<Cliente> lista = new ArrayList<>();
        lista = clientes.leerArchivo();
        return  lista;
    }

    public ArrayList<Usuario> obtenerUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();
        lista = usuarios.leerArchivo();
        return  lista;
    }

    public ArrayList<Servicio> obtenerServicios(){
        ArrayList<Servicio> lista = new ArrayList<>();
        lista = servicios.leerArchivo();
        return  lista;
    }
    public ArrayList<CategoriaDescuento> obtenerCategoriaDesc(){
        ArrayList<CategoriaDescuento> lista = new ArrayList<>();
        lista = categoriaDesc.leerArchivo();
        return  lista;
    }
    public HashMap<Integer, Proveedor> obtenerProveedores(){
        HashMap<Integer, Proveedor> lista = new HashMap<>();
        lista = proveedores.leerArchivo();
        return  lista;
    }

    public void actualizarArchivoClientes(Coleccion<Cliente> coleccion){
        ArrayList<Cliente> lista = coleccion.getLista();
        clientes.crearArchivo(lista);
    }

    public void actualizarArchivoUsuarios(Coleccion<Usuario> coleccion){
        ArrayList<Usuario> lista = coleccion.getLista();
        usuarios.crearArchivoJson(lista);
    }

    public void actualizarArchivoServicios(Coleccion<Servicio> coleccion){
        ArrayList<Servicio> lista = coleccion.getLista();
        servicios.crearArchivo(lista);
    }
    public void actualizarArchivoCategoriaDesc(Coleccion<CategoriaDescuento> coleccion){
        ArrayList<CategoriaDescuento> lista = coleccion.getLista();
        categoriaDesc.crearArchivo(lista);
    }
    public void actualizarArchivoProveedores(ListaProveedor listaProveedor){
        HashMap<Integer, Proveedor> lista = listaProveedor.getLista();
        proveedores.crearArchivo(lista);
    }
}
