package models;

public class Cuenta {
    private static int count = 0;
    private String nroCuenta;
    private String domicilioServicio;
    private Servicio servicio;
    private String fechaAlta,fechaAumento;
    private CategoriaDescuento categoria;
    private String claveOperador;
    private Proveedor prov;
    private boolean isActive;

    public Cuenta(String domicilioServicio, Servicio servicio, CategoriaDescuento categoria, String fechaAlta, String fechaAumento, String claveOperador,Proveedor prov,int idCliente) {
        this.nroCuenta = idCliente+"/"+count++;
        this.domicilioServicio = domicilioServicio;
        this.servicio = servicio;
        this.categoria = categoria;
        this.fechaAumento = fechaAumento;
        this.fechaAlta = fechaAlta;
        this.claveOperador = claveOperador;
        this.isActive = true;
        this.prov = prov;
    }

    public Cuenta(int idCliente,int ultimoId) {
        this.nroCuenta = idCliente+"/"+ultimoId;
        this.isActive = true;
    }

    public String getClaveOperador() {
        return claveOperador;
    }
    public void setClaveOperador(String claveOperador) {
        this.claveOperador = claveOperador;
    }
    public boolean getIsActive() {
        return isActive;
    }
    public void setNotActive(){this.isActive=false;}
    public void setActive(){this.isActive=true;}
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

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
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

    public Proveedor getProveedor() {
        return prov;
    }

    public void setProveedor(String nombreProveedor) {
        this.prov = prov;
    }



    @Override
    public String toString() {
        return "Cuenta >> " +
                "nroCuenta =" + nroCuenta + " || " +
                "domicilioServicio= " + domicilioServicio + " || " +
                "servicio= " + servicio +
                "fechaAlta= " + fechaAlta + " || " +
                "fechaAumento= " + fechaAumento + " || " +
                "categoria= " + categoria + " || " +
                "claveOperador= " + claveOperador + " || " +
                "nombreProveedor= " + prov + " <<";
    }
}
