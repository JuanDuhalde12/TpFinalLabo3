package models;


import java.util.ArrayList;

public class Servicio {
    private static int cont = 0;
    private boolean isActive;
    private int id;
    private String nombreServicio;
    private double precio;
    private boolean isComodato;

    public Servicio(double precio, boolean isComodato, String nombreServicio) {
        this.id = cont++;
        this.precio = precio;
        this.isComodato = isComodato;
        this.nombreServicio = nombreServicio;
        this.isActive = true;
    }

    public Servicio(int id) {
        super();
        this.id=id;
    }

    public Servicio() {
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public boolean getIsActive(){return isActive;}
    public void setNotActive(){this.isActive=false;}
    public void setActive(){this.isActive=true;}
    public int getId() {
        return id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(this.isComodato){
            this.precio = precio + 1500;
        }else{
            this.precio = precio;
        }

    }

    public boolean isComodato() {
        return isComodato;
    }

    public void setComodato(boolean comodato) {
        isComodato = comodato;
    }

    @Override
    public String toString() {
        return "Servicio >> " +
                "nombreServicio= " + nombreServicio + " || " +
                "precio= " + precio +" <<";
    }
}
