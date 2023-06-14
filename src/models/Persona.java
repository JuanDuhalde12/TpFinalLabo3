package models;

public class Persona {
    private String nombreCompleto, dni, email;

    public Persona(String nombreCompleto, String dni, String email) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.email = email;
    }

    public Persona() {
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "nombre:'" + nombreCompleto + '\'' +
                ", dni:'" + dni + '\'' +
                ", email:'" + email + '\'';
    }
}
