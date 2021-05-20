
package Modelo;

public class EstadoOP {
    private int estado;//1 iniciada,2 pausada,3 finalizada

    public EstadoOP(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
