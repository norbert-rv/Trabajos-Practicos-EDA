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
    
    public static ArbolBinario armarAB(ArbolBinario izquierdo, Character raiz, ArbolBinario derecho) {
        ArbolBinario nuevoAB = ArbolBinario.aBVacio();
        
        if (raiz == null) {
            return nuevoAB;
        } else {
            nuevoAB.setRaiz(raiz);
        }
        
        if (izquierdo == null) {
            nuevoAB.izquierdo = ArbolBinario.aBVacio();
        } else {
            nuevoAB.setIzquierdo(izquierdo);
        }
        
        if (derecho == null) {
            nuevoAB.derecho = ArbolBinario.aBVacio();
        } else {
            nuevoAB.setDerecho(derecho);
        }
        
        return nuevoAB;
    }
    
    public boolean esABVacio() {
        return this.raiz == null;
    }
    
    public ArbolBinario izquierdo() {
        if (this.izquierdo == null) {
            return ArbolBinario.aBVacio();
        }
        
        return this.izquierdo;
    }
    
    public ArbolBinario derecho() {
        if (this.derecho == null) {
            return ArbolBinario.aBVacio();
        }
        
        return this.derecho;
    }
    
    /**
     * Devuelve la raiz. Si es un ABVacio devuelve null.
     * @return 
     */
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
    
    /**
     * Metodo preOrden() para obtener una expresion prefija del arbol binario.
     * @return String con la expresion.
     */
    public String preOrden() {
        StringBuilder salida = new StringBuilder();
        expPreOrden(salida);
        return salida.toString();
    }
    
    private void expPreOrden(StringBuilder salida) {
        salida.append(this.raiz());
        
        if (!this.izquierdo().esABVacio()) {
            this.izquierdo().expPreOrden(salida);
        }
            
        if (!this.derecho().esABVacio()){
            this.derecho().expPreOrden(salida);
        }
    }
    
    /**
     * Metodo enOrden() para obtener una expresion infija del arbol binario.
     * @return String con la expresion.
     */
    public String enOrden() {
        StringBuilder salida = new StringBuilder();
        expEnOrden(salida);
        return salida.toString();
    }
    
    private void expEnOrden(StringBuilder salida) {
        if (!this.izquierdo().esABVacio()) {
            this.izquierdo().expEnOrden(salida);
        }
        
        salida.append(this.raiz());
        
        if (!this.derecho().esABVacio()) {
            this.derecho().expEnOrden(salida);
        }
    }
    
    /**
     * Metodo posOrden() para obtener una expresion posfija del arbol binario.
     * @return String con la expresion.
     */
    public String posOrden() {
        StringBuilder salida = new StringBuilder();
        expPosOrden(salida);
        return salida.toString();
    }
    
    private void expPosOrden(StringBuilder salida) {
        if (!this.izquierdo().esABVacio()) {
            this.izquierdo().expPosOrden(salida);
        }
   
        if (!this.derecho().esABVacio()) {
            this.derecho().expPosOrden(salida);
        }
        
        salida.append(this.raiz());
    }

    // setters privados para usar en armarAB()
    private void setRaiz(Character raiz) {
        this.raiz = raiz;
    }

    private void setIzquierdo(ArbolBinario izquierdo) {
        this.izquierdo = izquierdo;
    }

    private void setDerecho(ArbolBinario derecho) {
        this.derecho = derecho;
    }
    
    // metodo auxiliar para mostrar el contenido del arbol
    public void mostrarArbol() {
        if (!this.esABVacio()) {
            System.out.println(this.raiz());
            this.izquierdo().mostrarArbol();
            this.derecho().mostrarArbol();
        }
    }
}
