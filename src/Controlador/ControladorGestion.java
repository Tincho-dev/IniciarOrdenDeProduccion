package Controlador;

import static Vista.VistaGestion.*;
import static Controlador.ControladorAutenticacion.*;
import Modelo.*;
import static Modelo.Datos.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

public class ControladorGestion {

    public static OrdenDeProduccion registro;

    public static void activarVista() {
        botonPausa.setVisible(false);//
        labelNombreDeUsuario.setText("Usuario:  " + jTextArea1.getText());
        labelTurno.setText("Turno: " + turno());
        ocultarTodo();
        limpiarColores();
        establecerColores();
        boolean estado;
        estado = true;
        if ("Tarde".equals(turno())) {
            int i = 14;
            establecerHora(i);
            mostrar(estado, hora);
        } else {
            int i = 6;
            establecerHora(i);
        }
        mostrar(estado, hora);
    }

    public static void botonNuevaOP() {
        //asignacion de variables que tendra el registro de la OP
        SupervisorDeLinea sup = (SupervisorDeLinea) coleccionUsuarios.get(posicionUsuario);
        String SKU = textFieldSKU.getText();
        ModeloCalzado modelo = new ModeloCalzado(SKU);
        String colorActual = String.valueOf(comboBoxColoresDelModelo.getSelectedItem());
        Color color = new Color(colorActual);      //buscar el color seleccionado
        int linea = parseInt(textFiledLineaDeProduccion.getText());
        ArrayList<Objetivo> objetivos = guardarObjetivos();

        if ("Finalizar".equals(botonIniciarOP.getText())) {

            vistaFinalizar.setVisible(true);
            botonIniciarOP.setText("Iniciar nueva OP");
            botonPausa.setVisible(false);
            textFieldSKU.setVisible(true);
            comboBoxColoresDelModelo.setVisible(true);
            ocultarGestion();

        } else {
            botonIniciarOP.setText("Finalizar");
            botonPausa.setVisible(true);
            textFieldSKU.setVisible(false);
            comboBoxColoresDelModelo.setVisible(false);
            registro = new OrdenDeProduccion(sup, hora, fecha, color, modelo, turnoActual, objetivos);
            registro.setEstado(1);
            ocultarTodo();

        }
    }

    public static void botonPausa() {

        if ("Pausar".equals(botonPausa.getText())) {//op iniciada
            botonPausa.setText("Reanudar");

            mostrar(true, hora);
            registro.setEstado(2);
            textFiledLineaDeProduccion.setVisible(false);
            labelLineaDeProduccion.setVisible(false);

        } else {//op pausada, hay que cargar los datos
            botonPausa.setText("Pausar");
            ocultarTodo();
            Color color = new Color(String.valueOf(comboBoxColoresDelModelo.getSelectedItem()));

            Objetivo objetivo[];
            objetivo = null;

            String nombre = jTextArea1.getText();
            SupervisorDeLinea supervisor = new SupervisorDeLinea(nombre);
            int horas[] = null;
            horas[1] = parseInt(jTextField2.getText());
            horas[2] = parseInt(jTextField3.getText());
            horas[3] = parseInt(jTextField4.getText());
            horas[4] = parseInt(jTextField5.getText());
            horas[5] = parseInt(jTextField6.getText());
            horas[6] = parseInt(jTextField7.getText());
            horas[7] = parseInt(jTextField8.getText());
            horas[8] = parseInt(jTextField9.getText());
            for (int i = 1; i < 9; i++) {
                objetivo[i] = new Objetivo(horas[i]);
            }
            //  int linea1 = parseInt(jTextField10.getText());

            registro.setEstado(1); //iniciada o reanudada
        }
    }

    public static void botonCerrarSesion() {
        mostrarVistaAutenticacion();
        ocultarGestion();
    }

    public static void ocultarTodo() {

        jLabel3.setVisible(false);
        jTextField2.setVisible(false);
        jLabel4.setVisible(false);
        jTextField3.setVisible(false);
        jLabel5.setVisible(false);
        jTextField4.setVisible(false);
        jLabel6.setVisible(false);
        jTextField5.setVisible(false);
        jLabel7.setVisible(false);
        jTextField6.setVisible(false);
        jLabel8.setVisible(false);
        jTextField7.setVisible(false);
        jLabel9.setVisible(false);
        jTextField8.setVisible(false);
        jLabel10.setVisible(false);
        jTextField9.setVisible(false);

    }

    public static void establecerColores() {
        limpiarColores();
        ArrayList<ModeloCalzado> calzados = establecerCalzados();
        for (int i = 0; i < calzados.size(); i++) {
            if ((textFieldSKU.getText()).equals(calzados.get(i).getSKU())) {
                for (int j = 0; j < calzados.get(i).getColoresCalzado().size(); j++) {
                    String color = calzados.get(i).getColoresCalzado().get(j).getDescripcion();
                    comboBoxColoresDelModelo.addItem(color);
                }
            }
        }
    }

    public static void limpiarColores() {
        comboBoxColoresDelModelo.removeAllItems();
    }

