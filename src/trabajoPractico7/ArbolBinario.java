package trabajoPractico7;

/**
 *
 * @author Norberto
 * @param <Item> 
 */
public class ArbolBinario {
    private Character raiz;
    private ArbolBinario izquierdo;
    private ArbolBinario derecho;
    
    public static ArbolBinario aBVacio() {
        return new ArbolBinario(null, null, null);
    }
    
    private ArbolBinario(ArbolBinario izquierdo, Character dato, ArbolBinario derecho) {
        this.raiz = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
    
    public static ArbolBinario armarAB(ArbolBinario izquierdo, Character dato, ArbolBinario derecho) {
        return new ArbolBinario(izquierdo, dato, derecho);
    }
    
    public boolean esABVacio() {
        return this.raiz == null;
    }
    
    public ArbolBinario izquierdo() {
        if (this.izquierdo == null) {
            return ArbolBinario.armarAB(null, null, null);
        }
        
        return this.izquierdo;
    }
    
    public ArbolBinario derecho() {
        if (this.derecho == null) {
            return ArbolBinario.armarAB(null, null, null);
        }
        
        return this.derecho;
    }
    
    public Character raiz() {
        return this.raiz;
    }
    
    public boolean pertenece(Character c) {
        // caso base 1
        if (this.esABVacio()) {
            return false;
        }
        // caso base 2
        if (this.raiz().equals(c)) {
            return true;
        }
        
        return this.izquierdo().pertenece(c) || this.derecho().pertenece(c);
    }
}
