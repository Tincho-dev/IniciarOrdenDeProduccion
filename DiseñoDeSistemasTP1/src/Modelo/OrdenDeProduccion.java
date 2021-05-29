package Modelo;

import static Modelo.Datos.*;
import java.util.ArrayList;

public class OrdenDeProduccion{
    
    private int horaDeInicio;
    private SupervisorDeLinea supervisor;
    private LineaDeProduccion linea;
    private Fecha fecha;
    private Color color;
    private ModeloCalzado modelo;
    public EstadoOP estado;
    private ArrayList<HorarioParaObjetivos> horarioParaObjetivos;

    public OrdenDeProduccion() {
       
        this.horaDeInicio = horaActual;
        this.fecha = fechaActual;
    }
    
    public void mostrar(){
        System.out.println(modelo.getDenominacion());
    }
    
    public int getHorario() {
        return horaDeInicio;
    }

    public void setHorario(int horario) {
        this.horaDeInicio = horario;
    }
    
    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ModeloCalzado getModelo() {
        return modelo;
    }

    public void setModelo(ModeloCalzado modelo) {
        this.modelo = modelo;
    }

    public EstadoOP getEstado() {
        return estado;
    }

    public void setEstado(EstadoOP estado) {
        this.estado = estado;
    }

    public SupervisorDeLinea getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(SupervisorDeLinea supervisor) {
        this.supervisor = supervisor;
    }

    public void setEstado(int i) {
        this.estado.setEstado(i);
     }

    public LineaDeProduccion getLinea() {
        return linea;
    }

    public void setLinea(LineaDeProduccion linea) {
        this.linea = linea;
    }

    public int getHoraDeInicio() {
        return horaDeInicio;
    }

    public void setHoraDeInicio(int horaDeInicio) {
        this.horaDeInicio = horaDeInicio;
    }

    public ArrayList<HorarioParaObjetivos> getHorarioParaObjetivos() {
        return horarioParaObjetivos;
    }

    public void setHorarioParaObjetivos(HorarioParaObjetivos horarioParaObjetivos) {
        this.horarioParaObjetivos.add(horarioParaObjetivos);
    }
}
