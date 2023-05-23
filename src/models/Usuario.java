package models;


public class Usuario {
    private String nombre;
    private String contraseña;
    private String email;
    private TipoUsuario tipoUsuario;

    public Usuario(String nombre, String contraseña, String email, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
