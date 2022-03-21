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
public class iniciarOPControlador {
    
    private OrdenDeProduccion opActual;
    private Modelo modeloActual;
    private Color[] colores;
    private Color colorActual;
    private JornadaLaboral jornada;
    private Turno turnoActual;
    private LineaDeProduccion lineaActual;
    private final Repositorio repositorio = Repositorio.getInstance();
    
    public void iniciarOP() {
        Usuario usuario = Sesion.obtenerEmpleado();//usuario o empleado o String
        opActual = new OrdenDeProduccion(usuario);
    }
    
    public void seleccionarModelo(int numeroop, Modelo modelo){//modelo o String
        opActual = repositorio.buscarOrden(numeroop);//ya tenia la op, la guardamos en esta clase
        modeloActual = repositorio.buscarModelo(modelo);
        colores = modeloActual.obtenerColores();
        opActual.asignarModelo(modeloActual);
    }
    
    public void confirmar(int numeroop, int linea, String color, ArrayList objetivos,int hora){//agrego la hora para obtener el turno
        jornada = new JornadaLaboral(objetivos,turnoActual);
        lineaActual = repositorio.buscarLinea(linea);
        colorActual = repositorio.buscarColor(color);
        turnoActual = repositorio.buscarTurno(hora);
        opActual = repositorio.buscarOrden(numeroop);
        opActual.asociarDatos(colorActual,jornada,lineaActual);
    }
      
}
