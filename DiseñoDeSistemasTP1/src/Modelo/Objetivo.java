
package Modelo;

public class Objetivo {
    
    private int cantDe1ra;
    private int hora;

    public Objetivo(int cantDe1ra, int hora) {
        this.cantDe1ra = cantDe1ra;
        this.hora = hora;
    }
    
    public int getCantDe1ra() {
        return cantDe1ra;
    }

    public void setCantDe1ra(int cantDe1ra) {
        this.cantDe1ra = cantDe1ra;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
}
    