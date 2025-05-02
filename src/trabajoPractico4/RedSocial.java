/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoPractico4;

import interfaces.IRedSocial;

/**
 *
 * @author Norberto
 */
public class RedSocial implements IRedSocial {
    private Nodo primero;
    private Nodo cola;
    private int cantidad;
    
    private RedSocial() {
       this.primero = null;
       this.cola = null;
       this.cantidad = 0;
    }
    
    // crea una red social vacia
    public static RedSocial crear() {
        return new RedSocial();
    }
    
    @Override
    public RedSocial registrar(Usuario usuario) {
        Nodo aux = new Nodo(usuario);
        
        if (this.primero == null) {
            this.cola = aux;
        }
        
        aux.setSiguiente(this.primero);
        this.primero = aux;
        this.cantidad++;
        return this;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public boolean esta(Usuario usuario) {
        return estaPorNodos(this.primero, usuario);
    }
    
    private boolean estaPorNodos(Nodo aux, Usuario usuario) {
        // dos casos base
        if (aux == null) {
            return false;
        }
        
        if (aux.getUsuario().equals(usuario)) {
            return true;
        }
        
        return estaPorNodos(aux.getSiguiente(), usuario);
    }

    @Override
    public RedSocial echar(Usuario usuario) {
        Nodo actual = this.primero;
        Nodo anterior = null;
        
        while (actual != null) {
            if (actual.getUsuario().equals(usuario)) {
                // caso primero
                if (anterior == null) {
                    this.primero = actual.getSiguiente();
                    if (this.primero == null) {
                        this.cola = null;
                    }
                    actual = this.primero;
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                    
                    if (actual == this.cola) {
                        this.cola = anterior;
                    }
                    
                    actual = actual.getSiguiente();
                }
                
                this.cantidad--;
            } else {
                anterior = actual;
                actual = actual.getSiguiente();
            }
        }
        
        return this;
    }

    @Override
    public Usuario ultimoUsuario() {
        if (this.primero == null) {
            return null;
        }
        
        return this.primero.getUsuario();
    }

    @Override
    public int cantidad() {
        return this.cantidad;
    }
    
    private class Nodo {
        private Usuario usuario;
        private Nodo siguiente;
        
        public Nodo(Usuario usuario) {
            this.usuario = usuario;
            this.siguiente = null;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }
}
