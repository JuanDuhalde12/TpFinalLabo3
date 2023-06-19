package models;

import java.util.HashMap;
import java.util.List;

public class Proveedor {
    private static int cont = 0;

    private int id;
    private String nombre,telefono;

    public Proveedor() {
    }

    public Proveedor(String nombre, String telefono) {
        this.id = cont++;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public Proveedor(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono;
    }
}
