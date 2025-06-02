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
}
