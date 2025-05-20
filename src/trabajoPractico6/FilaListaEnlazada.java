package trabajoPractico6;

import interfaces.Fila;

/**
 * ADT Fila implemented using Singly Linked List
 * @author Norberto
 * @param <Item>
 */
public class FilaListaEnlazada<Item> implements Fila<Item> {
    private Nodo frenteLista;
    private Nodo finalLista;
    private Integer cantidad;
    
    private FilaListaEnlazada() {
        this.frenteLista = null;
        this.finalLista = null;
        this.cantidad = 0;
    }
    
    public static FilaListaEnlazada crearListaVacia() {
        return new FilaListaEnlazada();
    }
    
    @Override
    public boolean esFilaVacia() {
        return this.cantidad == 0;
    }

    /**
     * Returns the first element on the List. If the List is empty, it returns null.
     * @return 
     */
    @Override
    public Item frente() {
        if (!this.esFilaVacia()) {
            return this.frenteLista.getItem();
        } else {
            return null;
        }
    }

    @Override
    public Fila enFila(Item i) {
        Nodo nuevo = new Nodo(i);
        
        if (this.esFilaVacia()) {
            this.frenteLista = nuevo;
            this.finalLista = nuevo;
        } else {
            this.finalLista.setSiguiente(nuevo);
            this.finalLista = nuevo;
        }
        
        this.cantidad++;
        return this;
    }

    @Override
    public Fila deFila() {
        if (!this.esFilaVacia()) {
            this.frenteLista = this.frenteLista.getSiguiente();
            this.cantidad--;
        }
        
        return this;
    }

    @Override
    public Fila enFilaN(Item item, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            this.enFila(item);
            this.cantidad++;
        }
        
        return this;
    }

    @Override
    public Fila reenfilar() {
        if (this.cantidad() > 1) {
            this.enFila(this.frente()); 
            return this.deFila();
        }
        
        return this;
    }
    
    @Override
    public int cantidad() {
        return this.cantidad;
    }

    @Override
    public Fila borrar(Item item) {
        Nodo actual = this.frenteLista;
        Nodo anterior = null;
        
        while (actual != null) {
            if (actual.getItem().equals(item)) {
                if (anterior == null) {
                    this.frenteLista = this.frenteLista.getSiguiente();
                    actual = this.frenteLista;
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                    actual = actual.getSiguiente();
                    
                    if (actual == null) {
                        this.finalLista = anterior;
                    }
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
    public Item[] toArray() {
        Item[] arr = (Item[]) new Object[this.cantidad()];
        int i = 0;
        Nodo aux = this.frenteLista;
        
        while (aux != null) {
            arr[i] = aux.getItem();
            i++;
            aux = aux.getSiguiente();
        }
        
        return arr;
    }
    
    @Override
    public Fila fromArray(Item[] arr) {
        for (Item i : arr) {
            this.enFila(i);
        }
        return this;
    }

    @Override
    public Fila merge(Fila fila) {
        Fila aux = fila.copiar();
        
        while (!aux.esFilaVacia()) {
            this.enFila((Item)aux.frente());
            aux.deFila();
        }
        
        return this;
    }

    @Override
    public Fila copiar() {
        Fila copia = FilaListaEnlazada.crearListaVacia();
        
        Nodo aux = this.frenteLista;
        
        while (aux != null) {
            copia.enFila(aux.getItem());
        }
        
        return copia;
    }

    @Override
    public Fila limpiar() {
        this.frenteLista = null;
        this.finalLista = null;
        this.cantidad = 0;
        
        return this;
    }
    
    private class Nodo {
        private Item item;
        private Nodo siguiente;

        public Nodo(Item item) {
            this.item = item;
            this.siguiente = null;
        }
        
        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
        
    }
}
