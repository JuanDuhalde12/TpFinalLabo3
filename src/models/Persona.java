package models;

public class Persona {
    private String nombreCompleto, dni, email;
    private boolean isActive;

    public Persona(String nombreCompleto, String dni, String email) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.email = email;
        this.isActive = true;
    }

    public Persona() {
        this.isActive = true;
    }

    public boolean getIsActive(){return isActive;}
    public void setNotActive(){this.isActive=false;}
    public void setActive(){this.isActive=true;}
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
        return "Nombre= " + nombreCompleto + " || " +
                "dni= " + dni + " || " +
                "email= " + email + " || ";
    }
}
