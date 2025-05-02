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
        Nodo aux = this.primero;
        
        if (this.primero == null) {
            return false;
        }
        
        while (aux != null) {
            if (aux.getUsuario().equals(usuario)) {
                return true;
            }
            
            aux = aux.getSiguiente();
        }
        
        return false;
    }

    @Override
    public RedSocial echar(Usuario usuario) {
        /*Nodo aux = this.primero;
        
        while (aux != null) {
            if (aux.getUsuario().equals(usuario)) {
                if (this.primero )
            }
            
            aux = aux.getSiguiente();
        }
        */
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
