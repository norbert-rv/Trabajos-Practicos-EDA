/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoPractico5;

/**
 *
 * @author Norberto
 */
public class Pruebas {
    public static void main(String args[]) {
        Pila<String> pila1 = Pila.crearPilaVacia();
        
        pila1.push("Hola Mundo!");
        pila1.push("Segundo string");
        pila1.push("Tercer String que deberia quedar en el tope.");
        
        System.out.println("Tope: " + pila1.top());
        System.out.println("Fondo: " + pila1.fondo());
        
        pila1.pop();
        // Ahora el deberia mostrar "Segundo string"
        System.out.println("Tope despues del pop: " + pila1.top());
    }
}