    public static void establecerHora(int i) {
        jLabel3.setText("Objetivo para la hora: " + i);
        i++;
        jLabel4.setText("Objetivo para la hora: " + i);
        i++;
        jLabel5.setText("Objetivo para la hora: " + i);
        i++;
        jLabel6.setText("Objetivo para la hora: " + i);
        i++;
        jLabel7.setText("Objetivo para la hora: " + i);
        i++;
        jLabel8.setText("Objetivo para la hora: " + i);
        i++;
        jLabel9.setText("Objetivo para la hora: " + i);
        i++;
        jLabel10.setText("Objetivo para la hora: " + i);
    }

    public static void mostrar(boolean estado, int hora) {
        switch (hora) {

            case 7:
                jLabel3.setVisible(estado);
                jTextField2.setVisible(estado);
                jLabel4.setVisible(estado);
                jTextField3.setVisible(estado);
                jLabel5.setVisible(estado);
                jTextField4.setVisible(estado);
                jLabel6.setVisible(estado);
                jTextField5.setVisible(estado);
                jLabel7.setVisible(estado);
                jTextField6.setVisible(estado);
                jLabel8.setVisible(estado);
                jTextField7.setVisible(estado);
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
            case 8:

                jLabel5.setVisible(estado);
                jTextField4.setVisible(estado);
                jLabel6.setVisible(estado);
                jTextField5.setVisible(estado);
                jLabel7.setVisible(estado);
                jTextField6.setVisible(estado);
                jLabel8.setVisible(estado);
                jTextField7.setVisible(estado);
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
            case 9:

                jLabel6.setVisible(estado);
                jTextField5.setVisible(estado);
                jLabel7.setVisible(estado);
                jTextField6.setVisible(estado);
                jLabel8.setVisible(estado);
                jTextField7.setVisible(estado);
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
            case 10:

                jLabel7.setVisible(estado);
                jTextField6.setVisible(estado);
                jLabel8.setVisible(estado);
                jTextField7.setVisible(estado);
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
            case 11:

                jLabel8.setVisible(estado);
                jTextField7.setVisible(estado);
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
            case 12:

                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
            case 13:

                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);

            case 14:
                jLabel3.setVisible(estado);
                jTextField2.setVisible(estado);
                jLabel4.setVisible(estado);
                jTextField3.setVisible(estado);
                jLabel5.setVisible(estado);
                jTextField4.setVisible(estado);
                jLabel6.setVisible(estado);
                jTextField5.setVisible(estado);
                jLabel7.setVisible(estado);
                jTextField6.setVisible(estado);
                jLabel8.setVisible(estado);
                jTextField7.setVisible(estado);
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);

            case 15:
                jLabel4.setVisible(estado);
                jTextField3.setVisible(estado);
                jLabel5.setVisible(estado);
                jTextField4.setVisible(estado);
                jLabel6.setVisible(estado);
                jTextField5.setVisible(estado);
                jLabel7.setVisible(estado);
                jTextField6.setVisible(estado);
                jLabel8.setVisible(estado);
                jTextField7.setVisible(estado);
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
            case 16:
                jLabel5.setVisible(estado);
                jTextField4.setVisible(estado);
                jLabel6.setVisible(estado);
                jTextField5.setVisible(estado);
                jLabel7.setVisible(estado);
                jTextField6.setVisible(estado);
                jLabel8.setVisible(estado);
                jTextField7.setVisible(estado);
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
            case 17:

                jLabel6.setVisible(estado);
                jTextField5.setVisible(estado);
                jLabel7.setVisible(estado);
                jTextField6.setVisible(estado);
                jLabel8.setVisible(estado);
                jTextField7.setVisible(estado);
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
            case 18:
                jLabel7.setVisible(estado);
                jTextField6.setVisible(estado);
                jLabel8.setVisible(estado);
                jTextField7.setVisible(estado);
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
            case 19:
                jLabel8.setVisible(estado);
                jTextField7.setVisible(estado);
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
            case 20:
                jLabel9.setVisible(estado);
                jTextField8.setVisible(estado);
                jLabel10.setVisible(estado);
                jTextField9.setVisible(estado);
        }

    }

    public static String turno() {

        String turno;
        if (turnoActual.getNroTurno() == 2) {
            turno = "Tarde";
        } else {
            turno = "Mañana";
        }
        return turno;
    }

    public static ArrayList<Objetivo> guardarObjetivos() {
        ArrayList<Objetivo> objetivos = new ArrayList();//todos los objetivos tienen 8 horas, deberia depender del turno
        objetivos.add(new Objetivo(parseInt(jTextField2.getText())));
        objetivos.add(new Objetivo(parseInt(jTextField3.getText())));
        objetivos.add(new Objetivo(parseInt(jTextField4.getText())));
        objetivos.add(new Objetivo(parseInt(jTextField5.getText())));
        objetivos.add(new Objetivo(parseInt(jTextField6.getText())));
        objetivos.add(new Objetivo(parseInt(jTextField7.getText())));
        objetivos.add(new Objetivo(parseInt(jTextField8.getText())));
        objetivos.add(new Objetivo(parseInt(jTextField9.getText())));

        return objetivos;
    }

}
