package trabajoPractico7;

/**
 *
 * @author Norberto
 */
public class Prueba {
    public static void main(String args[]) {
        ArbolBinario raiz = ArbolBinario.aBVacio();
        ArbolBinario izquierdo = ArbolBinario.aBVacio();
        ArbolBinario derecho = ArbolBinario.aBVacio();
        
        izquierdo = ArbolBinario.armarAB(null, 'b', null);
        raiz = ArbolBinario.armarAB(izquierdo, 'a', derecho);
        
        raiz.mostrarArbol();
        
    }
}
