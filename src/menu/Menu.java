package menu;

import models.TipoUsuario;
import models.Usuario;
import java.util.Scanner;

public class Menu {
    private Scanner scan;
    private Usuario admin;
    private TipoUsuario tipoUsuario;

    public Menu(){
        scan = new Scanner(System.in);
        admin = new Usuario();
        admin.setContraseña("admin");
        admin.setNombre("admin");
        admin.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
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
                    if(usuario.equals(admin.getNombre()) && contraseña.equals(admin.getContraseña())){
                        System.out.println("Bienvenido administrador");
                    }else{
                        System.out.println("La contraseña es incorrecta");
                    }

                    break;
            }
        }while(opcion!=0);

    }
}
