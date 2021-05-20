
package Modelo;

import static Controlador.ControladorGestion.*;
import static Modelo.Datos.turnoActual;

public class HorarioParaObjetivos {
    int horaInicio= hora();
    int horaDeCierre = turnoActual.getHoraFin();
    Fecha fecha;

    public HorarioParaObjetivos() {
    }
    
    
}
