package Modelo;

import java.util.ArrayList;

public class OrdenDeProduccion{
    
    private SupervisorDeLinea supervisor;
    private int horario;//hora de inicio de la OP
    private Fecha fecha;
    private Color color;
    private ModeloCalzado modelo;
    private Turno turno;
    private EstadoOP estado;
    private ArrayList<Objetivo> objetivo;//cambiar por la nueva clase
    private HorarioParaObjetivos horarioParaObjetivos;

    public OrdenDeProduccion(SupervisorDeLinea supervisor, int horario, Fecha fecha, Color color, ModeloCalzado modelo, Turno turno, ArrayList<Objetivo> objetivos) {
        this.supervisor = supervisor;
        this.horario = horario;
        this.fecha = fecha;
        this.color = color;
        this.modelo = modelo;
        this.turno = turno;
        this.objetivo = objetivos;
        this.horarioParaObjetivos = new HorarioParaObjetivos();
    }


    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
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

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
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

    public HorarioParaObjetivos getHorarioParaObjetivos() {
        return horarioParaObjetivos;
    }

    public void setHorarioParaObjetivos(HorarioParaObjetivos horarioParaObjetivos) {
        this.horarioParaObjetivos = horarioParaObjetivos;
    }

    public ArrayList<Objetivo> getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(ArrayList<Objetivo> objetivo) {
        this.objetivo = objetivo;
    }

    public void setEstado(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
