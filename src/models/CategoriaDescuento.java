package models;

public class CategoriaDescuento {
    private String nombre;
    private double porcentajeDescuento;

    public CategoriaDescuento(String nombre, double porcentajeDescuento) {
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public CategoriaDescuento() {
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public String toString() {
        return "CategoriaDescuento{" +
                "nombre='" + nombre + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }
}
