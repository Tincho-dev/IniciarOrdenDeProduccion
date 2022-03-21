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
public class GestionarModelosControlador {
    
    private ArrayList<Color> colores;
    private Modelo modelo;
    private final Repositorio repositorio = Repositorio.getInstance();
    
    public void obtenerColores(){
        colores = repositorio.obtenerColores();
    }
    
    public void confirmarModelo(ArrayList<Color> colores,String sku, String denom){//denominacion, colores? colorActual?
        modelo = new Modelo(colores,sku,denom);//GASP creador
        repositorio.guardarModelo(modelo);
    }
}
