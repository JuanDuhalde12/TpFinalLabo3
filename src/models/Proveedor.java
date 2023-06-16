package models;

import java.util.HashMap;
import java.util.List;

public class Proveedor {
    private static int cont = 0;

    private int id;
    private String nombre, claveOperador;

    public Proveedor() {
    }

    public Proveedor(String nombre, String claveOperador) {
        this.id = cont++;
        this.nombre = nombre;
        this.claveOperador = claveOperador;
    }

    public int getId() {
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


    @Override
    public String toString() {
        return "Proveedor{" +
                "nombre='" + nombre + '\'' +
                ", claveOperador='" + claveOperador + '\'' +
                '}';
    }
}
