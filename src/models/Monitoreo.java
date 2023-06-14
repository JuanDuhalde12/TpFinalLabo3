package models;

import java.time.LocalDate;
import java.util.Date;

public class Monitoreo extends Servicio{
    private static int id = 0;
    private String tipoInstalacion, proveedor;
    private Integer telPanel;

    public Monitoreo() {
    }

    public Monitoreo(double precio, boolean isComodato, String tipoInstalacion, String proveedor, Integer telPanel,String nombreServicio) {
        super(precio, isComodato,nombreServicio);
        this.tipoInstalacion = tipoInstalacion;
        this.proveedor = proveedor;
        this.telPanel = telPanel;
    }

    public static int getId() {
        return id;
    }

    public String getTipoInstalacion() {
        return tipoInstalacion;
    }

    public void setTipoInstalacion(String tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getTelPanel() {
        return telPanel;
    }

    public void setTelPanel(Integer telPanel) {
        this.telPanel = telPanel;
    }

    @Override
    public String toString() {
        return "Monitoreo{" +
                "tipoInstalacion='" + tipoInstalacion + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", telPanel=" + telPanel +
                "} " + super.toString();
    }
}
