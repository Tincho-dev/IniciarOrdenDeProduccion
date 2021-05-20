
package Modelo;


public class Turno {
    private int nroTurno;
    private int horaInicio;
    private int horaFin;

    public Turno(int nroTurno, int horaInicio, int horaFin) {
        this.nroTurno = nroTurno;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getNroTurno() {
        return nroTurno;
    }

    public void setNroTurno(int nroTurno) {
        this.nroTurno = nroTurno;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }
}
