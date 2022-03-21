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
public class Defecto {
    String tipo;
    String pie;//String?
    int totalPorPie;
    int acumulado;
    int horaDeRegistro;
    String fechaDeRegistro;//date

    public Defecto(String tipo) {
        this.tipo = tipo;
    }
}
