package trabajoPractico1;

import interfaces.IListaEnlazadaEnteros;

public class ListaEnlazada implements IListaEnlazadaEnteros{
	
	private Nodo primero;	// primer nodo de la lista
	private Nodo cola;		// variable que apunta al último nodo
	private int cantidad;	// tamaño de la lista enlazada (cantidad de nodos)
	
	private ListaEnlazada() {
		this.primero = null;
		this.cola = null;
		this.cantidad = 0;
	}
	
	public static ListaEnlazada crearLista() {
		return new ListaEnlazada();
	}
	
	@Override
	public boolean esVacia() {
		return primero == null;
	}

	@Override
	public ListaEnlazada insertarAlInicio(int x) {
		Nodo aux = new Nodo(x);
		
		if (this.primero == null) {
			this.cola = aux;
		}
		
		aux.setSiguiente(this.primero);
		this.primero = aux;
		this.cantidad++;
		return this;
	}

	@Override
	public ListaEnlazada insertarAlFinal(int x) {
		Nodo aux = new Nodo(x);
		
		if (this.primero == null) {
			this.primero = aux;
			this.cola = aux;
		} else {
			this.cola.setSiguiente(aux);
			this.cola = aux;
		}
		
		this.cantidad++;
		return this;
	}

	@Override
	public void mostrar() {
		if (this.primero == null) {
			return;
		}
		
		Nodo aux;
		aux = this.primero;
		System.out.println();
		
		while(aux != null) {
			System.out.print(aux.getDato());
			aux = aux.getSiguiente();
			
			if (aux != null) {				// luego de mostrar el último no coloca flecha
				System.out.print(" -> ");
			}
			
		}
		
		System.out.println();
	}

	@Override
	public int cantidad() {
		return this.cantidad;
	}

	@Override
	public int primerElemento() throws Exception {
		if (this.primero == null) {
			throw new Exception(ERROR_LISTA_VACIA);
		}
		return this.primero.getDato();
	}

	@Override
	public ListaEnlazada borrarPrimero() {
		if (this.primero == null) {
			return this;
		}
		
		this.primero = this.primero.getSiguiente();
		this.cantidad--;
		return this;
	}

	@Override
	public ListaEnlazada borrarUltimo() {
		if (this.primero == null) {
			return this;
		} else if (this.primero == this.cola) {
			this.primero = null;
			this.cola = null;
		}
		
		Nodo aux;
		aux = this.primero;
		
		while(aux.getSiguiente().getSiguiente() != null) {
			aux = aux.getSiguiente();
		}
		
		aux.setSiguiente(null);
		this.cola = aux;
		this.cantidad--;
		return this;
	}

	@Override
	public boolean pertenece(int buscado) {
		Nodo aux = this.primero;
		
		while(aux != null) {
			if (aux.getDato() == buscado) {
				return true;
			}
			
			aux = aux.getSiguiente();
		}
		
		return false;
	}

	@Override
	public ListaEnlazada borrarConValor(int buscado) {
		/* 
			Primer ensayo: recorro la lista y a medida que voy encontrando coincidencias
			reasigno las referencias a los nodos. Y vuelvo a seguir buscando desde el nuevo
			nodo que ahora ocupa el lugar del que se eliminó por hallar una coincidencia.
		*/
		
		if (this.primero == null) {
			return this;
		}
		
		Nodo aux = this.primero;	// para recorrer la lista
		Nodo aux2 = null;		// siempre está una posición por detrás de aux

		while(aux != null) {
			if (aux.getDato() == buscado) {
				if (aux2 == null) {
					this.borrarPrimero();
                                        aux = this.primero;
                                        continue;
				} else if (aux.getSiguiente() == null) {
					this.borrarUltimo();
				} else {
					aux2.setSiguiente(aux.getSiguiente());
					this.cantidad--;
				}
			} else {
                            aux2 = aux;
                        }
                        
			aux = aux.getSiguiente();
		}

		return this;
	}

	@Override
	public int valorEnPosicion (int posicion) throws Exception {
		Nodo aux = this.primero;
		
		if (aux == null || posicion > this.cantidad() || posicion <= 0) {
			throw new Exception(ERROR_POSICION); 
		}
		
		for (int i = 1; i < posicion; i++) {
			aux = aux.getSiguiente();
		}
		
		return aux.getDato();
	}

	@Override
	public ListaEnlazada modificarValorEnPosicion(int valor, int posicion) {
		if (posicion <= 0 || posicion > this.cantidad()) {
			return this;
		}
		
		Nodo aux = this.primero;
		
		for (int i = 1; i < posicion; i++) {		// Me ubico en el nodo en la posicion ingresada
			aux = aux.getSiguiente();
		}
		
		aux.setDato(valor);
		
		return this;
	}

	@Override
	public ListaEnlazada insertarEnPosicion(int valor, int posicion) {
		Nodo aux = this.primero;
		Nodo nuevo = new Nodo(valor);
		
		if (posicion <= 0 || posicion > this.cantidad()) {
			return this;
		}
		
		for (int i = 1; i < posicion - 1; i++) {		// Me ubico en la posición anterior a la ingresada
			aux = aux.getSiguiente();
		}
		
		nuevo.setSiguiente(aux.getSiguiente());
		aux.setSiguiente(nuevo);
		this.cantidad++;
		return this;
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
