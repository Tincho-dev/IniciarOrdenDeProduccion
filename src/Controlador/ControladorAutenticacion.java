
package Controlador;

import static Modelo.Datos.*;
import Vista.VistaGestion;

public class ControladorAutenticacion {

    public static int posicionUsuario;
    public static void botonAceptar() {
        for (int i = 0; i < coleccionUsuarios.size(); i++) {
            if (coleccionUsuarios.get(i).getContraseña().equals(Vista.VistaAutenticacion.textFieldContraseña.getText())
                    && coleccionUsuarios.get(i).getUsuario().equals(Vista.VistaAutenticacion.textFieldUsuario.getText())) {
                 posicionUsuario = i;
                mostrarVistaGestion();
                String usuario = Vista.VistaAutenticacion.textFieldUsuario.getText();
                VistaGestion.jTextArea1.append(usuario);
                ocultarVistaAutenticacion();
            } else {
                System.out.println("contraseña incorrecta");
            }
        }
    }

    public static void ocultarGestion() {
        ocultarVistaAutenticacion();
    }
}
