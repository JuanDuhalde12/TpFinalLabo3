package models;

public class CategoriaDescuento {

    private static int cont = 0;
    private int id;
    private String nombre;
    private double porcentajeDescuento;

    public CategoriaDescuento(String nombre, double porcentajeDescuento) {
        this.id = cont++;
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public CategoriaDescuento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
