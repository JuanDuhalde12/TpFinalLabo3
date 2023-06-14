package models;

import java.util.HashMap;
import java.util.List;

public class Proveedor {
    private static int id = 0;

    private String nombre, claveOperador;
    private HashMap <Integer, Cuenta> cuentas;

    public Proveedor() {
    }

    public Proveedor(String nombre, String claveOperador) {
        this.id++;
        this.nombre = nombre;
        this.claveOperador = claveOperador;
        this.cuentas = new HashMap<>();
    }

    public static int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClaveOperador() {
        return claveOperador;
    }

    public void setClaveOperador(String claveOperador) {
        this.claveOperador = claveOperador;
    }

    public void agregarCuentaAProveedor(Integer clave, Cuenta cuenta){
        cuentas.put(clave, cuenta);
    }

    public void listarCuentasProveedor(){
        cuentas.entrySet();
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "nombre='" + nombre + '\'' +
                ", claveOperador='" + claveOperador + '\'' +
                '}';
    }
}
