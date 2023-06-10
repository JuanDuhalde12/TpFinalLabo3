package menu;

import Exceptions.LoginException;
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
                            System.out.println("Bienvenido al sistema "+this.usuario.getNombre());
                        }
                    }catch(LoginException e){
                        System.out.println(e.toString());
                    }

                    break;
            }
        }while(opcion!=0);

    }
}
