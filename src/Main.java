
import javax.swing.*;

import Archivos.*;
import Coleccion.Coleccion;
import menu.Menu;
import models.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //comenzar();


        Menu menu = new Menu();
        menu.iniciar();


    }

     public static void comenzar(){
       Cliente c1 = new Cliente("Juan Ignacio Duhalde","34851803","juan@juan.com.ar","4510112","lala 123","empleado");
        Cliente c2 = new Cliente("Roberto Perez","13885989","Roberto@Roberto.com.ar","4788858","pepe 123","abogado");
        Usuario admin = new Usuario("admin","0","admin@admin.com","admin","admin",TipoUsuario.ADMINISTRADOR);
        Usuario user1 = new Usuario("Juan Ignacio Duhalde","34851803","jduhalde@gmail.com","jduhalde","Juan851803",TipoUsuario.USUARIO);

        LocalDate fechaHoy = LocalDate.now();
        LocalDate aumento = fechaHoy.plusMonths(2);

        //convertir string to LocalDate
        String fecha = fechaHoy.toString();
        LocalDate date = LocalDate.parse(fecha);
        System.out.println(date);

        Servicio monitoreo = new Servicio(1500,false,"Monitoreo");
        Servicio instalacion = new Servicio(3800,false,"Instalación");
        CategoriaDescuento cat1 = new CategoriaDescuento("cat 1",15);
        CategoriaDescuento cat2 = new CategoriaDescuento("cat 2",20);

        Cuenta cta1 = new Cuenta("Roldan 557",monitoreo,cat1,fechaHoy.toString(),aumento.toString());
        Cuenta cta2 = new Cuenta("Zacagnini 4505",instalacion,cat2,fechaHoy.toString(),aumento.toString());

        c1.agregarCuenta(cta1);
        c1.agregarCuenta(cta2);

        Controlador cont = new Controlador();
        Coleccion<Cliente> coleccionClientes = new Coleccion<Cliente>();
        Coleccion<Usuario> coleccionUsuarios= new Coleccion<Usuario>();;
        Coleccion<Servicio> coleccionServicios= new Coleccion<Servicio>();;


        coleccionClientes.agregar(c1);
        coleccionClientes.agregar(c2);
        cont.actualizarArchivoClientes(coleccionClientes);

        coleccionUsuarios.agregar(admin);
        coleccionUsuarios.agregar(user1);
        cont.actualizarArchivoUsuarios(coleccionUsuarios);

        coleccionServicios.agregar(monitoreo);
        coleccionServicios.agregar(instalacion);
        cont.actualizarArchivoServicios(coleccionServicios);
    }
}