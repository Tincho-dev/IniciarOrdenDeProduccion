/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author martin
 */
public class Sesion {
    
    private static Sesion sesion;
    private static Usuario usuario;
    
    public Sesion(Usuario usuarioActual){
        Sesion.usuario = usuarioActual;
    }
    
    public static Sesion getInstance(){
        
        if(sesion == null){
            sesion = new Sesion(usuario);
        }
        return sesion;
    }
    
    
    
    public static Usuario obtenerEmpleado() {
        return usuario;
    }
    
}
