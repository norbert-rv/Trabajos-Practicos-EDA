/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoPractico5.navegador;

import trabajoPractico5.Pila;
/**
 *
 * @author Norberto
 */
public class Navegador implements INavegador{
    private Pila<Integer> adelante;
    private Pila<Integer> atras;
    private Integer actual;
    
    private Navegador() {
        this.adelante = Pila.crearPilaVacia();
        this.atras = Pila.crearPilaVacia();
        this.actual = 0;
    }
    
    public static Navegador iniciarNavegador() {
        return new Navegador();
    }
    
    @Override
    public void navegar(int url) {
        if (this.actual != null) {                  // no hay ninguna url cargada
            this.atras.push(this.actual);           // la url se va a la pila de atras
            this.adelante = Pila.crearPilaVacia();  // se vacia la pila de adelante
        }
        this.actual = url;
    }

    @Override
    public int atras() {
        if (this.actual != null && this.atras.top() != null) {
            this.adelante.push(this.actual);
            this.actual = this.atras.top();
            this.atras.pop();
        }
        return this.actual;
    }

    @Override
    public int adelante() {
        if(this.actual != null && this.adelante.top() != null) {
            this.atras.push(this.actual);
            this.actual = this.adelante.top();
            this.adelante.pop();
        }
        
        return this.actual;
    }
    
}
