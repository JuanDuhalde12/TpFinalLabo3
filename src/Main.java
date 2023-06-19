

import Archivos.*;
import Coleccion.*;
import menu.Menu;
import models.*;

import java.sql.ClientInfoStatus;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//      comenzar();
      /*
      Cosas para hacer:
      - ver tomar ultimo id
      - cuando das de baja cliente, dar de baja tmb cuentas de ese cliente
       */
       Menu menu = new Menu();
       menu.menuInicio();

    }

    //FUNCION QUE CREA HARDCODEADO VARIOS OBJETOS CON LOS CUALES VA A FUNCIONAR EL SISTEMA
     public static void comenzar() {
      //Crear clientes
      Cliente c1 = new Cliente("Juan Ignacio Duhalde", "34851803", "juan@juan.com.ar", "4510112", "lala 123", "empleado");
      Cliente c2 = new Cliente("Roberto Perez", "13885989", "Roberto@Roberto.com.ar", "4788858", "pepe 123", "abogado");

      //Crear usuarios
      Usuario admin = new Usuario("admin", "0", "admin@admin.com", "admin", "admin", TipoUsuario.ADMINISTRADOR);
      Usuario user1 = new Usuario("Juan Ignacio Duhalde", "34851803", "jduhalde@gmail.com", "jduhalde", "Juan1234", TipoUsuario.USUARIO);
      Usuario user2 = new Usuario("Emanuel Peral", "36382541", "emaperal@gmail.com", "eperal", "123456", TipoUsuario.USUARIO);

      //Crear Proveedores
      Proveedor intacto = new Proveedor("Intacto","451-0032");
      Proveedor medinilla = new Proveedor("Medinilla","478-8855");

      //Obtener fechas
      LocalDate fechaHoy = LocalDate.now();
      LocalDate aumento = fechaHoy.plusMonths(2);

      //convertir string to LocalDate
      String fecha = fechaHoy.toString();
      LocalDate date = LocalDate.parse(fecha);
      System.out.println(date);

      //Crear Servicios
      Servicio monitoreo = new Servicio(1500, false, "Monitoreo");
      Servicio instalacion = new Servicio(3800, false, "Instalación");

      //Crear categoria de descuentos
      CategoriaDescuento cat1 = new CategoriaDescuento("cat 1", 15);
      CategoriaDescuento cat2 = new CategoriaDescuento("cat 2", 20);

      //Creamos las cuentas
      Cuenta cta1 = new Cuenta("Roldan 557", monitoreo, cat1, fechaHoy.toString(), aumento.toString(),"gato",intacto,c1.getId());
      Cuenta cta2 = new Cuenta("Zacagnini 4505", instalacion, cat2, fechaHoy.toString(), aumento.toString(),"perro",medinilla,c1.getId());

      //agregamos cuentas a cliente
      c1.agregarCuenta(cta1);
      c1.agregarCuenta(cta2);

      //Creamos el controlador de archivos
      Controlador cont = new Controlador();

      //Creacion de la colecciones
      Coleccion<Cliente> coleccionClientes = new Coleccion<Cliente>();
      Coleccion<Usuario> coleccionUsuarios= new Coleccion<Usuario>();
      Coleccion<Servicio> coleccionServicios= new Coleccion<Servicio>();
      Coleccion<CategoriaDescuento> categoriaDescuentoColeccion = new Coleccion<CategoriaDescuento>();
      ListaProveedor listaProveedores = new ListaProveedor();


      //agregamos clientes a la coleccion
      coleccionClientes.agregar(c1);
      coleccionClientes.agregar(c2);

      //crea archivo clientes
      cont.actualizarArchivoClientes(coleccionClientes);

      //agregamos usuarios a la coleccion
      coleccionUsuarios.agregar(admin);
      coleccionUsuarios.agregar(user1);
      coleccionUsuarios.agregar(user2);

      //creamos archivo usuarios
      cont.actualizarArchivoUsuarios(coleccionUsuarios);

      //agregamos proveedores a la coleccion
      listaProveedores.agregar(intacto);
      listaProveedores.agregar(medinilla);

      //creamos archivo proveedores
      cont.actualizarArchivoProveedores(listaProveedores);

      //agregamos servicios a la coleccion
      coleccionServicios.agregar(monitoreo);
      coleccionServicios.agregar(instalacion);

      //creamos archivo servicios
      cont.actualizarArchivoServicios(coleccionServicios);

      //agregamos servicios a la coleccion
      categoriaDescuentoColeccion.agregar(cat1);
      categoriaDescuentoColeccion.agregar(cat2);

      //creamos archivo servicios
      cont.actualizarArchivoCategoriaDesc(categoriaDescuentoColeccion);
    }
}