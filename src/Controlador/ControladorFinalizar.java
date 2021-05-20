
package Controlador;

import static Controlador.ControladorGestion.registro;
import static Modelo.Datos.*;

public class ControladorFinalizar {
    
    public static void finalizarOP(){
        ocultarVistaFinalizar();
        mostrarVistaAutenticacion();
        registro.setEstado(3);
    }
}
