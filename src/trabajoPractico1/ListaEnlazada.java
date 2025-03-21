package trabajoPractico1;

import interfaces.IListaEnlazadaEnteros;

public class ListaEnlazada implements IListaEnlazadaEnteros{
	
	private Nodo primero;	// primer nodo de la lista
	private Nodo cola;		// variable que apunta al último nodo
	private int tamanio;	// tamaño de la lista enlazada (cantidad de nodos)
	
	private ListaEnlazada() {
		this.primero = null;
		this.cola = null;
		this.tamanio = 0;
	};
	
	public static ListaEnlazada crearLista() {
		return new ListaEnlazada();
	}
	
	@Override
	public boolean esVacia() {
		return primero == null; // ver si es posible que haya lugares salteados
	}

	@Override
	public ListaEnlazada insertarAlInicio(int x) {
		Nodo aux = new Nodo(x);
		aux.setSiguiente(this.primero);
		this.primero = aux;
		tamanio++;
		return this;
	}

	@Override
	public ListaEnlazada insertarAlFinal(int x) {
		Nodo aux = new Nodo(x);
		
		if(this.primero == null) {
			this.primero = aux;
			this.cola = aux;
		} else {
			this.cola.setSiguiente(aux);
			this.cola = aux;
		}
		
		tamanio++;
		return null;
	}

	@Override
	public void mostrar() {
		Nodo aux;
		aux = this.primero;
		
		while(aux != null) {
			System.out.println(aux.getDato());
			aux = aux.getSiguiente();
			
			if(aux != null) {				// luego de mostrar el último no coloca flecha
				System.out.print(" -> ");
			}
			
		}
	}

	@Override
	public int cantidad() {
		return tamanio;
	}

	@Override
	public int primerElemento() {
		return this.primero.getDato();
	}

	@Override
	public ListaEnlazada borrarPrimero() {
		Nodo aux1, aux2;
		aux1 = this.primero;					// tomo el primer nodo con aux1
		aux2 = this.primero.getSiguiente();		// tomo el segundo nodo con aux2
		
		// caso 0
		this.primero = aux2;
		aux2 = aux2.getSiguiente();
		
		while(aux1 != null) {
			aux1.setSiguiente(aux2);
			aux1 = aux2;
			aux2 = aux2.getSiguiente();
		}
		
		tamanio--;
		return null;
	}

	@Override
	public ListaEnlazada borrarUltimo() {
		return null;
	}

	@Override
	public boolean pertenece(int buscado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ListaEnlazada borrarConValor(int buscado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int valorEnPosicion(int posicion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListaEnlazada modificarValorEnPosicion(int valor, int posicion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListaEnlazada insertarEnPosicion(int valor, int posicion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class Nodo {

		private int dato;
		private Nodo siguiente;
		
		public Nodo(int x) {
			this.dato = x;
			this.siguiente = null;
		}
		
		public int getDato() {
			return dato;
		}
		public void setDato(int dato) {
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
