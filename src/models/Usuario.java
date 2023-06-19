package models;


import com.google.gson.internal.bind.util.ISO8601Utils;

public class Usuario extends Persona{
    private static int cont = 0;
    private int id;
    private String nombre;
    private String contraseña;
    private TipoUsuario tipoUsuario;

    public Usuario(String nombreCompleto, String dni, String email, String nombre, String contraseña, TipoUsuario tipoUsuario) {
        super(nombreCompleto, dni, email);
        this.id = cont++;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String nombre, String contraseña, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(int id) {
        super();
        this.id=id;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void cambioDeTipoDeUsuario(){
        if(getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)){
            setTipoUsuario(TipoUsuario.USUARIO);
        }else{
            setTipoUsuario(TipoUsuario.ADMINISTRADOR);
        }
    }

    public void mostrarElOtroTipo(){
        if(getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)){
            System.out.println("Pasara a ser de tipo: " + TipoUsuario.USUARIO);
        }else {
            System.out.println("Pasara a ser de tipo: " + TipoUsuario.ADMINISTRADOR);
        }
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
