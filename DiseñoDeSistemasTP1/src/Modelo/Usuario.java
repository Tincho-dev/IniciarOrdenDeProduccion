package Modelo;

public class Usuario {

    String usuario;
    String contraseña;
    private String apellidoYNombre;//??

    public Usuario(String apellidoYNombre) {
        this.apellidoYNombre = apellidoYNombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getApellidoYNombre() {
        return apellidoYNombre;
    }

    public void setApellidoYNombre(String apellidoYNombre) {
        this.apellidoYNombre = apellidoYNombre;
    }

}
