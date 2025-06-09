package trabajoPractico7;

/**
 * Implementacion del ADT Arbol Binario para tipo de dato Character.
 * @author Norberto 
 */
public class ArbolBinario {
    private Character raiz;
    private ArbolBinario izquierdo;
    private ArbolBinario derecho;
    
    /**
     * Constructora primitiva usando el patron fabric.
     * @return un arbol binario vacio.
     */
    public static ArbolBinario aBVacio() {
        return new ArbolBinario(null, null, null);
    }
    
    /**
     * Constructura de arbol binario (private).
     * @param izquierdo el subarbol izquierdo.
     * @param dato el dato de la raiz.
     * @param derecho el subarbol derecho.
     */
    private ArbolBinario(ArbolBinario izquierdo, Character dato, ArbolBinario derecho) {
        this.raiz = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
    
    /**
     * Metodo para crear un arbol binario.
     * @param izquierdo el subarbol izquierdo. Si es null se instancia un arbol vacio en izquierdo.
     * @param raiz el dato de la raiz. Si es null se instancia un arbol vacio.
     * @param derecho el subarbol derecho. Si es null se instancia un arbol vacio en derecho.
     * @return una nueva instancia de ArbolBinario.
     */
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
    
    /**
     * Metodo para saber si el arbol binario está vacío.
     * @return un valor booleano.
     */
    public boolean esABVacio() {
        return this.raiz == null;
    }
    
    /**
     * Obtener el arbol binario izquierdo.
     * @return el arbol binario izquierdo. Si izquierdo es null, retorna un arbol vacio.
     */
    public ArbolBinario izquierdo() {
        if (this.izquierdo == null) {
            return ArbolBinario.aBVacio();
        }
        
        return this.izquierdo;
    }
    
    /**
     * Obtener el arbol binario derecho.
     * @return el arbol binario derecho. Si derecho es null, retorna un arbol vacio.
     */
    public ArbolBinario derecho() {
        if (this.derecho == null) {
            return ArbolBinario.aBVacio();
        }
        
        return this.derecho;
    }
    
    /**
     * Obtener el dato almacenado en la raíz.
     * @return el dato de la raiz. Si es un arbol vacio, retorna null.
     */
    public Character raiz() {
        return this.raiz;
    }
    
    /**
     * Controlar si un caracter 'c' pertence al arbol binario. Metodo recursivo.
     * @param c el caracter a buscar.
     * @return un valor booleano.
     */
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
     * @return String con la expresion prefija.
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
     * @return String con la expresion infija.
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
     * @return String con la expresion posfija.
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
    
    // setters privados para usar en el metodo armarAB()
    private void setRaiz(Character raiz) {
        this.raiz = raiz;
    }

    private void setIzquierdo(ArbolBinario izquierdo) {
        this.izquierdo = izquierdo;
    }

    private void setDerecho(ArbolBinario derecho) {
        this.derecho = derecho;
    }
    
    /**
     * Muestra por pantalla el contenido del arbol haciendo un 
     * recorrido en preOrden.
     */
    public void mostrarArbol() {
        if (!this.esABVacio()) {
            System.out.println(this.raiz());
            this.izquierdo().mostrarArbol();
            this.derecho().mostrarArbol();
        }
    }
}
