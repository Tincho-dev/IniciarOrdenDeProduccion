 
package Modelo;

import java.util.*;
import Vista.*;
import static java.lang.Integer.parseInt;
import java.time.LocalDateTime;

public class Datos {
    
    public static VistaAutenticacion vistaAutenticacion = new VistaAutenticacion();
    public static VistaGestion vistaGestion = new VistaGestion();
    public static VistaFinalizar vistaFinalizar = new VistaFinalizar();
    public static int horaActual = hora();
    public static Fecha fecha = new Fecha();
    
    //arrays: 
    public static ArrayList<ModeloCalzado> coleccionModelos = establecerCalzados();
    public static ArrayList<ArrayList<Color>> coleccionColeccionColores;
    public static ArrayList<Turno> coleccionTurnos = establecerTurnos();
    public static ArrayList<LineaDeProduccion> coleccionLineaDeProduccion = establecerLineas();
    public static ArrayList<Usuario> coleccionUsuarios = establecerUsuarios();

    public static Turno turnoActual = calcularTurnoActual();
    
    public static void mostrarVistaAutenticacion(){
    
    vistaAutenticacion.setVisible(true);
    }
    public static void ocultarVistaAutenticacion(){
    
    vistaAutenticacion.setVisible(false);
    }
    
    public static void mostrarVistaGestion(){
    
    vistaGestion.setVisible(true);
    }
    public static void ocultarVistaGestion(){
    
    vistaGestion.setVisible(false);
    }
    
    public static void mostrarVistaFinalizar(){
    
    vistaFinalizar.setVisible(true);
    }
    public static void ocultarVistaFinalizar(){
    
    vistaFinalizar.setVisible(false);
    }
    
    public static ArrayList<Usuario> establecerUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario("usuario", "admin");
        Usuario usuario2 = new Usuario("Carlos Alonzo", "1234");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        return usuarios;
    }
 public static ArrayList<Turno> establecerTurnos() {
        ArrayList<Turno> turnos = new ArrayList<>();
        Turno turno1 = new Turno(1, 6, 14);
        Turno turno2 = new Turno(2, 14, 22);
        turnos.add(turno1);
        turnos.add(turno2);
        return turnos;
    }

    public static ArrayList<Color> establecerColor(ArrayList<Color> coloresActuales,String colorNuevo) {

        Color colorAux = new Color(colorNuevo);
        coloresActuales.add(colorAux);

        return coloresActuales;
    }
   
    public static ArrayList<ModeloCalzado> establecerCalzados() {
        ArrayList<ModeloCalzado> calzados = new ArrayList<>();
        ArrayList<Color> coleccionColores1 = new ArrayList<>();
        ArrayList<Color> coleccionColores2 = new ArrayList<>();
        
        coleccionColores1 = establecerColor(coleccionColores1,"naranja");
        coleccionColores1 = establecerColor(coleccionColores1,"rojo carmeci");
        coleccionColores1 = establecerColor(coleccionColores1,"azul marino");
        coleccionColores1 = establecerColor(coleccionColores1,"rojo");
        
        coleccionColores2 = establecerColor(coleccionColores2,"verde");
        coleccionColores2 = establecerColor(coleccionColores2,"marron");
        coleccionColores2 = establecerColor(coleccionColores2,"celeste");
        
        ModeloCalzado calzado1 = new ModeloCalzado("123a", coleccionColores1);
        ModeloCalzado calzado2 = new ModeloCalzado("456a", coleccionColores2);
        calzados.add(calzado1);
        calzados.add(calzado2);
        
        return calzados;
    }
    
    
    
    public static ArrayList<LineaDeProduccion> establecerLineas()
    {
    ArrayList<LineaDeProduccion> lineaDeProduccion = new ArrayList<>();
    
    return lineaDeProduccion;
    }
    
     public static int hora() {
        LocalDateTime fecha = LocalDateTime.now();
        int hora = parseInt(String.valueOf(fecha.getHour()));

        return hora;
    }

    public static Turno calcularTurnoActual() {
        Turno turnoActualCalculo = null;
        if (horaActual >= coleccionTurnos.get(1).getHoraFin() && horaActual <= coleccionTurnos.get(2).getHoraFin()) {
            turnoActualCalculo = coleccionTurnos.get(2);
        } else {
            if (horaActual >= coleccionTurnos.get(1).getHoraInicio() && horaActual <= coleccionTurnos.get(1).getHoraFin()) {
                turnoActualCalculo = coleccionTurnos.get(1);
            } else {
                System.out.println("Fuera de horario laboral");
            }
        }
             return turnoActualCalculo;
   }

}
