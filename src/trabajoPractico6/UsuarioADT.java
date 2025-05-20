package trabajoPractico6;

import interfaces.Fila;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Norberto
 */
public class UsuarioADT {
    /**
     * Invierte el orden de la fila
     * @param fila
     * @return this
     */
    public static Fila invertir(Fila fila) {
        Object[] arr = fila.toArray();
        List arrList = Arrays.asList(arr);
        Collections.reverse(arrList);
        arr = arrList.toArray();
        fila.limpiar();
        fila.fromArray(arr);
        return fila;
    }
    
    /**
     * Dada una fila y una cantidad de elementos, crea una nueva Fila con
     * los n primeros elementos de la fila original y elimina los mismos de
     * la original.
     * @param fila
     * @param cantidad
     * @return la nueva fila de los n primeros elementos de la original
     */
    public static Fila dividir(Fila fila, int cantidad) {
        Fila nueva = FilaListaEnlazada.crearListaVacia();
        
        for (int i = 0; i < cantidad; i++) {
            if (!fila.esFilaVacia()) {
                nueva.enFila(fila.frente());
                fila.deFila();
            } else {
                break;
            }
        }
        
        return nueva;
    }
}
