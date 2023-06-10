package Archivos;

import Coleccion.Coleccion;
import models.Cliente;
import models.Servicio;
import models.Usuario;

import java.util.ArrayList;

public class Controlador {
    private ArchivoServicio servicios;
    private ArchivoCliente clientes;
    private ArchivoUsuario usuarios;

    public Controlador() {
        this.servicios = new ArchivoServicio();
        this.clientes = new ArchivoCliente();
        this.usuarios = new ArchivoUsuario();
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
}
