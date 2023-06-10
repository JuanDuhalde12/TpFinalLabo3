package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private static int id = 0;
    private String telefono, domicilio, ocupacion;
    private List<Cuenta> listaCuentas;


    public Cliente(String nombreCompleto, String dni, String email, String telefono, String domicilio, String ocupacion) {
        super(nombreCompleto, dni, email);
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.ocupacion = ocupacion;
        this.listaCuentas = new ArrayList<>();
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

    public void mostrarCuentas(){
        for(Cuenta cta : listaCuentas){
            System.out.println(cta.toString());
        }
    }

    @Override
    public String toString() {
        return "Cliente{ " + super.toString() +
                ", telefono='" + telefono + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", listaCuentas=" + listaCuentas +
                "} " ;
    }
}
