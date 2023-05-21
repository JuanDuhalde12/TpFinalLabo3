package models;

public class Equipo {
    private static int id = 0;
    private String modelo;
    private Integer stock;

    public Equipo() {
    }

    public Equipo(String modelo, Integer stock) {
        this.modelo = modelo;
        this.stock = stock;
    }

    public static int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "modelo='" + modelo + '\'' +
                ", stock=" + stock +
                '}';
    }
}
