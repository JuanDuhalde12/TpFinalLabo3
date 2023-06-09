package menu;

import Exceptions.DniExiste;
import Exceptions.LoginException;
import Exceptions.UsuarioExiste;
import Exceptions.ValorNoValido;
import com.sun.media.jfxmediaimpl.HostUtils;
import models.*;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private Scanner scan;
    private Empresa empresa;
    private Console consola;
    private Usuario usuario;

    public Menu(){
        this.consola = System.console();
        scan = new Scanner(System.in);
        this.empresa = new Empresa("451-0111","empresa@seguridad.com","lala 123","20335558796");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void menuInicio(){
        int opcion;
        do {
            System.out.println("");
            System.out.println("Bienvenido al sistema");
            System.out.println("1. Log In");
            System.out.println("2. Salir");
            opcion = checkInput();
            scan.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Usuario: ");
                    String usuario = scan.nextLine();
                    System.out.println("Contraseña: ");
                    String contraseña = scan.nextLine();
                    try{
                        this.usuario = empresa.buscarUsuario(usuario,contraseña);
                        if(usuario != null){
                            if(this.usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){
                                menuAdmin();
                            }else{
                                menuUser();
                            }
                        }
                    }catch(LoginException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Cerrando sistema....");
                    System.out.println("Actualizando archivos...");
                    empresa.actualizarArchivos();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comando Invalido");
                    break;
            }
        }while(opcion!=2);
    }

    public void menuAdmin(){
        int opcion;
        do {
            System.out.println("");
            System.out.println("Bienvenido al sistema");
            System.out.println("1. Clientes");
            System.out.println("2. Servicios");
            System.out.println("3. Categoria Descuento");
            System.out.println("4. Proveedores");
            System.out.println("5. Usuarios");
            System.out.println("9. Volver");
            opcion = checkInput();
            scan.nextLine();

            switch (opcion){
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuServicios();
                    break;
                case 3:
                    menuCategoriaDesc();
                    break;
                case 4:
                    menuProveedores();
                    break;
                case 5:
                    menuUsuarios();
                    break;
                case 9:
                    empresa.actualizarArchivos();
                    menuInicio();
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);

    }

    public void menuUser(){
        int opcion,p;
        do {
            System.out.println("");
            System.out.println("Bienvenido al sistema");
            System.out.println("1. Clientes");
            System.out.println("2. Servicios");
            System.out.println("3. Categoria Descuento");
            System.out.println("4. Proveedores");
            System.out.println("9. Volver");
            opcion = checkInput();
            scan.nextLine();

            switch(opcion){
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuServicios();
                    break;
                case 3:
                    menuCategoriaDesc();
                    break;
                case 4:
                    menuProveedores();
                    break;
                case 9:
                    empresa.actualizarArchivos();
                    menuInicio();
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);
    }

    //region menuClientes
    public void menuClientes(){
        int opcion, p, q;
        do {
            if(this.usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){
                System.out.println("");
                System.out.println("Menu Cliente");
                System.out.println("1. Buscar");
                System.out.println("2. Modificar/Cuentas");
                System.out.println("3. Crear");
                System.out.println("4. Listar Clientes");
                System.out.println("5. Dar de baja");
                System.out.println("9. Volver");
                opcion = checkInput();
                scan.nextLine();
            }else{
                System.out.println("");
                System.out.println("Menu Cliente");
                System.out.println("1. Buscar");
                System.out.println("2. Modificar/Cuentas");
                System.out.println("3. Crear");
                System.out.println("4. Listar Clientes");
                System.out.println("9. Volver");
                opcion = checkInput();
                scan.nextLine();
            }
            switch (opcion){
                case 1:
                    buscarCliente();
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("CLientes Activos: ");
                    empresa.listarClientes();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("CLientes NO Activos: ");
                    empresa.listarClientesInactivos();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Ingrese Dni cliente a modificar");
                        String dni = scan.nextLine();
                        Cliente buscado = empresa.buscarClienteXDni(dni);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                            if(buscado.getIsActive()){
                                modificarCliente(buscado);
                            }else{
                                System.out.println("Desea volver a activar al usuario? 1:SI 2:NO" );
                                p = checkInput();
                                scan.nextLine();
                                if(p == 1){
                                    buscado.setActive();
                                }
                            }
                        }else{
                            System.out.println("El cliente no existe");
                        }
                        System.out.println("Presione 0 para volver");
                        p = scan.nextInt();
                        scan.nextLine();
                    }while(p!=0);
                    break;
                case 3:
                    try{
                        crearCliente();
                        System.out.println("Cliente agregado");
                    }
                    catch (DniExiste e){
                        System.out.println(e.getMessage());
                        menuClientes();
                    }
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    empresa.listarClientes();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Presione 1 para volver");
                        q = checkInput();
                        scan.nextLine();
                    }while (q!=1);
                    break;
                case 5:
                    do{
                        System.out.println("");
                        System.out.println("Ingrese Dni cliente a dar de baja");
                        String dni = scan.nextLine();
                        Cliente buscado = empresa.buscarClienteXDni(dni);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                            buscado.setNotActive();
                            System.out.println("Cliente dado de baja");
                        }else{
                            System.out.println("El cliente no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 9:
                    empresa.actualizarArchivos();
                    if(usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){
                        menuAdmin();
                    }else {
                        menuUser();
                    }
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);

    }

    public void buscarCliente(){
        int opcion, p;
        do {
            System.out.println("");
            System.out.println("Por que dato desea buscar?");
            System.out.println("1. Nombre");
            System.out.println("2. DNI");
            System.out.println("3. Domicilio");
            System.out.println("4. Telefono");
            System.out.println("9. Volver");
            opcion = checkInput();
            scan.nextLine();

            switch (opcion){
                case 1:
                    do{
                        System.out.println("");
                        System.out.println("Ingrese Nombre completo de cliente a buscar");
                        String nombre = scan.nextLine();
                        Cliente buscado = empresa.buscarClienteXNombre(nombre);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                        }else{
                            System.out.println("El cliente no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 2:
                    do{
                        System.out.println("");
                        System.out.println("Ingrese dni cliente a buscar");
                        String dni = scan.nextLine();
                        Cliente buscado = empresa.buscarClienteXDni(dni);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                        }else{
                            System.out.println("El cliente no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 3:
                    do{
                        System.out.println("");
                        System.out.println("Ingrese domicilio de cliente a buscar");
                        String domicilio = scan.nextLine();
                        Cliente buscado = empresa.buscarClienteXDomicilio(domicilio);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                        }else{
                            System.out.println("El cliente no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 4:
                    do{
                        System.out.println("");
                        System.out.println("Ingrese Telefono de cliente a buscar");
                        String telefono = scan.nextLine();
                        Cliente buscado = empresa.buscarClienteXTelefono(telefono);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                        }else{
                            System.out.println("El cliente no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 9:
                    menuClientes();
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;

            }
        }while(opcion!=9);
    }

    public void crearCliente()throws DniExiste{
        int opcion;
        empresa.getUltimosIds();
        Cliente cliente = new Cliente(empresa.getIdCliente());
        do{
            System.out.println("");
            System.out.println("Creacion cliente");
            System.out.println("Ingrese DNI:");
            String dni = scan.nextLine();
            cliente.setDni(dni);
            Cliente buscado = empresa.buscarClienteXDni(dni);
            if(buscado!=null){
                throw new DniExiste("El DNI ya existe");
            }
            System.out.println("Ingrese Nombre Completo:");
            String nombre = scan.nextLine();
            cliente.setNombreCompleto(nombre);
            System.out.println("Ingrese Domicilio:");
            String domicilio = scan.nextLine();
            cliente.setDomicilio(domicilio);
            System.out.println("Ingrese Ocupacion:");
            String ocupacion = scan.nextLine();
            cliente.setOcupacion(ocupacion);
            String emailValido="";
            do{
                try{
                    System.out.println("Ingrese Email: ");
                    String email = scan.nextLine();
                    emailValido = chequearMailValido(email);
                    cliente.setEmail(emailValido);
                }catch(ValorNoValido e){
                    System.out.println("Ingrese Mail valido");
                }
            }while(emailValido.isEmpty());
            System.out.println("Ingrese Telefono: ");
            String tel = scan.nextLine();
            cliente.setTelefono(tel);
            System.out.println("Cliente creado: ");
            System.out.println(cliente.toString());
            System.out.println("Presione 1 para aceptar");
            opcion = checkInput();
            scan.nextLine();
        }while(opcion!=1);
        empresa.agregarCliente(cliente);
    }

    public void modificarCliente(Cliente buscado){
        int opcion, p;
        do {
            System.out.println("");
            System.out.println("Que desea hacer?");
            System.out.println("1. Modificar Nombre");
            System.out.println("2. Modificar DNI");
            System.out.println("3. Modificar Domicilio");
            System.out.println("4. Modificar Ocupacion");
            System.out.println("5. Agregar Cuenta");
            System.out.println("6. Listar Cuentas");
            System.out.println("7. Dar de baja Cuenta");
            System.out.println("8. Modificar Cuenta");
            System.out.println("9. Volver");
            opcion = checkInput();
            scan.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("");
                    System.out.println("Nombre actual: "+ buscado.getNombreCompleto());
                    System.out.println("Ingrese nuevo nombre:");
                    String nuevoNombre = scan.nextLine();
                    buscado.setNombreCompleto(nuevoNombre);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("DNI actual: "+ buscado.getDni());
                    System.out.println("Ingrese nuevo DNI:");
                    String nuevoDni = scan.nextLine();
                    buscado.setDni(nuevoDni);
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Domicilio actual: "+ buscado.getDomicilio());
                    System.out.println("Ingrese nuevo Domicilio:");
                    String nuevoDomicilio = scan.nextLine();
                    buscado.setDomicilio(nuevoDomicilio);
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Ocupacion actual: "+ buscado.getOcupacion());
                    System.out.println("Ingrese nueva Ocupacion:");
                    String nuevoOcupacion = scan.nextLine();
                    buscado.setOcupacion(nuevoOcupacion);
                    break;
                case 5:
                    crearCuenta(buscado);
                    break;
                case 6:
                    buscado.listarCuentas();
                    break;
                case 7:
                    do{
                        System.out.println("");
                        System.out.println("Ingrese Nro de cuenta a dar de baja");
                        String nroCuenta = scan.nextLine();
                        Cuenta cuenta = buscado.buscarCuentaXNro(nroCuenta);
                        if(cuenta!=null){
                            System.out.println(cuenta.toString());
                            cuenta.setNotActive();
                        }else{
                            System.out.println("La cuenta no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 8:
                    System.out.println("");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Cuentas Activas");
                    buscado.listarCuentas();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Cuentas NO Activas");
                    buscado.listarCuentasInactivas();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Ingrese Nro de cuenta a modificar");
                        String nro = scan.nextLine();
                        Cuenta cuenta = buscado.buscarCuentaXNro(nro);
                        if(cuenta!=null){
                            System.out.println(cuenta.toString());
                            if(buscado.getIsActive()){
                                modificarCuenta(cuenta,buscado);
                            }else{
                                System.out.println("Desea volver a activar al usuario? 1:SI 2:NO" );
                                p = checkInput();
                                scan.nextLine();
                                if(p == 1){
                                    cuenta.setActive();
                                }
                            }
                        }else{
                            System.out.println("La cuenta no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 9:
                    empresa.actualizarArchivos();
                    menuClientes();
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);
    }

    public void crearCuenta(Cliente c){
        int opcion;
        Cuenta nuevaCuenta = new Cuenta(c.getId(),c.getUltimoIdCuenta());
        do{
            System.out.println("");
            System.out.println("Cuentas de "+ c.getNombreCompleto());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            c.listarCuentas();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Ingrese domicilio de la cuenta: ");
            String domicilio = scan.nextLine();
            System.out.println("Ingrese Fecha Alta (aaaa-MM-dd) ejemplo "+ LocalDate.now());
            String fechaAlta = scan.nextLine();
            LocalDate date = LocalDate.parse(fechaAlta);
            LocalDate fechaAumento = date;
            System.out.println("Servicios: ");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            empresa.listarServicios();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            Servicio servicio = null;
            Proveedor proveedor = null;
            do{
                System.out.println("Ingreser nombre servicio a agregar: ");
                String nombreServicio = scan.nextLine();
                servicio = empresa.buscarServicio(nombreServicio);
                if(servicio.getNombreServicio().equals("Monitoreo")){
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    empresa.listarProveedores();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Ingreser nombre proveedor: ");
                        String nombreProveedor = scan.nextLine();
                        proveedor = empresa.buscarProveedor(nombreProveedor);
                        nuevaCuenta.setProveedor(proveedor.getNombre());
                    }while(proveedor==null);
                }
            }while(servicio==null);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            empresa.listarCategoriasDesc();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            CategoriaDescuento categoriaDescuento = null;
            do{
                System.out.println("Ingreser categoria de descuento: ");
                String nombreCatDesc = scan.nextLine();
                categoriaDescuento = empresa.buscarCatDesc(nombreCatDesc);
            }while(categoriaDescuento==null);
            System.out.println("Ingrese clave operador: ");
            String claveOperador = scan.nextLine();
            nuevaCuenta.setClaveOperador(claveOperador);
            nuevaCuenta.setDomicilioServicio(domicilio);
            nuevaCuenta.setFechaAlta(fechaAlta);
            nuevaCuenta.setFechaAumento(fechaAumento.toString());
            nuevaCuenta.setServicio(servicio);
            nuevaCuenta.setCategoria(categoriaDescuento);
            System.out.println("Cuenta creada: ");
            System.out.println(nuevaCuenta.toString());
            System.out.println("Presione 1 para aceptar");
            opcion = checkInput();
            scan.nextLine();
        }while(opcion!=1);
        c.agregarCuenta(nuevaCuenta);
    }


    public void modificarCuenta(Cuenta buscada, Cliente buscado){
        int opcion, p;
        do {
            System.out.println("");
            System.out.println("Que desea modificar?");
            System.out.println("1. Modificar Nro Cuenta");
            System.out.println("2. Modificar Domicilio del servicio");
            System.out.println("3. Modificar Fecha de alta");
            System.out.println("4. Modificar Fecha de aumento");
            System.out.println("5. Cambiar Categoria de Descuento");
            System.out.println("6. Modificar Clave de Operador");
            System.out.println("7. Cambiar de Proveedor");
            System.out.println("9. Volver");
            opcion = checkInput();
            scan.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("");
                    System.out.println("Nro de cuenta actual: "+ buscada.getNroCuenta());
                    System.out.println("Ingrese nuevo Nro de cuenta:");
                    String nroCuenta = scan.nextLine();
                    buscada.setNroCuenta(nroCuenta);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Domicilio actual: "+ buscada.getDomicilioServicio());
                    System.out.println("Ingrese nuevo Domicilio:");
                    String domicilio = scan.nextLine();
                    buscada.setDomicilioServicio(domicilio);
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Fecha de alta actual: "+ buscada.getFechaAlta());
                    System.out.println("Ingrese Fecha Alta nueva (aaaa-MM-dd) ejemplo "+ LocalDate.now());
                    String fechaAlta = scan.nextLine();
                    LocalDate date = LocalDate.parse(fechaAlta);
                    buscada.setFechaAlta(fechaAlta);
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Fecha de ultimo aumento actual: "+ buscada.getFechaAumento());
                    System.out.println("Ingrese Fecha de Nuevo aumento (aaaa-MM-dd) ejemplo "+ LocalDate.now());
                    String fechaAumento = scan.nextLine();
                    LocalDate nuevo = LocalDate.parse(fechaAumento);
                    buscada.setFechaAumento(fechaAumento);
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    empresa.listarCategoriasDesc();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    CategoriaDescuento categoriaDescuento = null;
                    do{
                        System.out.println("Ingreser categoria de descuento: ");
                        String nombreCatDesc = scan.nextLine();
                        categoriaDescuento = empresa.buscarCatDesc(nombreCatDesc);
                    }while(categoriaDescuento==null);
                    buscada.setCategoria(categoriaDescuento);
                    break;
                case 6:
                    System.out.println("");
                    System.out.println("Clave de operador actual: "+ buscada.getClaveOperador());
                    System.out.println("Ingrese nueva Clave de operador:");
                    String clave = scan.nextLine();
                    buscada.setClaveOperador(clave);
                    break;
                case 7:
                    Proveedor proveedor = null;
                    Servicio servicio = null;
                    if(servicio.getNombreServicio().equals("Monitoreo")){
                        System.out.println("");
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                        empresa.listarProveedores();
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                        do{
                            System.out.println("Ingreser nombre proveedor: ");
                            String nombreProveedor = scan.nextLine();
                            proveedor = empresa.buscarProveedor(nombreProveedor);
                            buscada.setProveedor(nombreProveedor);
                        }while(proveedor==null);
                    }else{
                        System.out.println("Esta Cuenta no tiene monitoreo");
                    }
                    break;
                case 9:
                    modificarCliente(buscado);
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);
    }
    //endregion

    //region menuServicios
    public void menuServicios() {
        int opcion, p;
        do {
            if (this.usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
                System.out.println("");
                System.out.println("Menu Servicio");
                System.out.println("1. Listar Servicios");
                System.out.println("2. Modificar");
                System.out.println("3. Crear");
                System.out.println("4. Dar de baja");
                System.out.println("9. Volver");
                opcion = checkInput();
                scan.nextLine();
            } else {
                System.out.println("");
                System.out.println("Menu Servicios");
                System.out.println("1. Listar Servicios");
                System.out.println("2. Modificar");
                System.out.println("3. Crear");
                System.out.println("9. Volver");
                opcion = checkInput();
                scan.nextLine();
            }
            switch (opcion){
                case 1:
                    do{
                        empresa.listarServicios();
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Servicios Activos: ");
                    empresa.listarServicios();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Servicios NO Activos: ");
                    empresa.listarServiciosInactivos();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Ingrese Nombre de Servicio a Modificar: ");
                        String nombre = scan.nextLine();
                        Servicio buscado = empresa.buscarServicio(nombre);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                            if(buscado.getIsActive()){
                                modificarServicio(buscado);
                            }else{
                                System.out.println("Desea volver a activar al servicio? 1:SI 2:NO" );
                                p = checkInput();
                                scan.nextLine();
                                if(p == 1){
                                    buscado.setActive();
                                }
                            }
                        }else{
                            System.out.println("El servicio no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 3:
                    crearServicio();
                    System.out.println("Servicio agregado");
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    empresa.listarServicios();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Ingrese Nombre de Servicio a dar de baja");
                        String nombreServicio = scan.nextLine();
                        Servicio buscado = empresa.buscarServicio(nombreServicio);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                            buscado.setNotActive();
                            System.out.println("Servicio dado de baja");
                        }else{
                            System.out.println("El Servicio no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 9:
                    empresa.actualizarArchivos();
                    if(usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){
                        menuAdmin();
                    }else {
                        menuUser();
                    }
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);
    }

    public void modificarServicio(Servicio buscado){
        int opcion;
        do {
            System.out.println("");
            System.out.println("Que desea modificar?");
            System.out.println("1. Nombre de Servicio");
            System.out.println("2. Precio");
            System.out.println("3. Es comodato");
            System.out.println("9. Volver");
            opcion = checkInput();
            scan.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("");
                    System.out.println("Nombre actual: "+ buscado.getNombreServicio());
                    System.out.println("Ingrese nuevo nombre:");
                    String nuevoNombre = scan.nextLine();
                    buscado.setNombreServicio(nuevoNombre);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Precio actual: "+ buscado.getPrecio());
                    System.out.println("Ingrese nuevo precio:");
                    double precio = scan.nextDouble();
                    scan.nextLine();
                    buscado.setPrecio(precio);
                    break;
                case 3:
                    buscado.setComodato(true);
                    System.out.println("El servicio ahora es comodato");
                    break;
                case 9:
                    menuServicios();
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);
    }



    public void crearServicio(){
        int opcion;
        empresa.getUltimosIds();
        Servicio servicio = new Servicio(empresa.getIdServicio());
        do{
            System.out.println("");
            System.out.println("Creacion Servicio Nuevo");
            System.out.println("Ingrese Nombre De Servicio:");
            String nombre = scan.nextLine();
            servicio.setNombreServicio(nombre);
            System.out.println("Ingrese Precio del Servicio:");
            double precio = scan.nextDouble();
            servicio.setPrecio(precio);
            System.out.println("Presione 1 para aceptar");
            opcion = checkInput();
            scan.nextLine();
        }while(opcion!=1);
        empresa.agregarServicio(servicio);
    }
    //endregion

    //region menuCategoriaDesc
    public void menuCategoriaDesc() {
        int opcion, p;
        do {
            System.out.println("");
            System.out.println("Menu Categoria Descuentos");
            System.out.println("1. Listar Categoria Descuentos");
            System.out.println("2. Modificar");
            System.out.println("3. Crear");
            System.out.println("9. Volver");
            opcion = checkInput();
            scan.nextLine();
            switch (opcion){
                case 1:
                    do{
                        empresa.listarCategoriasDesc();
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    empresa.listarCategoriasDesc();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Ingrese Nombre de Categoria de descuento a Modificar: ");
                        String nombre = scan.nextLine();
                        CategoriaDescuento buscado = empresa.buscarCatDesc(nombre);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                            modificarCategoriaDesc(buscado);
                        }else{
                            System.out.println("La Categoria de Descuento no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 3:
                    crearCategoriaDesc();
                    System.out.println("Servicio agregado");
                    break;
                case 9:
                    empresa.actualizarArchivos();
                    if(usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){
                        menuAdmin();
                    }else {
                        menuUser();
                    }
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);

    }

    public void modificarCategoriaDesc(CategoriaDescuento buscado){
        int opcion;
        do {
            System.out.println("");
            System.out.println("Que desea modificar?");
            System.out.println("1. Nombre de Categoria de Descuento");
            System.out.println("2. Porcentaje de Descuento");
            System.out.println("9. Volver");
            opcion = checkInput();
            scan.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("");
                    System.out.println("Nombre actual: "+ buscado.getNombre());
                    System.out.println("Ingrese nuevo nombre:");
                    String nuevoNombre = scan.nextLine();
                    buscado.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Descuento actual: %"+ buscado.getPorcentajeDescuento());
                    System.out.println("Ingrese nuevo porcentaje de descuento:");
                    double descuento = scan.nextDouble();
                    scan.nextLine();
                    buscado.setPorcentajeDescuento(descuento);
                    break;
                case 9:
                    menuCategoriaDesc();
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);
    }

    public void crearCategoriaDesc(){
        int opcion;
        empresa.getUltimosIds();
        CategoriaDescuento descuento = new CategoriaDescuento(empresa.getIdCatDesc());
        do{
            System.out.println("");
            System.out.println("Creacion Categoria de descuento Nueva");
            System.out.println("Ingrese Nombre De la Categoria de descuento:");
            String nombre = scan.nextLine();
            descuento.setNombre(nombre);
            System.out.println("Ingrese Descuento de la Categoria de descuento:");
            double porcentaje = scan.nextDouble();
            descuento.setPorcentajeDescuento(porcentaje);
            System.out.println("Presione 1 para aceptar");
            opcion = checkInput();
            scan.nextLine();
        }while(opcion!=1);
        empresa.agregarCategoriaDesc(descuento);
    }
    //endregion

    //region menuProveedores
    public void menuProveedores() {
        int opcion, p;
        do {
            if (this.usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
                System.out.println("");
                System.out.println("Menu Proveedores");
                System.out.println("1. Listar Proveedores");
                System.out.println("2. Modificar");
                System.out.println("3. Crear");
                System.out.println("4. Eliminar");
                System.out.println("9. Volver");
                opcion = checkInput();
                scan.nextLine();
            } else {
                System.out.println("");
                System.out.println("Menu Proveedores");
                System.out.println("1. Listar Proveedores");
                System.out.println("2. Modificar");
                System.out.println("3. Crear");
                System.out.println("9. Volver");
                opcion = checkInput();
                scan.nextLine();
            }
            switch (opcion){
                case 1:
                    do{
                        System.out.println("");
                        empresa.listarProveedores();
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    empresa.listarProveedores();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Ingrese Nombre de Proveedor a Modificar: ");
                        String nombre = scan.nextLine();
                        Proveedor buscado = empresa.buscarProveedor(nombre);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                            modificarProveedor(buscado);
                        }else{
                            System.out.println("El Proveedor no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 3:
                    crearProveedor();
                    System.out.println("Proveedor agregado");
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    empresa.listarProveedores();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Ingrese Nombre de Proveedor a eliminar");
                        String nombreProveedor = scan.nextLine();
                        Proveedor buscado = empresa.buscarProveedor(nombreProveedor);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                            empresa.eliminarProveedor(buscado);
                            System.out.println("Proveedor Eliminado");
                        }else{
                            System.out.println("El Proveedor no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 9:
                    empresa.actualizarArchivos();
                    if(usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){
                        menuAdmin();
                    }else {
                        menuUser();
                    }
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);
    }

    public void modificarProveedor(Proveedor buscado){
        int opcion;
        do {
            System.out.println("");
            System.out.println("Que desea modificar?");
            System.out.println("1. Nombre de Proveedor");
            System.out.println("2. Numero de Telefono");
            System.out.println("9. Volver");
            opcion = checkInput();
            scan.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("");
                    System.out.println("Nombre actual: "+ buscado.getNombre());
                    System.out.println("Ingrese nuevo nombre:");
                    String nuevoNombre = scan.nextLine();
                    buscado.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Telefono actual: "+ buscado.getTelefono());
                    System.out.println("Ingrese nuevo Numero de telefono:");
                    String tel = scan.nextLine();
                    buscado.setTelefono(tel);
                    break;
                case 9:
                    menuProveedores();
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);
    }

    public void crearProveedor(){
        int opcion;
        empresa.getUltimosIds();
        Proveedor proveedor = new Proveedor(empresa.getIdProveedor());
        do{
            System.out.println("");
            System.out.println("Creacion Proveedor Nuevo");
            System.out.println("Ingrese Nombre De Proveedor:");
            String nombre = scan.nextLine();
            proveedor.setNombre(nombre);
            System.out.println("Ingrese Numero de Telefono del Proveedor:");
            String numero = scan.nextLine();
            proveedor.setTelefono(numero);
            System.out.println("Presione 1 para aceptar / 0 para cancelar");
            opcion = checkInput();
            scan.nextLine();
        }while(opcion!=1 && opcion!=0);
        if (opcion==1){
            empresa.agregarProveedor(proveedor);
        }else {
            menuProveedores();
        }

    }
    //endregion

    //region menuUsuarios
    public void menuUsuarios() {
        int opcion, p;
        do {
                System.out.println("");
                System.out.println("Menu Usuarios");
                System.out.println("1. Listar Usuarios");
                System.out.println("2. Modificar");
                System.out.println("3. Crear");
                System.out.println("4. Eliminar");
                System.out.println("9. Volver");
                opcion = checkInput();
                scan.nextLine();

            switch (opcion){
                case 1:
                    do{
                        System.out.println("");
                        empresa.listarUsuarios();
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Usuarios Activos: ");
                    empresa.listarUsuarios();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Usuarios NO Activos: ");
                    empresa.listarUsuariosInactivos();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Ingrese Nombre de Usuario a Modificar: ");
                        String nombre = scan.nextLine();
                        Usuario buscado = empresa.buscarUsuario(nombre);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                            if(buscado.getIsActive()){
                                modificarUsuario(buscado);
                            }else{
                                System.out.println("Desea volver a activar al usuario? 1:SI 2:NO" );
                                p = checkInput();
                                scan.nextLine();
                                if(p == 1){
                                    buscado.setActive();
                                }
                            }
                        }else{
                            System.out.println("El Usuario no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 3:
                    try{
                        crearUsuario();
                        System.out.println("Usuario agregado");
                    }
                    catch (UsuarioExiste e){
                        System.out.println(e.getMessage());
                        menuUsuarios();
                    }
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    empresa.listarUsuarios();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Ingrese Nombre de Usuario a dar de baja");
                        String nombreUsuario = scan.nextLine();
                        Usuario buscado = empresa.buscarUsuario(nombreUsuario);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                            buscado.setNotActive();
                            System.out.println("Usuario dado de baja");
                        }else{
                            System.out.println("El Usuario no existe");
                        }
                        System.out.println("Presione 1 para volver");
                        p = checkInput();
                        scan.nextLine();
                    }while(p!=1);
                    break;
                case 9:
                    empresa.actualizarArchivos();
                    if(usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){
                        menuAdmin();
                    }else {
                        menuUser();
                    }
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);

    }

    public void modificarUsuario(Usuario buscado){
        int opcion;
        do {
            System.out.println("");
            System.out.println("Que desea modificar?");
            System.out.println("1. Nombre de Usuario");
            System.out.println("2. Contraseña de Usuario");
            System.out.println("3. Cambio Tipo de Usuario");
            System.out.println("9. Volver");
            opcion = checkInput();
            scan.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("");
                    System.out.println("Nombre actual: "+ buscado.getNombre());
                    System.out.println("Ingrese nuevo nombre:");
                    String nuevoNombre = scan.nextLine();
                    buscado.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Contraseña actual: "+ buscado.getContraseña());
                    System.out.println("Ingrese nueva Contraseña:");
                    String cont = scan.nextLine();
                    buscado.setContraseña(cont);
                    break;
                case 3:
                    System.out.println("");
                    int flag = 0;
                    System.out.println("Tipo de Usuario actual: "+ buscado.getTipoUsuario());
                    buscado.mostrarElOtroTipo();
                    System.out.println("Presione 1 para confirmar el cambio");
                    flag = scan.nextInt();
                    if(flag==1){
                        buscado.cambioDeTipoDeUsuario();
                    }else{
                        System.out.println("El cambio no fue hecho");
                    }
                    break;
                case 9:
                    menuUsuarios();
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=9);
    }

    public void crearUsuario()throws UsuarioExiste {
        int opcion, opcion1;
        empresa.getUltimosIds();
        Usuario usuario = new Usuario(empresa.getIdUsuario());
        do{
            System.out.println("");
            System.out.println("Creacion Usuario Nuevo");
            System.out.println("Ingrese Nombre De Usuario:");
            String nombre = scan.nextLine();
            usuario.setNombre(nombre);
            Usuario buscado = empresa.buscarUsuario(nombre);
            if(buscado!=null){
                throw new UsuarioExiste("El Usuario ya existe");
            }
            System.out.println("Ingrese Contraseña de Usuario:");
            String contraseña = scan.nextLine();
            usuario.setContraseña(contraseña);
            System.out.println("Ingrese DNI del Usuario:");
            String dni = scan.nextLine();
            usuario.setDni(dni);
            System.out.println("Ingrese Nombre Completo del Usuario:");
            String nombreCompleto = scan.nextLine();
            usuario.setNombreCompleto(nombreCompleto);
            String emailValido="";
            do{
                try{
                    System.out.println("Ingrese Email: ");
                    String email = scan.nextLine();
                    emailValido = chequearMailValido(email);
                    usuario.setEmail(emailValido);
                }catch(ValorNoValido e){
                    System.out.println("Ingrese Mail valido");
                }
            }while(emailValido.isEmpty());
            System.out.println("Seleccione Tipo de Usuario");
            do {
                System.out.println("1. Tipo Administrador");
                System.out.println("2. Tipo Usuario");
                opcion1 = checkInput();
                scan.nextLine();

                switch (opcion1){
                    case 1:
                        usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
                        System.out.println("Presione 1 para confirmar tipo de usuario");
                        opcion1 = checkInput();
                        scan.nextLine();
                        break;
                    case 2:
                        usuario.setTipoUsuario(TipoUsuario.USUARIO);
                        System.out.println("Presione 1 para confirmar tipo de usuario");
                        opcion1 = checkInput();
                        scan.nextLine();
                        break;
                    default:
                        System.out.println("Comando no valido");
                        break;
                }
            }while(opcion1!=1);
            System.out.println("Presione 1 para confirmar creacion de usuario nuevo");
            opcion = checkInput();
            scan.nextLine();
        }while(opcion!=1);
        empresa.agregarUsuario(usuario);
    }
    //endregion

    public int checkInput(){
        try{
            int input = scan.nextInt();
            return input;
        }catch (RuntimeException e){
            System.out.println("Valor no valido");
            return 0;
        }
    }

    public String chequearMailValido(String email) throws ValorNoValido {
        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(emailPattern);
        if (email != null) {
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return email;
            }else{
                throw new ValorNoValido("Email no valido");
            }
        }
        return email;
    }
}

