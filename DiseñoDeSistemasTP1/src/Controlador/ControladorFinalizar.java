
package Controlador;

import static Controlador.ControladorGestion.registro;
import static Modelo.Datos.*;

public class ControladorFinalizar {
    
    public static void finalizarOP(){
        ocultarVistaFinalizar();
        ocultarVistaGestion();
        mostrarVistaAutenticacion();
        //1registro.estado.setEstado(3);
    }
}
