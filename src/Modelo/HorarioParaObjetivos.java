
package Modelo;

import static Modelo.Datos.*;

public class HorarioParaObjetivos {
    int horaInicio= hora;
    int horaDeCierre = turnoActual.getHoraFin();
    Fecha fechaActual = fecha;

    public HorarioParaObjetivos() {
    }
}
