
package Modelo;

import static Modelo.Datos.*;
import java.util.ArrayList;

public class HorarioParaObjetivos {
    private int horaInicio;
    private int horaDeCierre;
    private Fecha fecha;
    private Turno turno;
    private ArrayList<Objetivo> objetivo;

    public HorarioParaObjetivos() {
//        fecha = fechaActual;
//        horaDeCierre = turno.getHoraFin();
//        horaInicio = horaActual;
//        turno = calcularTurnoActual();
    }

     public ArrayList<Objetivo> getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(ArrayList<Objetivo> objetivo) {
        this.objetivo = objetivo;
    }
    
    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraDeCierre() {
        return horaDeCierre;
    }

    public void setHoraDeCierre(int horaDeCierre) {
        this.horaDeCierre = horaDeCierre;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
}
