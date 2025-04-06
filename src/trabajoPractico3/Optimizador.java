package trabajoPractico3;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author norberto
 */
public class Optimizador {
    
    /*
    SPOILER ALERT: creo que no se puede resolver este problema con la técnica Greedy
    pero igual lo hago.
    */
    public List seleccionarTareas(List<Tarea> tareas) {
        List auxTareas = new ArrayList<Tarea>();
        Collections.copy(tareas, auxTareas);
        Collections.sort(auxTareas, (Tarea t1, Tarea t2) -> Double.compare(t1.getPagoXHora(), t2.getPagoXHora()));   // ordeno la lista según pago por hora
        
        List solucion = new ArrayList<Tarea>();     // conjunto solución
        int cantHorasMaxima = 40;                   // condición de factibilidad
        int cantHorasAcumuladas = 0;
        int i = 0;                                  // indice para recorrer la lista
        Tarea elemento;
        
        while (cantHorasAcumuladas <= cantHorasMaxima) {
            elemento = (Tarea) auxTareas.get(i);
            auxTareas.remove(i);
            i++;
            
            // si es factible entonces lo sumo al conjunto solución
            if (cantHorasAcumuladas + elemento.getTiempo() <= cantHorasMaxima) {
                solucion.add(elemento);
                cantHorasAcumuladas += elemento.getTiempo();
            }
        }
        
        return solucion;
    }
    
}
