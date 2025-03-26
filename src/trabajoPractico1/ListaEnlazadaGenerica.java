package trabajoPractico1;

import interfaces.IListaEnlazadaGenerica;

public class ListaEnlazadaGenerica<T> implements IListaEnlazadaGenerica<T> {
	
	private Nodo primero;	// primer nodo de la lista
	private Nodo cola;		// variable que apunta al último nodo
	private int cantidad;	// tamaño de la lista enlazada (cantidad de nodos)
	
	private ListaEnlazadaGenerica() {
		this.primero = null;
		this.cola = null;
		this.cantidad = 0;
	};
	
	// El tipo de dato tiene que ser especificado al momento de llamar al método estatico.
	public static <U> ListaEnlazadaGenerica<U> crearLista() {
		return new ListaEnlazadaGenerica<>();
	}
	
	@Override
	public boolean esVacia() {
		return primero == null;
	}

	@Override
	public ListaEnlazadaGenerica<T> insertarAlInicio(T x) {
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
	public ListaEnlazadaGenerica<T> insertarAlFinal(T x) {
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
			System.out.println(" -> " + aux.getDato().toString());
			aux = aux.getSiguiente();
		}
		
		System.out.println();
	}

	@Override
	public int cantidad() {
		return this.cantidad;
	}

	@Override
	public T primerElemento() throws Exception {
		if (this.primero == null) {
			throw new Exception(ERROR_LISTA_VACIA);
		}
		return this.primero.getDato();
	}

	@Override
	public ListaEnlazadaGenerica<T> borrarPrimero() {
		if (this.primero == null) {
			return this;
		}
		
		this.primero = this.primero.getSiguiente();
		this.cantidad--;
		return this;
	}

	@Override
	public ListaEnlazadaGenerica<T> borrarUltimo() {
		if (this.primero == null) {
			return this;
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
	public boolean pertenece(T buscado) {
		Nodo aux = this.primero;
		
		while(aux != null) {
			if (aux.getDato().equals(buscado)) {
				return true;
			}
			
			aux = aux.getSiguiente();
		}
		
		return false;
	}

	@Override
	public ListaEnlazadaGenerica<T> borrarConValor(T buscado) {
		/* 
			Primer ensayo: recorro la lista y a medida que voy encontrando coincidencias
			empiezo a reasignar las referencias a los nodos. Y vuelvo a seguir buscando desde el nuevo
			nodo que ahora ocupa el lugar del que se eliminó por hallar una coincidencia.
		*/
		
		if (this.primero == null) {
			return this;
		}
		
		Nodo aux = this.primero;	// para recorrer la lista
		Nodo aux2 = null;			// siempre está una posición por detrás de aux
		Nodo aux3 = null;

		while(aux != null) {
			if (aux.getDato().equals(buscado)) {
				if (aux2 == null) {
					this.borrarPrimero();
				} else if (aux.getSiguiente() == null) {
					this.borrarUltimo();
				} else {
					aux3 = aux.getSiguiente();
					while(aux3 != null) {
						aux2.setSiguiente(aux3);
						aux2 = aux3;
						aux3 = aux3.getSiguiente();
					}
					this.cantidad--;
				}
			}

			aux2 = aux;
			aux = aux.getSiguiente();
		}

		return this;
	}

	@Override
	public T valorEnPosicion (int posicion) throws Exception {
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
	public ListaEnlazadaGenerica<T> modificarValorEnPosicion(T valor, int posicion) {
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
	public ListaEnlazadaGenerica<T> insertarEnPosicion(T valor, int posicion) {
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
	private class Nodo{
		private T dato;
		private Nodo siguiente;
		
		public Nodo(T x) {
			this.dato = x;
			this.siguiente = null;
		}
		
		public T getDato() {
			return dato;
		}
		public void setDato(T dato) {
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
