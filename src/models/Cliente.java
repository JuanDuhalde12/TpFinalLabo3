package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private static int id = 0;
    private String telefono, celular, domicilio, ocupacion;
    private List<Cuenta> listaCuentas;


    public Cliente(String nombreCompleto, String dni, String email, String telefono, String celular, String domicilio, String ocupacion, List<Cuenta> listaCuentas) {
        super(nombreCompleto, dni, email);
        this.telefono = telefono;
        this.celular = celular;
        this.domicilio = domicilio;
        this.ocupacion = ocupacion;
        this.listaCuentas = listaCuentas;
    }

    public Cliente() {
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Cliente.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public void listarCuentas(){
        int i = 1;
        for (Cuenta cuenta:listaCuentas) {
            System.out.println(i + " " + cuenta.toString());
            i++;
        }
    }

    public void agregarCuenta(Cuenta cuenta){
        listaCuentas.add(cuenta);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "telefono='" + telefono + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", listaCuentas=" + listaCuentas +
                "} " + super.toString();
    }
}
