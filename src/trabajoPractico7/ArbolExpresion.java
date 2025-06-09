package trabajoPractico7;

import trabajoPractico5.Pila;

/**
 * 
 * @author Norberto
 */
public class ArbolExpresion {
    /**
     * Este metodo funciona con expresiones posfijas. Falta implementar para que
     * convierta cualquier expresion a posfija antes de evaluar.
     * @param expresion String con la expresion posfija bien formada.
     * @return un arbol binario de expresion.
     */
    public static ArbolBinario arbolDeExpresion(String expresion) {
        /*
        *   Funcionamiento: convierto el String de entrada en un arreglo; lo
        *   recorro y, usando una pila, voy armando el arbol de expresion.
        */
        ArbolBinario izquierdo;
        ArbolBinario derecho;
        Pila<ArbolBinario> pilaAux = Pila.crearPilaVacia();
        
        char[] arr = expresion.toCharArray();
        
        for (char c : arr) {
            if (c == '=') {     // si la expresion esta bien formada no hace falta
                break;
            }
            
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                derecho = pilaAux.top();
                pilaAux.pop();
                izquierdo = pilaAux.top();
                pilaAux.pop();
                pilaAux.push(ArbolBinario.armarAB(izquierdo, c, derecho));
            } else {
                pilaAux.push(ArbolBinario.armarAB(null, c, null));
            }
        }
        
        return pilaAux.top();
    }
    
    /**
     * Evalua un arbol de expresion y retorna un String con el resultado.
     * @param arbolExpresion un arbol binario de expresion.
     * @return String con el resultado.
     */
    public static String evaluar(ArbolBinario arbolExpresion) {
        /*
        *   Funcionamiento: obtengo un String con la expresion del arbol de
        *   expresion de entrada; lo convierto a un arreglo; lo recorro y luego,
        *   usando una pila, voy evaluando la expresion trabajando con Strings.
        */
        Float resultado = 0F;
        String expPosFija = arbolExpresion.posOrden();
        char[] arr = expPosFija.toCharArray();
        Pila<String> pilaAux = Pila.crearPilaVacia();
        
        String a, b;
        
        for (char c : arr) {
            if (Character.isDigit(c)) {  // si es un digito, lo agrego a la pila
                pilaAux.push(String.valueOf(c));
            } else {  // si no es un digito, evaluo la expresion parcial
                b = pilaAux.top();
                pilaAux.pop();
                a = pilaAux.top();
                pilaAux.pop();
                
                resultado = switch (c) {
                    case '+' -> Float.valueOf(a) + Float.valueOf(b);
                    case '-' -> Float.valueOf(a) - Float.valueOf(b);
                    case '*' -> Float.valueOf(a) * Float.valueOf(b);
                    case '/' -> Float.valueOf(a) / Float.valueOf(b);
                    default -> 0F;
                };
                
                pilaAux.push(resultado.toString());
            }
        }
        
        return pilaAux.top();
    }
}
