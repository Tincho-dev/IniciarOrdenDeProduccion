
package Modelo;

public class EstadoOP {
    private int estado;//1 activa,2 pausada,3 finalizada
    private String denominacion;
    public EstadoOP(int estado, String denominacion) {
        this.estado = estado;
        this.denominacion = denominacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}
