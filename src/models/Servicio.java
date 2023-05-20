package models;

import java.util.Date;

public class Servicio {
    private static int id = 0;
    private double precio;
    private Date fechaAlta,fechaAumento;
    private boolean isComodato;

    public Servicio(double precio, Date fechaAlta, Date fechaAumento, boolean isComodato) {
        this.precio = precio;
        this.fechaAlta = fechaAlta;
        this.fechaAumento = fechaAumento;
        this.isComodato = isComodato;
    }

    public Servicio() {
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Servicio.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaAumento() {
        return fechaAumento;
    }

    public void setFechaAumento(Date fechaAumento) {
        this.fechaAumento = fechaAumento;
    }

    public boolean isComodato() {
        return isComodato;
    }

    public void setComodato(boolean comodato) {
        isComodato = comodato;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "precio=" + precio +
                ", fechaAlta=" + fechaAlta +
                ", fechaAumento=" + fechaAumento +
                ", isComodato=" + isComodato +
                '}';
    }
}
