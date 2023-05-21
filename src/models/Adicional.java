package models;

public class Adicional {
    private static int id = 0;
    private String nombre;
    private Integer valor;

    public Adicional() {
    }

    public Adicional(String nombre, Integer valor) {
        this.nombre = nombre;
        this.valor = valor;
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

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Adicional{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}
