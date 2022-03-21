/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author martin
 */
public class Repositorio {

    private ArrayList<OrdenDeProduccion> ordenes;
    private ArrayList<LineaDeProduccion> lineas;
    private ArrayList<Color> colores;
    private ArrayList<Modelo> modelos;
    private ArrayList<Defecto> defectos;
    private ArrayList<Turno> turnos;
    private ArrayList<Usuario> usuarios;
    private static Repositorio instancia;
    
    public Repositorio(){
        //constructor en singleton
    }
    
    public static Repositorio getInstance(){
        
        if(instancia == null){
            instancia = new Repositorio();
        }
        return instancia;
    }
    
    public void cargar(){
        
        lineas.add(new LineaDeProduccion(1));
        lineas.add(new LineaDeProduccion(2));
        lineas.add(new LineaDeProduccion(3));
        lineas.add(new LineaDeProduccion(4));
        lineas.add(new LineaDeProduccion(5));
        
        colores.add(new Color(1,"Azul Marino"));        
        colores.add(new Color(2,"Rojo"));
        colores.add(new Color(3,"Bordó"));
        colores.add(new Color(4,"Azul Francia"));        
        colores.add(new Color(5,"Blanco"));        
        colores.add(new Color(6,"Negro"));
        
        //modelos
        modelos.add(new Modelo(colores,"1234","Adidas Runner"));
        modelos.add(new Modelo(colores,"3456","Topper 2022"));
        modelos.add(new Modelo(colores,"FGWE","Nike Air 2020"));
        
        defectos.add(new Defecto("Suela Despegada"));
        defectos.add(new Defecto("Mancha en Tela"));
        defectos.add(new Defecto("Corte, Agujero"));
        defectos.add(new Defecto("Adorno Mal Puesto"));
        
        turnos.add(new Turno(1,8,12));
        turnos.add(new Turno(2,13,17));
        turnos.add(new Turno(3,18,22));
        
        usuarios.add(new Usuario("Tincho","1234"));//String o int?
        usuarios.add(new Usuario("Daniel","gatitos123"));
        usuarios.add(new Usuario("Melisa Rodriguez","Diseño3k3"));
        
        
        //ordenes
        //ordenes.add(new OrdenDeProduccion());
        
        
    
    
    
    
    }
    
    public OrdenDeProduccion buscarOrden(int numeroop) {
        for(int i = 0; i < ordenes.size(); i++){
            if(ordenes.get(i).getNumero() == numeroop){
                return ordenes.get(i);
            }
        }  
        return null;
    }

    public Modelo buscarModelo(Modelo modelo) {
        for(int i = 0; i < modelos.size(); i++){
            if(modelos.get(i) == modelo){
                return modelos.get(i);
            }
        }  
        return null;
    }

    public void actualizarOP(OrdenDeProduccion opActual) {
        
        int index = -1;
        
        for(int i = 0; i < ordenes.size(); i++){
            if(ordenes.get(i).getNumero() == opActual.getNumero()){
                index = i;
            }
        }  
        if(index > -1){
            ordenes.set(index, opActual); 
        }
    }

    public Defecto buscarDefecto(String defecto) {
        for(int i = 0; i < defectos.size(); i++){
            if(defectos.get(i).tipo.equals(defecto)){
                return defectos.get(i);
            }
        }  
        return null;
    }

    public LineaDeProduccion buscarLinea(int linea) {
        for(int i = 0; i < lineas.size(); i++){
            if(lineas.get(i).numero == linea){
                return lineas.get(i);
            }
        }  
        return null;
    }
    
    public Turno buscarTurno(int hora) {
        for (int i = 0; i < turnos.size(); i++) {
            if ((turnos.get(i).horaInicio <= hora) && (hora <= turnos.get(i).horaFin)) {
                return turnos.get(i);
            }
        }
        return null;
    }

    public Color buscarColor(String color) {
        for(int i = 0; i < colores.size(); i++){
            if(colores.get(i).descripcion.equals(color)){
                return colores.get(i);
            }
        }  
        return null;
    }

    public ArrayList<Color> obtenerColores() {
        return this.colores;
    }

    public void guardarModelo(Modelo modelo) {
        modelos.add(modelo);
    }

    public Usuario obtenerUsuario(String usuario) {
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).usuario.equals(usuario)){
                return usuarios.get(i);
            }
        }  
        return null;
    }

    public ArrayList<LineaDeProduccion> obtenerLineasDisponibles() {
        
        ArrayList<LineaDeProduccion> lineasLibres = null;
        
        for(int i = 0; i < ordenes.size(); i++){
            if(ordenes.get(i).getEstado().equals(EstadoOP.ACTIVA) && ordenes.get(i).getSupervisorActual() == null){
                lineasLibres.add(ordenes.get(i).getLineaActual());
            }
        }  
        return lineasLibres;
    }

    public boolean validarLinea(int numeroLinea) {
        for(int i = 0; i < ordenes.size(); i++){
            if(ordenes.get(i).getEstado().equals(EstadoOP.ACTIVA) && ordenes.get(i).getSupervisorActual() == null){
                return true;
            }
        }
        return false;
    }

    public boolean supervisorLibre(Usuario emp) {
        for(int i = 0; i < ordenes.size(); i++){
            if(ordenes.get(i).getSupervisorActual() == emp){
                return false;
            }
        }
        return true;
    }
    
}
