
package Modelo;

import java.util.ArrayList;

public class ModeloCalzado {
    private String SKU;//tine letras y numeros
    private ArrayList<Color> coloresCalzado;
    private String denominacion;

    public ModeloCalzado(String SKU, ArrayList<Color> coloresCalzado) {
        this.SKU = SKU;
        this.coloresCalzado = coloresCalzado;
    }
    
    public ModeloCalzado(String SKU) {
        this.SKU = SKU;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public ArrayList<Color> getColoresCalzado() {
        return coloresCalzado;
    }

    public void setColoresCalzado(ArrayList<Color> coloresCalzado) {
        this.coloresCalzado = coloresCalzado;
    }
    
}
