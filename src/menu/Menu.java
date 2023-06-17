package menu;

import Exceptions.LoginException;
import models.*;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
            System.out.println("Bienvenido al sistema");
            System.out.println("1. Log In");
            System.out.println("0. Salir");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion){
                case 0:
                    System.out.println("Cerrando sistema....");
                    System.out.println("Actualizando archivos...");
                    empresa.actualizarArchivos();
                    System.exit(0);
                    break;
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
                default:
                    System.out.println("Comando Invalido");
                    break;
            }
        }while(opcion!=0);
    }

    public void menuAdmin(){
        int opcion;
        do {
            System.out.println("Bienvenido al sistema");
            System.out.println("1. Cliente");
            System.out.println("2. Servicios");
            System.out.println("3. Categoria Descuento");
            System.out.println("4. Proveedores");
            System.out.println("5. Usuario");
            System.out.println("0. Volver");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion){
                case 0:
                    menuInicio();
                    break;
                case 1:
                    menuClientes();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=0);

    }

    public void menuUser(){
        int opcion,p;
        do {
            System.out.println("Bienvenido al sistema");
            System.out.println("1. Cliente");
            System.out.println("2. Servicios");
            System.out.println("3. Categoria Descuento");
            System.out.println("4. Proveedores");
            System.out.println("0. Volver");
            opcion = scan.nextInt();
            scan.nextLine();

            switch(opcion){
                case 0:
                    menuInicio();
                    break;
                case 1:
                    menuClientes();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;

            }
        }while(opcion!=0);
    }

    public void menuClientes(){
        int opcion,p;
        do {
            if(this.usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){
                System.out.println("Menu Cliente");
                System.out.println("1. Buscar");
                System.out.println("2. Modificar");
                System.out.println("3. Crear");
                System.out.println("4. Eliminar");
                System.out.println("0. Volver");
                opcion = scan.nextInt();
                scan.nextLine();
            }else{
                System.out.println("Bienvenido al sistema");
                System.out.println("1. Buscar");
                System.out.println("2. Modificar");
                System.out.println("3. Crear");
                System.out.println("0. Volver");
                opcion = scan.nextInt();
                scan.nextLine();
            }


            switch (opcion){
                case 0:
                    menuInicio();
                    break;
                case 1:
                    do{
                        System.out.println("Ingrese dni cliente a buscar");
                        String dni = scan.nextLine();
                        Cliente buscado = empresa.buscarClienteXDni(dni);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                        }else{
                            System.out.println("El cliente no existe");
                        }
                        System.out.println("Presione 0 para volver");
                        p = scan.nextInt();
                        scan.nextLine();
                    }while(p!=0);
                    break;
                case 2:
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    empresa.listarClientes();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    do{
                        System.out.println("Ingrese Dni cliente a modificar");
                        String dni = scan.nextLine();
                        Cliente buscado = empresa.buscarClienteXDni(dni);
                        if(buscado!=null){
                            System.out.println(buscado.toString());
                            modificarCliente(buscado);
                        }else{
                            System.out.println("El cliente no existe");
                        }
                        System.out.println("Presione 0 para volver");
                        p = scan.nextInt();
                        scan.nextLine();
                    }while(p!=0);
                    break;
                case 3:
                    crearCliente();
                    System.out.println("Cliente agregado");
                    break;
                case 4:
                    //Completar eliminar cliente
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=0);

    }

    public void crearCliente(){
        int opcion;
        empresa.getUltimosIds();
        Cliente cliente = new Cliente(empresa.getIdCliente());
        do{
            System.out.println("Creacion cliente");
            System.out.println("Ingrese Nombre Completo:");
            String nombre = scan.nextLine();
            cliente.setNombreCompleto(nombre);
            System.out.println("Ingrese DNI:");
            String dni = scan.nextLine();
            cliente.setDni(dni);
            System.out.println("Ingrese Domicilio:");
            String domicilio = scan.nextLine();
            cliente.setDomicilio(domicilio);
            System.out.println("Ingrese Ocupacion:");
            String ocupacion = scan.nextLine();
            cliente.setOcupacion(ocupacion);
            System.out.println("Ingrese Email: ");
            String email = scan.nextLine();
            cliente.setEmail(email);
            System.out.println("Ingrese Telefono: ");
            String tel = scan.nextLine();
            cliente.setTelefono(tel);
            System.out.println("Cliente creado: ");
            System.out.println(cliente.toString());
            System.out.println("Presione 0 para aceptar");
            opcion = scan.nextInt();
            scan.nextLine();
        }while(opcion!=0);
        empresa.agregarCliente(cliente);
    }

    public void modificarCliente(Cliente buscado){
        int opcion;
        do {
            System.out.println("Que desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. DNI");
            System.out.println("3. Domicilio");
            System.out.println("4. Ocupacion");
            System.out.println("5. Cuenta");
            System.out.println("0. Volver");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion){
                case 0:
                    menuClientes();
                    break;
                case 1:
                    System.out.println("Nombre actual: "+ buscado.getNombreCompleto());
                    System.out.println("Ingrese nuevo nombre:");
                    String nuevoNombre = scan.nextLine();
                    buscado.setNombreCompleto(nuevoNombre);
                    break;
                case 2:
                    System.out.println("DNI actual: "+ buscado.getDni());
                    System.out.println("Ingrese nuevo DNI:");
                    String nuevoDni = scan.nextLine();
                    buscado.setDni(nuevoDni);
                    break;
                case 3:
                    System.out.println("Domicilio actual: "+ buscado.getDomicilio());
                    System.out.println("Ingrese nuevo Domicilio:");
                    String nuevoDomicilio = scan.nextLine();
                    buscado.setDomicilio(nuevoDomicilio);
                    break;
                case 4:
                    System.out.println("Ocupacion actual: "+ buscado.getOcupacion());
                    System.out.println("Ingrese nueva Ocupacion:");
                    String nuevoOcupacion = scan.nextLine();
                    buscado.setOcupacion(nuevoOcupacion);
                    break;
                case 5:
                    crearCuenta(buscado);
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;

            }
        }while(opcion!=0);
    }

    public void crearCuenta(Cliente c){
        int opcion;
        Cuenta nuevaCuenta = new Cuenta(c.getId(),c.getUltimoIdCuenta());
        do{
            System.out.println("Cuentas de "+ c.getNombreCompleto());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            c.listarCuentas();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Ingrese domicilio de la cuenta: ");
            String domicilio = scan.nextLine();
            System.out.println("Ingrese Fecha Alta (aaaa-MM-dd) ejemplo "+ LocalDate.now());
            String fechaAlta = scan.nextLine();
            LocalDate date = LocalDate.parse(fechaAlta);
            LocalDate fechaAumento = date.plusMonths(2);
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
                        nuevaCuenta.setNombreProveedor(proveedor.getNombre());
                    }while(proveedor==null);
                }
            }while(servicio==null);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            empresa.listarCategoriasDesc();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            CategoriaDescuento categoriaDescuento = null;
            do{
                System.out.println("Ingreser nombre servicio a agregar: ");
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
            System.out.println("Cliente creado: ");
            System.out.println(nuevaCuenta.toString());
            System.out.println("Presione 0 para aceptar");
            opcion = scan.nextInt();
            scan.nextLine();
        }while(opcion!=0);
        c.agregarCuenta(nuevaCuenta);
    }

}
