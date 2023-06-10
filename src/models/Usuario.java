package models;


public class Usuario extends Persona{
    private String nombre;
    private String contraseña;
    private TipoUsuario tipoUsuario;

    public Usuario(String nombreCompleto, String dni, String email, String nombre, String contraseña, TipoUsuario tipoUsuario) {
        super(nombreCompleto, dni, email);
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String nombre, String contraseña, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.contraseña = contraseña;
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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{ " + super.toString() +
                ", nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                "} " ;
    }
}
