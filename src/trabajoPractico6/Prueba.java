package trabajoPractico6;

import interfaces.Fila;

/**
 *
 * @author Norberto
 */
public class Prueba {
    public static void main (String args[]) {
        Fila<Integer> fila = FilaListaEnlazada.crearListaVacia();
        
        fila.enFila(1);
        fila.enFila(2);
        fila.enFila(3);
        fila.enFila(4);
        fila.enFila(5);
        
        System.out.println("\nLista original: ");
        fila.mostrarFila();
        
        UsuarioADT.invertir(fila);
        System.out.println("\nLista invertida: ");
        fila.mostrarFila();
        
        UsuarioADT.invertir(fila);
        
        Fila<Integer> otraFila;
        otraFila = UsuarioADT.dividir(fila, 3);
        System.out.println("\nLista original (sin los primeros 3 elementos): ");
        fila.mostrarFila();
        System.out.println("\nLista nueva con los primeros 3 elementos de la anterior: ");
        otraFila.mostrarFila();
    }
}
