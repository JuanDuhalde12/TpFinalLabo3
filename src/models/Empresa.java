package models;

import Archivos.Controlador;
import Coleccion.*;
import Exceptions.LoginException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa {
    private static int id = 0;
    private String telefono,email,domicilio,cuit;
    private Coleccion<Cliente> clientes = new Coleccion<Cliente>();
    private Coleccion<Usuario> usuarios = new Coleccion<Usuario>();
    private Coleccion<Servicio> servicios = new Coleccion<Servicio>();
    private Coleccion<CategoriaDescuento> categoriaDesc = new Coleccion<CategoriaDescuento>();
    private ListaProveedor proveedores = new ListaProveedor();
    private Controlador controladorArchivos;


    public Empresa(String telefono, String email, String domicilio, String cuit) {
        id ++;
        this.telefono = telefono;
        this.email = email;
        this.domicilio = domicilio;
        this.cuit = cuit;
        this.controladorArchivos = new Controlador();
        this.clientes.setLista(controladorArchivos.obtenerClientes());
        this.usuarios.setLista(controladorArchivos.obtenerUsuarios());
        this.servicios.setLista(controladorArchivos.obtenerServicios());
        this.proveedores.setLista(controladorArchivos.obtenerProveedores());
        this.categoriaDesc.setLista(controladorArchivos.obtenerCategoriaDesc());
    }

    public Empresa() {
        id ++;
    }

    public int getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes.getLista();
    }

    public void setClientes(Coleccion<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios.getLista();
    }

    public void setUsuarios(Coleccion<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios.getLista();
    }

    public void setServicios(Coleccion<Servicio> servicios) {
        this.servicios = servicios;
    }

    public void actualizarArchivos(){
        controladorArchivos.actualizarArchivoServicios(this.servicios);
        controladorArchivos.actualizarArchivoClientes(this.clientes);
        controladorArchivos.actualizarArchivoUsuarios(this.usuarios);
    }

    public Usuario buscarUsuario(String nombre , String contraseña) throws LoginException{
        ArrayList<Usuario> lista = usuarios.getLista();
        Usuario buscado = null;
        for (Usuario u:lista) {
            if(u.getNombre().equals(nombre)&&u.getContraseña().equals(contraseña)){
                buscado = u;
            }
        }
        if(buscado==null){
            throw new LoginException("Usuario o contraseña no validos");
        }
        return buscado;
    }

    public Cliente buscarClienteXDni(String dni){
        ArrayList<Cliente> lista = clientes.getLista();
        Cliente buscado = null;
        if(!dni.isEmpty()){
            for(Cliente c:lista){
                if (c.getDni().equals(dni)) {
                    buscado = c;
                }
            }
        }
        return buscado;
    }

    public Cliente buscarClienteXDomicilio(String domicilio){
        ArrayList<Cliente> lista = clientes.getLista();
        Cliente buscado = null;
        if(!domicilio.isEmpty()){
            for(Cliente c:lista){
                if (c.getDomicilio().equals(domicilio)) {
                    buscado = c;
                }
            }
        }
        return buscado;
    }
    public Cliente buscarClienteXNombre(String Nombre){
        ArrayList<Cliente> lista = clientes.getLista();
        Cliente buscado = null;
        if(!domicilio.isEmpty()){
            for(Cliente c:lista){
                if (c.getDomicilio().equals(domicilio)) {
                    buscado = c;
                }
            }
        }
        return buscado;
    }

    public void agregarCliente(Cliente cliente){
        this.clientes.agregar(cliente);
    }

    public void listarClientes(){
        clientes.listar();
    }

    public void listarServicios(){
        servicios.listar();
    }

    public void listarUsuarios(){
        usuarios.listar();
    }

    public Servicio buscarServicio(String nombreServicio){
        Servicio buscado = null;
        for (Servicio s:servicios.getLista()) {
            if(s.getNombreServicio().equals(nombreServicio)){
                buscado = s;
            }
        }
        return buscado;
    }

    @Override
    public String toString() {
        return "Empresa{ id= " + id +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", cuit='" + cuit + '\'' +
                '}';
    }

    public int ultimoIdClientes(){
        int id = 0;
        if(!clientes.getLista().isEmpty()){
            for (Cliente cliente : clientes.getLista()){
                if(id<cliente.getId()){
                    id=cliente.getId();
                }
            }
        }
        return id;
    }

    public int ultimoIdServicios(){
        int id = 0;
        if(!servicios.getLista().isEmpty()){
            for (Servicio servicio : servicios.getLista()){
                if(id<servicio.getId()){
                    id=servicio.getId();
                }
            }
        }
        return id;
    }

    public Integer ultimoIdProveedores(){
        Integer id = 0;
        if(!proveedores.getLista().isEmpty()){
            for (Map.Entry<Integer, Proveedor> entry : proveedores.getLista().entrySet()) {
                if(id<entry.getKey()){
                    id=entry.getKey();
                }
            }
        }
        return id;
    }
}
