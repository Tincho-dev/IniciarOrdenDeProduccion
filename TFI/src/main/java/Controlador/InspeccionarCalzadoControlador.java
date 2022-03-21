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
public class InspeccionarCalzadoControlador {
   private OrdenDeProduccion opActual;
   private JornadaLaboral jornada;
   private Defecto defectoActual;
   private int totalPrimera;
   private int totalDefectos;
   private final Repositorio repositorio = Repositorio.getInstance();
   
   public void iniciarInspeccion(int numeroop){
       opActual = repositorio.buscarOrden(numeroop);
   }
   
   public void registrarParDePrimera(int numeroop, int hora, int cantidad){
       opActual = repositorio.buscarOrden(numeroop);
       jornada = opActual.obtenerJornada();
       jornada.registrarParDePrimera(hora,cantidad);
       repositorio.actualizarOP(opActual);
   }
   
   public void registrarDefecto(int numeroop,int hora,int cantidad, String pie, String defecto){
       opActual = repositorio.buscarOrden(numeroop);
       defectoActual = repositorio.buscarDefecto(defecto);
       jornada = opActual.obtenerJornada();
       jornada.registrarDefecto(hora,cantidad);
       repositorio.actualizarOP(opActual);
   }
   
   public void cambiarHora(int hora){
       //opActual = Repositorio.buscarOrden();
       totalPrimera = opActual.totalPrimera(hora);
       totalDefectos = opActual.obtenerTotalDefectos(hora);
   }
   
}
