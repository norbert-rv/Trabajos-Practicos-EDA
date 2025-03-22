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
		return primero == null;
	}

	@Override
	public ListaEnlazada insertarAlInicio(int x) {
		Nodo aux = new Nodo(x);
		
		if(this.primero == null) {
			this.cola = aux;
		}
		
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
		return this;
	}

	@Override
	public void mostrar() {
		Nodo aux;
		aux = this.primero;
		
		while(aux != null) {
			System.out.print(aux.getDato());
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
		if(this.primero == null) {
			return this;
		}
		
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
		return this;
	}

	@Override
	public ListaEnlazada borrarUltimo() {
		if(this.primero == null) {
			return this;
		}
		
		Nodo aux;
		aux = this.primero;		// puntero en el primer nodo
		
		// Me muevo hasta el anteúltimo nodo. Empiezo en 1 porque ya me situé en el primer nodo
		for(int i = 1; i < this.cantidad() - 1; i++) {
			aux = aux.getSiguiente();
		}
		
		aux.setSiguiente(null);
		tamanio--;
		return this;
	}

	@Override
	public boolean pertenece(int buscado) {
		Nodo aux = this.primero;
		
		while(aux != null) {
			if(aux.getDato() == buscado) {
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
			empiezo a reasignar las referencias a los nodos. Y vuelvo a seguir buscando desde el nuevo
			nodo que ahora ocupa el lugar del que se eliminó por hallar una coincidencia.
		*/
		
		Nodo aux = this.primero;
		Nodo anterior = aux;		// se inicializa en el primer elemento
		Nodo aux2;
		
		while(aux.getSiguiente() != null) {
			
			if(aux.getDato() == buscado) {
				aux = aux.getSiguiente();
				aux2 = aux;
				
				while(aux2.getSiguiente() != null) {
					anterior.setSiguiente(aux2);
					
					anterior = aux2;
					aux2 = aux2.getSiguiente();
				}
			}
			
			anterior = aux;				// guardo el nodo de tal manera que queda guardado el anterior correspondiente la siguiente iteración
			aux = aux.getSiguiente();
		}
		
		// Verificación del último elemento
		if(aux.getDato() == buscado) {
			this.borrarUltimo();
		}
		
		return this;
	}

	@Override
	public int valorEnPosicion (int posicion) throws Exception {
		Nodo aux = this.primero;
		
		if(aux == null || posicion > tamanio || posicion <= 0) {
			throw new Exception("No se puede buscar el valor en la posición porque la lista está vacía o no existe un elemento en la posición ingresada."); 
		}
		
		for(int i = 1; i < posicion; i++) {
			aux = aux.getSiguiente();
		}
		
		return aux.getDato();
	}

	@Override
	public ListaEnlazada modificarValorEnPosicion(int valor, int posicion) {
		Nodo aux = this.primero;
		
		for(int i = 1; i < posicion; i++) {		// Me ubico en el nodo en la posicion ingresada
			aux = aux.getSiguiente();
		}
		
		aux.setDato(valor);
		
		return this;
	}

	@Override
	public ListaEnlazada insertarEnPosicion(int valor, int posicion) {
		Nodo aux = this.primero;
		Nodo nuevo = new Nodo(valor);
		
		for(int i = 1; i < posicion - 1; i++) {		// Me ubico en la posición anterior a la ingresada
			aux = aux.getSiguiente();
		}
		
		nuevo.setSiguiente(aux.getSiguiente());
		aux.setSiguiente(nuevo);
		tamanio++;
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
