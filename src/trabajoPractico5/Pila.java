/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoPractico5;

import interfaces.IPila;

/**
 *
 * @author Norberto
 * @param <Item>
 */
public class Pila<Item> implements IPila<Item> {
    private Nodo<Item> tope;
    private Nodo<Item> fondo;
    private int cantidad;
    
    private Pila() {
        this.tope = null;
        this.fondo = null;
        this.cantidad = 0;
    }
    
    public static Pila crearPilaVacia() {
        return new Pila();
    }
    
    @Override
    public Pila push(Item i) {
        Nodo aux = new Nodo(i);
        
        if (this.tope == null) {
            this.tope = aux;
            this.fondo = aux;
        } else {
            aux.setSiguiente(this.tope);
            this.tope = aux;
        }
        
        this.cantidad++;
        return this;
    }

    @Override
    public Pila pop() {
        if (this.tope == null) {
            return this;
        }
        
        this.tope = this.tope.getSiguiente();
        if (this.tope == null) {
            this.fondo = null;
        }
        this.cantidad--;
        return this;
    }

    @Override
    public Item top() {
        if (this.tope != null) {
            return this.tope.getDato();
        } else {
            return null;
        }
    }

    @Override
    public Item fondo() {
        if (this.fondo != null) {
            return this.fondo.getDato();   
        } else {
            return null;
        }
    }
    
    private class Nodo<Item> {
        private Item dato;
        private Nodo siguiente;
        
        public Nodo(Item dato){
            this.dato = dato;
            this.siguiente = null;
        }

        public Item getDato() {
            return dato;
        }

        public void setDato(Item dato) {
            this.dato = dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }
}
