package models;

public class Cuenta {
    private static int nroCuenta = 0;
    private String domicilioServicio;
    private Servicio servicio;
    private String fechaAlta,fechaAumento;
    private CategoriaDescuento categoria;

    public Cuenta(String domicilioServicio, Servicio servicio, CategoriaDescuento categoria, String fechaAlta, String fechaAumento) {
        this.domicilioServicio = domicilioServicio;
        this.servicio = servicio;
        this.categoria = categoria;
        this.fechaAumento = fechaAumento;
        this.fechaAlta = fechaAlta;
    }

    public Cuenta() {
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaAumento() {
        return fechaAumento;
    }

    public void setFechaAumento(String fechaAumento) {
        this.fechaAumento = fechaAumento;
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
                ", servicio=" + servicio +
                ", fechaAlta='" + fechaAlta + '\'' +
                ", fechaAumento='" + fechaAumento + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
