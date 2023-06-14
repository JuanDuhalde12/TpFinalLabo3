package menu;

import Exceptions.LoginException;
import models.Cliente;
import models.Empresa;
import models.TipoUsuario;
import models.Usuario;

import java.io.Console;
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
            System.out.println("0. Salir");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion){
                case 1:
                    menuClientes();
                    break;
                default:
                    break;
            }
        }while(opcion!=0);

    }

    public void menuInicioUser(){

    }

    public void menuClientes(){
        int opcion;
        do {
            if(this.usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){
                System.out.println("Menu Cliente");
                System.out.println("1. Buscar");
                System.out.println("2. Eliminar");
                System.out.println("3. Modificar");
                System.out.println("0. Salir");
                opcion = scan.nextInt();
                scan.nextLine();
            }else{
                System.out.println("Bienvenido al sistema");
                System.out.println("1. Buscar");
                System.out.println("2. Modificar");
                System.out.println("0. Salir");
                opcion = scan.nextInt();
                scan.nextLine();
            }


            switch (opcion){
                case 0:
                    if(this.usuario.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
                        menuInicioAdmin();
                    }else{
                        menuInicioUser();
                    }
                    break;
                case 1:
                    System.out.println("Ingrese dni cliente a buscar");
                    String dni = scan.nextLine();
                    Cliente buscado = empresa.buscarClienteXDni(dni);
                    if(buscado!=null){
                        System.out.println(buscado.toString());
                    }else{
                        System.out.println("El cliente no existe");
                    }

                    break;
                default:

                    break;
            }
        }while(opcion!=0);

    }

    public void crearCliente(){
    }
}
