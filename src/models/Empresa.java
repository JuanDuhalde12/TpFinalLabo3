package models;

import Archivos.Controlador;
import Coleccion.*;
import Exceptions.LoginException;

import java.util.*;

public class Empresa {
    private static int id = 0;
    private int idUsuario,idCliente,idServicio,idCatDesc,idProveedor;
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
        getUltimosIds();
    }

    public Empresa() {
        id ++;
    }

    public void getUltimosIds(){
        this.idCatDesc = categoriaDesc.ultimoId();
        this.idUsuario = usuarios.ultimoId();
        this.idCliente = clientes.ultimoId();
        this.idProveedor = proveedores.ultimoId();
        this.idServicio = servicios.ultimoId();
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
        controladorArchivos.actualizarArchivoProveedores(this.proveedores);
        controladorArchivos.actualizarArchivoCategoriaDesc(this.categoriaDesc);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public int getIdCatDesc() {
        return idCatDesc;
    }

    public int getIdProveedor() {
        return idProveedor;
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

    public Usuario buscarUsuarioPorNombre(String nombre){
        ArrayList<Usuario> lista = usuarios.getLista();
        Usuario buscado = null;
        for (Usuario u:lista) {
            if(u.getNombre().equals(nombre)){
                buscado = u;
            }
        }
        return buscado;
    }
    public Usuario buscarUsuarioXDni(String dni){
        ArrayList<Usuario> lista = usuarios.getLista();
        Usuario buscado = null;
        for (Usuario u:lista) {
            if(u.getDni().equals(dni)){
                buscado = u;
            }
        }
        return buscado;
    }

    public Usuario buscarUsuario(String nombreUsuario){
        ArrayList<Usuario> lista = usuarios.getLista();
        Usuario buscado = null;
        for (Usuario u:lista) {
            if(u.getNombre().equals(nombreUsuario)){
                buscado = u;
            }
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
    public Cliente buscarClienteXNombre(String nombre){
        ArrayList<Cliente> lista = clientes.getLista();
        Cliente buscado = null;
        if(!nombre.isEmpty()){
            for(Cliente c:lista){
                if (c.getNombreCompleto().equals(nombre)) {
                    buscado = c;
                }
            }
        }
        return buscado;
    }

    public Cliente buscarClienteXTelefono(String telefono){
        ArrayList<Cliente> lista = clientes.getLista();
        Cliente buscado = null;
        if(!telefono.isEmpty()){
            for(Cliente c:lista){
                if (c.getNombreCompleto().equals(telefono)) {
                    buscado = c;
                }
            }
        }
        return buscado;
    }

    public void agregarCliente(Cliente cliente){
        this.clientes.agregar(cliente);
    }

    public void agregarServicio(Servicio servicio){
        this.servicios.agregar(servicio);
    }
    public void agregarCategoriaDesc(CategoriaDescuento catDesc){
        this.categoriaDesc.agregar(catDesc);
    }
    public void agregarProveedor(Proveedor proveedor){
        this.proveedores.agregar(proveedor);
    }

    public void agregarUsuario(Usuario usuario){
        this.usuarios.agregar(usuario);
    }

    public void listarClientes(){
        for (Cliente c:this.clientes.getLista()){
            if(c.getIsActive()){
                clientes.imprimir(c);
            }
        }
    }
    public void listarServicios(){
        for (Servicio s:this.servicios.getLista()){
            if(s.getIsActive()){
                servicios.imprimir(s);
            }
        }
    }
    public void listarUsuarios(){
        for (Usuario u:this.usuarios.getLista()){
            if(u.getIsActive()){
                usuarios.imprimir(u);
            }
        }
    }

    public void listarCategoriasDesc(){
        for (CategoriaDescuento c:this.categoriaDesc.getLista()){
            categoriaDesc.imprimir(c);
        }

    }

    public void listarProveedores(){
        proveedores.listar();
    }



    public Servicio buscarServicio(String nombreServicio){
        Servicio buscado = null;
        for (Servicio s:servicios.getLista()) {
            if(s.getNombreServicio().equals(nombreServicio)){
                return s;
            }
        }
        return buscado;
    }

    public CategoriaDescuento buscarCatDesc(String nombreCatDesc){
        CategoriaDescuento buscado = null;
        for (CategoriaDescuento cd:categoriaDesc.getLista()) {
            if(cd.getNombre().equals(nombreCatDesc)){
                buscado = cd;
            }
        }
        return buscado;
    }

    public Proveedor buscarProveedor(String nombre){
        Proveedor buscado = null;
        Iterator<Map.Entry<Integer, Proveedor>> it = proveedores.getLista().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Proveedor> mapa = (Map.Entry<Integer, Proveedor>) it.next();
            if(mapa.getValue().getNombre().equals(nombre)){
                buscado = mapa.getValue();
            }
        }
        return buscado;
    }




    public void eliminarProveedor(Proveedor nombre){
        proveedores.eliminar(nombre);
    }

    public void eliminarUsuario (Usuario nombre){
        usuarios.eliminar(nombre);
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
}
