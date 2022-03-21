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
public class OrdenDeProduccion {
    private EstadoOP estado;
    private int horaDeInicio;
    private String fechaDeInicio;//date
    private int numero;
    private Usuario supervisorActual;
    private LineaDeProduccion lineaActual;

    public Usuario getSupervisorActual() {
        return supervisorActual;
    }

    public int getNumero() {
        return numero;
    }

    public LineaDeProduccion getLineaActual() {
        return lineaActual;
    }

    public OrdenDeProduccion(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        return "el estado es " + this.estado;
    }

    public EstadoOP getEstado() {
        return estado;
    }
    
    //public Jornada

    public void asignarModelo(Modelo modeloActual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JornadaLaboral obtenerJornada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int totalPrimera(int hora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int obtenerTotalDefectos(int hora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void asociarDatos(Color colorActual, JornadaLaboral jornada, LineaDeProduccion lineaActual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void asociarSupervisor(Usuario emp, int numeroLinea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void abandonarSupervisor(Usuario emp, int numeroLinea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
