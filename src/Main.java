
import javax.swing.*;

import Archivos.*;
import models.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

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

        Servicio monitoreo = new Servicio(1500,fechaHoy.toString(),aumento.toString(),false);
        CategoriaDescuento cat1 = new CategoriaDescuento("cat 1",15);
        Cuenta cta1 = new Cuenta("Roldan 557",monitoreo,cat1);
        Servicio instalacion = new Servicio(3800,fechaHoy.toString(),aumento.toString(),false);
        CategoriaDescuento cat2 = new CategoriaDescuento("cat 2",20);
        Cuenta cta2 = new Cuenta("Zacagnini 4505",instalacion,cat2);
        c1.agregarCuenta(cta1);
        c1.agregarCuenta(cta2);
        ArchivoUsuario archivoPersona = new ArchivoUsuario();
        ArchivoCliente archivoCliente = new ArchivoCliente();
        ArchivoServicio archivoServicio = new ArchivoServicio();

        /*archivoPersona.agregarUsuario(admin);
        archivoPersona.agregarUsuario(user1);
        archivoPersona.crearArchivoJson();
        archivoCliente.agregarCliente(c1);
        archivoCliente.agregarCliente(c2);
        archivoCliente.crearArchivo();
        archivoServicio.agregarServicio(monitoreo);
        archivoServicio.agregarServicio(instalacion);
        archivoServicio.crearArchivo();*/

        archivoPersona.leerArchivo();
        archivoCliente.leerArchivo();
        archivoServicio.leerArchivo();


        System.out.println("Lista Archivo Persona");
        archivoPersona.listarPersonas();


        System.out.println("Lista Archivo Clientes");
        archivoCliente.listar();

        System.out.println("Lista Archivo Servicios");
        archivoServicio.listar();

    }
}