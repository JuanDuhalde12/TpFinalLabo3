package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int id = 0;
    private String nombreCompleto,telefono,email,celular,domicilio,cuit,ocupacion;
    private List<Cuenta> listaCuentas;

    public Cliente(String nombreCompleto, String telefono, String email, String celular, String domicilio, String cuit, String ocupacion) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
        this.celular = celular;
        this.domicilio = domicilio;
        this.cuit = cuit;
        this.ocupacion = ocupacion;
        this.listaCuentas = new ArrayList<>();
    }

    public static int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
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
        return "Cliente{ id= " + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", cuit='" + cuit + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }
}
