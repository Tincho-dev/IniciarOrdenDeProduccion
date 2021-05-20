
package Modelo;

import static java.lang.Integer.parseInt;
import java.time.LocalDateTime;

public class Fecha {//tal vez no la necesito
    private int dia;
    private int mes;
    private int año;
    
   
    public int getDia() {
       
        LocalDateTime fecha = LocalDateTime.now();
        int dia1 = parseInt(String.valueOf(fecha.getDayOfMonth()));
        return dia1;
    }

    public Fecha() {
        
    }

    public int getMes() {
         LocalDateTime fecha = LocalDateTime.now();
        int mes1 = parseInt(String.valueOf(fecha.getMonth()));
        return mes1;
    }

    public int getAño() {
         LocalDateTime fecha = LocalDateTime.now();
        int año1 = parseInt(String.valueOf(fecha.getYear()));
        return año1;
    }
   
}
