 
package Modelo;

import static Controlador.ControladorGestion.limpiarTexto;
import java.util.*;
import Vista.*;
import static Vista.VistaGestion.tablaObjetivos;
import static java.lang.Integer.parseInt;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;

public class Datos {
    
    public static ArrayList<ModeloCalzado> coleccionModelos;
    public static ArrayList<Turno> coleccionTurnos;
    public static ArrayList<LineaDeProduccion> coleccionLineas;
    public static ArrayList<SupervisorDeLinea> coleccionUsuarios;
    public static ArrayList<EstadoOP> estados;
    
    public static Turno turnoActual;
    public static int horaActual;
    public static Fecha fechaActual;
    
    public static VistaAutenticacion vistaAutenticacion = new VistaAutenticacion();
    public static VistaGestion vistaGestion = new VistaGestion();
    public static VistaFinalizar vistaFinalizar = new VistaFinalizar();
    public static DefaultTableModel dtm;
    
    public static void cargarDatos() {

        fechaActual = new Fecha();
        coleccionModelos = establecerCalzados();
        coleccionTurnos = establecerTurnos();
        coleccionLineas = establecerLineas();
        coleccionUsuarios = establecerUsuarios();
        horaActual = fechaActual.getHora();
        turnoActual = calcularTurnoActual();
        estados = establecerEstados();
        modelarTablaObjetivos();
    }
    public static ArrayList<EstadoOP> establecerEstados(){
        ArrayList<EstadoOP> estados1 = new ArrayList<>();
        
            estados1.add(new EstadoOP(1,"Activa"));
            estados1.add(new EstadoOP(2,"Pausada"));
            estados1.add(new EstadoOP(3,"Finalizada"));
        
    return estados1;
    }
    public static void modelarTablaObjetivos(){
        dtm = new DefaultTableModel();
        String[] titulo = new String[]{"Hora","Objetivo"};
        dtm.setColumnIdentifiers(titulo);
        tablaObjetivos.setModel(dtm);
    
    
    } 
    public static void mostrarVistaAutenticacion(){
    vistaAutenticacion.setVisible(true);
    }
    public static void ocultarVistaAutenticacion(){
    vistaAutenticacion.setVisible(false);
    }
    public static void mostrarVistaGestion(){
        limpiarTexto();
        vistaGestion.setVisible(true);
    
    }
    public static void ocultarVistaGestion(){
    vistaGestion.setVisible(false);
    //poner en blanco los campos
    }
    public static void mostrarVistaFinalizar(){
    vistaFinalizar.setVisible(true);
    }
    public static void ocultarVistaFinalizar(){
    vistaFinalizar.setVisible(false);
    }
    
    public static ArrayList<SupervisorDeLinea> establecerUsuarios() {
        ArrayList<SupervisorDeLinea> usuarios = new ArrayList<>();
        SupervisorDeLinea usuario1 = new SupervisorDeLinea("usuario", "admin");
        SupervisorDeLinea usuario2 = new SupervisorDeLinea("Carlos Alonzo", "1234");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        return usuarios;
    }
 public static ArrayList<Turno> establecerTurnos() {
        ArrayList<Turno> turnos = new ArrayList<>();
        Turno turno1 = new Turno(1, 8, 16);
        Turno turno2 = new Turno(2, 16, 24);
        Turno turno3 = new Turno(3,00,8);
        turnos.add(turno1);
        turnos.add(turno2);
        turnos.add(turno3);
       
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
        int cantidadLineas;
        cantidadLineas = 100;
        for (int i = 0; i < cantidadLineas; i++) {
            lineaDeProduccion.add(new LineaDeProduccion(i+1));
        }
        
        return lineaDeProduccion;
    }

     public static int hora() {
        LocalDateTime fecha = LocalDateTime.now();
        int hora = parseInt(String.valueOf(fecha.getHour()));

        return hora;
    }

    public static Turno calcularTurnoActual() {
        Turno turnoActualCalculo = null;
        for (int i = 0; i < coleccionTurnos.size(); i++) {
            if(horaActual>= coleccionTurnos.get(i).getHoraInicio() && horaActual<coleccionTurnos.get(i).getHoraFin())
            {
            turnoActualCalculo = coleccionTurnos.get(i);
            }
        }
        if(turnoActualCalculo == null)
        {
        System.out.println("hay un problema para calcular el turno");
        turnoActualCalculo = new Turno(0,horaActual,horaActual+1);
        }
        return turnoActualCalculo;
    }

    
}
