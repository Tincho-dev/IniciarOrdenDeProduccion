/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dominio.*;
import java.util.ArrayList;

/**
 *
 * @author martin
 */
public class ControladorAsociarSupervisoraOP {

    private ArrayList<LineaDeProduccion> lineas;
    private OrdenDeProduccion opActual;
    private Usuario emp;//que tipo de dato le pongo? Empleado, Usuario, String
    private final Repositorio repositorio = Repositorio.getInstance();
    
    public void buscarLineasDisponibles() {
        lineas = repositorio.obtenerLineasDisponibles();
    }

    public void confirmarAsociacion(int numeroLinea) {
        boolean v = false;
        boolean s = false;
        v = repositorio.validarLinea(numeroLinea);//validarLinea
        opActual = repositorio.buscarOrden(numeroLinea);
        emp = Sesion.obtenerEmpleado();
        s = repositorio.supervisorLibre(emp);
        if (v && s) {
            opActual.asociarSupervisor(emp, numeroLinea);
        }
    }

    public void abandonarOP(int numeroLinea) {
        boolean v = false;
        boolean s = false;
        v = repositorio.validarLinea(numeroLinea);//validarLinea
        opActual = repositorio.buscarOrden(numeroLinea);
        emp = Sesion.obtenerEmpleado();
        if (v) {
            opActual.abandonarSupervisor(emp, numeroLinea);
        }
    }

}
