/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dominio.*;

/**
 *
 * @author martin
 */
public class ControladorAutenticarUsuario {
    
    private static Sesion sesion;//aqui va?
    private Usuario usuarioActual;
    private final Repositorio repositorio = Repositorio.getInstance();
    
    
    public void autenticarUsuario(String usuario,String contraseña){
        boolean v = false;
                
        usuarioActual = repositorio.obtenerUsuario(usuario);
        if(usuarioActual != null){
            v = usuarioActual.validar(contraseña);
        }
        if(v){
            sesion = new Sesion(usuarioActual); 
        }
    }
}
