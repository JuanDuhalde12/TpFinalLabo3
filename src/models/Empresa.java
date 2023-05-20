package models;

public class Empresa {
    private static int id = 0;
    private String telefono,email,domicilio,cuit;

    public Empresa(String telefono, String email, String domicilio, String cuit) {
        id ++;
        this.telefono = telefono;
        this.email = email;
        this.domicilio = domicilio;
        this.cuit = cuit;
    }

    public Empresa() {
        id ++;
    }

    public int getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Override
    public String toString() {
        return "Empresa{ id= " + id +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", cuit='" + cuit + '\'' +
                '}';
    }
}
