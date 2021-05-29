package Controlador;

import static Controlador.ControladorAutenticacion.posicionUsuario;
import static Vista.VistaGestion.*;
import static Controlador.ControladorGestion.horario;
import Modelo.*;
import static Modelo.Datos.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

public class ControladorGestion {

    public static OrdenDeProduccion registro;
    static HorarioParaObjetivos horario;

    public static void activarVista() {

        horario = cargarHorario();
        mostrarNumeroDeTurno();
        mostrarTablaObjetivos();

    }

    public static void botonNuevaOP() {

        if ("Finalizar".equals(botonIniciarOP.getText())) {
            vistaFinalizar.setVisible(true);
            botonIniciarOP.setText("Iniciar nueva OP");
            ocultarVistaGestion();
            registro.setEstado(estados.get(2));//la posicion 2 es el estado 3 que es "finalizada"

        } else {
            botonIniciarOP.setText("Finalizar");
            registro = new OrdenDeProduccion();
            registro = cargarRegistro(0,registro);//la posicion 0 es el estado 1 que es "activa"
        }
    }

    public static void botonPausa() {

        if ("Pausar".equals(botonPausa.getText())) {//op iniciada
            botonPausa.setText("Reanudar");
            registro.setEstado(estados.get(1));//la posicion 1 es el estado 2 que es "pausada"

        } else {//op pausada, hay que cargar los datos
            botonPausa.setText("Pausar");
            registro = cargarRegistro(0,registro);//la posicion 0 es el estado 1 que es "activa"
        }
    }

    public static OrdenDeProduccion cargarRegistro(int i,OrdenDeProduccion nuevaOP) {
        
        ArrayList<Objetivo> objetivos = guardarObjetivos();
        nuevaOP.setEstado(estados.get(i));
        SupervisorDeLinea supervisorActual = (SupervisorDeLinea) coleccionUsuarios.get(posicionUsuario);
        LineaDeProduccion lineaActual;
        lineaActual = establecerLinea();
        Fecha fecha = fechaActual;
        Color color = obtenerColor();
        ModeloCalzado modelo = obtenerModelo();

        try {
            horario.setTurno(turnoActual);
            horario.setObjetivo(objetivos);
            nuevaOP.setHorarioParaObjetivos(horario);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        try {
            nuevaOP.setHoraDeInicio(horaActual);
            nuevaOP.setModelo(modelo);
            nuevaOP.setColor(color);
            nuevaOP.setFecha(fecha);
            nuevaOP.setLinea(lineaActual);
            nuevaOP.setSupervisor(supervisorActual);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }

        return nuevaOP;
    }

    public static void limpiarTexto() {
        textFieldSKU.setText("SKU");
        spinnerLineaDeProduccion.setValue(0);
        tablaObjetivos.removeAll();
    }

    private static HorarioParaObjetivos cargarHorario() {
        int horaInicio = fechaActual.getHora();
        HorarioParaObjetivos inicioLaboral = new HorarioParaObjetivos();
        inicioLaboral.setFecha(fechaActual);
        inicioLaboral.setHoraDeCierre(turnoActual.getHoraFin());
        inicioLaboral.setHoraInicio(horaInicio);
        inicioLaboral.setTurno(turnoActual);
        return inicioLaboral;
    }

    public static void mostrarTablaObjetivos() {
        if (tablaObjetivos.getModel().getRowCount() == 0) {

            for (int i = horaActual; i < turnoActual.getHoraFin(); i++) {
                dtm.addRow(new Object[]{i});
            }
        }
    }

    public static void mostrarNumeroDeTurno() {
        labelTurno.setText("Turno: " + turnoActual.getNroTurno());
    }

    public static ModeloCalzado obtenerModelo() {
        ModeloCalzado modelo;
        modelo = null;
        for (int i = 0; i < coleccionModelos.size(); i++) {
            if (coleccionModelos.get(i).getSKU() == null ? textFieldSKU.getText() == null : coleccionModelos.get(i).getSKU().equals(textFieldSKU.getText())) {
                modelo = coleccionModelos.get(i);
            }
        }
        return modelo;
    }

    public static Color obtenerColor() {
        Color color;
        color = null;
        String color1 = (String) comboBoxColoresDelModelo.getSelectedItem();
        for (int i = 0; i < coleccionModelos.size(); i++) {
            if ((textFieldSKU.getText()).equals(coleccionModelos.get(i).getSKU())) {
                for (int j = 0; j < coleccionModelos.get(i).getColoresCalzado().size(); j++) {
                    if (color1 == null ? coleccionModelos.get(i).getColoresCalzado().get(j).getDescripcion() == null : color1.equals(coleccionModelos.get(i).getColoresCalzado().get(j).getDescripcion())) {
                        color = coleccionModelos.get(i).getColoresCalzado().get(j);
                    }
                }
            }
        }
        return color;
    }

    public static void botonCerrarSesion() {
        mostrarVistaAutenticacion();
        ocultarVistaGestion();
    }

    public static void establecerColores() {
        limpiarColores();
        for (int i = 0; i < coleccionModelos.size(); i++) {
            if ((textFieldSKU.getText()).equals(coleccionModelos.get(i).getSKU())) {
                for (int j = 0; j < coleccionModelos.get(i).getColoresCalzado().size(); j++) {
                    String color = coleccionModelos.get(i).getColoresCalzado().get(j).getDescripcion();
                    comboBoxColoresDelModelo.addItem(color);
                }
            }
        }
    }

    public static LineaDeProduccion establecerLinea() {
        LineaDeProduccion lineaActual = null;
        for (int i = 0; i < coleccionLineas.size(); i++) {
            if ((spinnerLineaDeProduccion.getValue()).equals(coleccionLineas.get(i).getNumero())) {
                lineaActual = coleccionLineas.get(i);
            }
        }
        return lineaActual;
    }

    public static void limpiarColores() {
        comboBoxColoresDelModelo.removeAllItems();
    }

    public static ArrayList<Objetivo> guardarObjetivos() {
        ArrayList<Objetivo> objetivos = new ArrayList();
        int n = dtm.getRowCount();
        for (int i = 0; i < n; i++) {
            if (dtm.getValueAt(i, 1) != null) {
                String nuevoObjetivo;
                nuevoObjetivo = (String) dtm.getValueAt(i, 1);
                int horaDeObjetivo = horaActual + i;
                objetivos.add(new Objetivo(parseInt(nuevoObjetivo), horaDeObjetivo));
            }
        }
        return objetivos;
    }
}
