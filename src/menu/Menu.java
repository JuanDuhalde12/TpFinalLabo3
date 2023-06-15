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

    public void iniciar(){
        int opcion;
        do {
            System.out.println("Bienvenido al sistema");
            System.out.println("1. Log In");
            System.out.println("0. Salir");
            opcion = scan.nextInt();
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
                                menuInicioAdmin();
                            }else{
                                menuInicioUser();
                            }
                        }
                    }catch(LoginException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                default:
                    System.out.println("Cerrando sistema....");
                    System.out.println("Actualizando archivos...");
                    empresa.actualizarArchivos();
                    break;
            }
        }while(opcion!=0);
    }

    public void menuInicioAdmin(){
        int opcion;
        do {
            System.out.println("Bienvenido al sistema");
            System.out.println("1. Menu Cliente");
            System.out.println("2. Menu Usuario");
            System.out.println("3. Menu Servicios");
            System.out.println("0. Volver");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion){
                case 0:
                    iniciar();
                    break;
                case 1:
                    menuClientes();
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=0);

    }

    public void menuInicioUser(){

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
                    iniciar();
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
                    Cliente cliente = crearCliente();
                    empresa.agregarCliente(cliente);
                    System.out.println("Cliente agregado");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;
            }
        }while(opcion!=0);

    }

    public Cliente crearCliente(){
        int opcion;
        Cliente cliente = new Cliente();
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
            System.out.println("Cliente creado: ");
            System.out.println(cliente.toString());
            System.out.println("Presione 0 para aceptar");
            opcion = scan.nextInt();
            scan.nextLine();
        }while(opcion!=0);


        return cliente;
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
                    menuCuenta(buscado);
                    break;
                default:
                    System.out.println("Comando no valido");
                    break;

            }
        }while(opcion!=0);
    }

    public void menuCuenta(Cliente c){
        Cuenta nuevaCuenta = new Cuenta();
        System.out.println("Cuentas de "+ c.getNombreCompleto());
        c.listarCuentas();
        System.out.println("Ingrese domicilio de la cuenta: ");
        String domicilio = scan.nextLine();
        System.out.println("Ingrese Fecha Alta (aaaa-MM-dd) ejemplo "+ LocalDate.now());
        String fechaAlta = scan.nextLine();
        LocalDate date = LocalDate.parse(fechaAlta);
        LocalDate fechaAumento = date.plusMonths(2);
        System.out.println("Servicios: ");
        empresa.listarServicios();
        Servicio servicio = null;
        do{
            System.out.println("Ingreser nombre servicio a agregar: ");
            String nombreServicio = scan.nextLine();
            servicio = empresa.buscarServicio(nombreServicio);
        }while(servicio!=null);
        //parte listar categorias..

    }

}
