/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
     * @param expresion
     * @return 
     */
    public static ArbolBinario arbolDeExpresion(String expresion) {
        ArbolBinario izquierdo;
        ArbolBinario derecho;
        Pila<ArbolBinario> pilaAux = Pila.crearPilaVacia();
        
        char[] arr = expresion.toCharArray();
        
        for (char c : arr) {
            if (c == '=') {
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
     * @param expresion
     * @return 
     */
    public static String evaluar(ArbolBinario arbolExpresion) {
        Float resultado = 0F;
        String expPosFija = arbolExpresion.posOrden();
        char[] arr = expPosFija.toCharArray();
        Pila<String> pilaAux = Pila.crearPilaVacia();
        
        String a, b;
        
        for (char c : arr) {
            if (Character.isDigit(c)) {
                pilaAux.push(String.valueOf(c));
            } else {
                b = pilaAux.top();
                pilaAux.pop();
                a = pilaAux.top();
                pilaAux.pop();
                
                switch (c) {
                    case '+':
                        resultado = Float.valueOf(a) + Float.valueOf(b);
                        break;
                    case '-':
                        resultado = Float.valueOf(a) - Float.valueOf(b);
                        break;
                    case '*':
                        resultado = Float.valueOf(a) * Float.valueOf(b);
                        break;
                    case '/':
                        resultado = Float.valueOf(a) / Float.valueOf(b);
                        break;
                }
                
                pilaAux.push(resultado.toString());
            }
        }
        
        return pilaAux.top();
    }
}
