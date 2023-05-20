package models;

public class Cuenta {
    private static int nroCuenta = 0;
    private String domicilioServicio;
    private Servicio servicio;
    private CategoriaDescuento categoria;

    public Cuenta(String domicilioServicio, Servicio servicio, CategoriaDescuento categoria) {
        this.domicilioServicio = domicilioServicio;
        this.servicio = servicio;
        this.categoria = categoria;
    }

    public Cuenta() {
    }

    public static int getNroCuenta() {
        return nroCuenta;
    }

    public static void setNroCuenta(int nroCuenta) {
        Cuenta.nroCuenta = nroCuenta;
    }

    public String getDomicilioServicio() {
        return domicilioServicio;
    }

    public void setDomicilioServicio(String domicilioServicio) {
        this.domicilioServicio = domicilioServicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public CategoriaDescuento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDescuento categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "domicilioServicio='" + domicilioServicio + '\'' +
                ", servicio=" + servicio.toString() +
                ", categoria descuento=" + categoria.toString() +
                '}';
    }
}
