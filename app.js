class Empleado {
    constructor(dni){
        this.dni=dni;
    }
}

class Usuario extends Empleado{
    constructor(dni,nombre,contraseña){
        super(dni);
        this.usuario = nombre;
        this.contraseña = contraseña;
    }
}

class Sesion {
    obtenerEmpleado(){
        return `El usuario es: ${usuarioActual.usuario}`;//codigo de ejemplo, en realidad debe devolver un objeto empleado
    }
}

class Linea{
    constructor(numero){
        this.numero=numero;
    }
}

class OrdenDeProduccion{
    constructor(numero,horadeInicio,fechaDeInicio){
        this.numero=numero;
        this.horadeInicio=horadeInicio;
        this.fechaDeInicio=fechaDeInicio;
    }
    obtenerUltimaJornada(){}
}
class EstadoOP{}//enum

class ControladorAsociarSupervisoraOP{
    supervisorLibre(Empleado){}
    asociarSupervisor(Empleado,nroLinea){}
    abandonarSupervisor(Empleado,nroLinea){}
}

class ControladorAutenticarUsuario{
    obtenerUsuario(usuario){}
    validar(contraseña){}
}

class Repositorio{
    supervisorLibre(Empleado){}
    actualizar(OrdenDeProduccion){}
}

class IniciarOPControlador{
    asignarModelo(modelo){};
    asociarDatos(color,jornada,Linea){}
}

class Modelo{
    constructor(sku,denominacion){
        this.sku=sku;
        this.denominacion=denominacion;
    }
}

class Color{
    constructor(codigoColor,descripcion){
        this.codigoColor=codigoColor;
        this.descripcion=descripcion;
    }
}

class JornadaLaboral{
    constructor(horaDeApertura,horaDeCierre,fecha){
        this.horaDeApertura=horaDeApertura;
        this.horaDeCierre=horaDeCierre;
        this.fecha=fecha;
    }
    crear(_objetivos){}
    crear(hora,cantidad){}
    crear(hora,cantidad,defecto,pie){}
    guardar(hallazgo){}
}

class Objetivo {
    constructor(cantidadDe1ra){
        this.cantidadDe1ra=cantidadDe1ra;
    }
}

class Turno{
    constructor(nroTurno,horaInicio,horaFin){
        this.nroTurno=nroTurno;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }
}

class Hallazgo{
    constructor(hora,cantidad){
        this.hora=hora;
        this.cantidad=cantidad;
    }
}

class Defecto{
    constructor(tipo,pie,totalPorPie,acumulado,horaDeRegistro,fechaDeRegistro){
        this.tipo=tipo;
        this.pie=pie;
        this.totalPorPie=totalPorPie;
        this.acumulado=acumulado;
        this.horaDeRegistro=horaDeRegistro;
        this.fechaDeRegistro=fechaDeRegistro;
    }
}

class InspeccionarCalzadoControlador{
    registrarParDePrimera(hora,cantidad){}
    registrarDefecto(hora,cantidad,defecto,pie){}
    actualizar(OrdenDeProduccion){}
    obtenerTotalPrimera(hora){}
    obtenerTotalDefectos(hora){}
}
//INICIAR ORDEN DE PRODUCCION
function iniciarOP(){//donde van los metodos de inicio de los diagrams de colaboracion?
    iniciarOPControlador = new IniciarOPControlador();
    emp = Sesion.obtenerEmpleado();
    OPActual = new OrdenDeProduccion(emp);
}

function seleccionarModelo(numeroop,modelo){
    op = Repositorio.obtenerOP(numeroop);
    modeloActual = Repositorio.buscar(modelo);
    colores = modeloActual.obtenerColores();
    op.asignarModelo(modeloActual);
}

function confirmar(numeroop,linea,color,_objetivos){
    jornada = new JornadaLaboral(_objetivos,turnoActual);
    lineaActual = Repositorio.buscarLinea(linea);
    colorActual = Repositorio.buscarColor(color);
    turnoActual = Repositorio.buscarTurno();//busca el turno despues de usarlo jaja
    op = Repositorio.obtenerOP(numeroop);
    op.asociarDatos(colorActual,jornada,lineaActual,numero);//numero deberia ser numeroop
}

// INSPECCIONAR CALZADO

function iniciarInispeccion(numeroop){
    inspeccionarCalzadoControlador = new InspeccionarCalzadoControlador();
    op = Repositorio.buscarOP(numeroop);
} //buscamos la op para mostrar los datos en la vista

function registrarParDePrimera(numeroop,hora,cantidad){
    Repositorio.obtenerOP(numeroop);//no lo estamos guardando en ningun lado
    jornada = op.obtenerUltimaJornada();//en el DC aparece como j:=obtenerJornada()
    jornada.registrarParDePrimera(hora,cantidad);
    Repositorio.actualizarOP(op);
}

function registrarDefecto(numeroop,hora,cantidad,pie,defecto){
    Repositorio.obtenerOP(numeroop);//no lo estamos guardando en ningun lado
    d = Repositorio.buscarDefecto(defecto);
    jornada = op.obtenerUltimaJornada();//en el DC aparece como j:=obtenerJornada()
    jornada.registrarParDefecto(hora,cantidad,defecto,pie);//en el DC aparece como registrarParDePrimera en vez de registrarDefecto
    //deberia mandarle d en vez de defecto
    Repositorio.actualizarOP(op);
}

function cambiarHora(hora){
    op = Repositorio.buscarOP();//ni siquiera le mando el numero
    totalPrimera = obtenerTotalPrimera(hora);
    totalDefectos = obtenerTotalDefectos(hora);
}

// GESTIONAR MODELOS

function obtenerColores(){
    gestionarModelosControlador = new GestionarModelosControlador();//nos olvidamos de ponerlo en el DCS
    _colores = Repositorio.obtenerColores();
}

function confirmarModelo(_colores,sku,denom){
    modelo = new Modelo(_colores,sku,denom);
    Repositorio.guardar(modelo);
}

// AUTENTICAR USUARIO

function autenticarUsuario(usuario,contraseña){
    u = Repositorio.obtenerUsuario(usuario);
    if(u){
        v = u.validar(contraseña);
    }
    if(v){
        sesionActual = new Sesion(u);
    }
}

// ASOCIAR ORDEN DE PRODUCCION

function buscarLineasDisponibles(){
    controladorAsociarSupervisoraOP = new ControladorAsociarSupervisoraOP();
    _lineas = Repositorio.obtenerLineas();//buscamos op activa sin supervisor
}

function confirmarAsociacion(numeroLinea){
    v = Repositorio.obtenerLineas(numeroLinea);//no usamos esta validacion
    op = Repositorio.obtenerOP(numeroLinea);
    emp = sesionActual.obtenerEmpleado();
    s = Repositorio.supervisorLibre(emp);//usamos la misma variable de verificacion v
    //en el DC esta tres veces el 4:(v:sup...,s:sup...,[v&&s])
    if(v&&s){
        op.asociarSupervisor(emp,numeroLinea);
    }
}

// DESASOCIAR ORDEN DE PRODUCCION

function abandonarOP(numeroLinea){
    v = Repositorio.obtenerLineas(numeroLinea);
    op = Repositorio.obtenerOP(numeroLinea);
    emp = sesionActual.obtenerEmpleado();
    if(v){
        op.abandonarSupervisor(emp,numeroLinea);
    }
}
