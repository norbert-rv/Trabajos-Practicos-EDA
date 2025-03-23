package trabajoPractico1;

import interfaces.IListaEnlazadaContactos;

public class ListaEnlazadaContactos implements IListaEnlazadaContactos {
	private Nodo primero;	// primer nodo de la lista
	private Nodo cola;		// variable que apunta al último nodo
	private int cantidad;	// tamaño de la lista enlazada (cantidad de nodos)
	
	private ListaEnlazadaContactos() {
		this.primero = null;
		this.cola = null;
		this.cantidad = 0;
	};
	
	public static ListaEnlazadaContactos crearLista() {
		return new ListaEnlazadaContactos();
	}
	
	@Override
	public boolean esVacia() {
		return primero == null;
	}

	@Override
	public ListaEnlazadaContactos insertarAlInicio(Contacto c) {
		Nodo aux = new Nodo(c);
		
		if (this.primero == null) {
			this.cola = aux;
		}
		
		aux.setSiguiente(this.primero);
		this.primero = aux;
		this.cantidad++;
		return this;
	}

	@Override
	public ListaEnlazadaContactos insertarAlFinal(Contacto c) {
		Nodo aux = new Nodo(c);
		
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
			System.out.println(" -> " + aux.getContacto().toString());
			aux = aux.getSiguiente();
		}
		
		System.out.println();
	}

	@Override
	public int cantidad() {
		return this.cantidad;
	}

	@Override
	public Contacto primerElemento() throws Exception {
		if (this.primero == null) {
			throw new Exception(ERROR_LISTA_VACIA);
		}
		return this.primero.getContacto();
	}

	@Override
	public ListaEnlazadaContactos borrarPrimero() {
		if (this.primero == null) {
			return this;
		}
		
		this.primero = this.primero.getSiguiente();
		this.cantidad--;
		return this;
	}

	@Override
	public ListaEnlazadaContactos borrarUltimo() {
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
	public boolean pertenece(Contacto buscado) {
		Nodo aux = this.primero;
		
		while(aux != null) {
			if (aux.getContacto().equals(buscado)) {
				return true;
			}
			
			aux = aux.getSiguiente();
		}
		
		return false;
	}

	@Override
	public ListaEnlazadaContactos borrarConValor(Contacto buscado) {
		/* 
			Debe borrar la primera coincidencia con el valor dado.
		*/
		
		if (this.primero == null) {
			return this;
		}
			
		// nueva implementación
		Nodo aux = this.primero;	// para recorrer la lista
		Nodo aux2 = null;			// siempre está una posición por detrás de aux
		Nodo aux3 = null;

		while(aux != null) {
			if (aux.getContacto().getTelefono().equals(buscado.getTelefono())) {
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
				return this;
			}

			aux2 = aux;
			aux = aux.getSiguiente();
		}

		return this;
	}

	@Override
	public Contacto valorEnPosicion (int posicion) throws Exception {
		Nodo aux = this.primero;
		
		if (aux == null || posicion > this.cantidad() || posicion <= 0) {
			throw new Exception(ERROR_POSICION); 
		}
		
		for (int i = 1; i < posicion; i++) {
			aux = aux.getSiguiente();
		}
		
		return aux.getContacto();
	}

	@Override
	public ListaEnlazadaContactos modificarValorEnPosicion(Contacto valor, int posicion) {
		if (posicion <= 0 || posicion > this.cantidad()) {
			return this;
		}
		
		Nodo aux = this.primero;
		
		for (int i = 1; i < posicion; i++) {		// Me ubico en el nodo en la posicion ingresada
			aux = aux.getSiguiente();
		}
		
		aux.setContacto(valor);
		
		return this;
	}

	@Override
	public ListaEnlazadaContactos insertarEnPosicion(Contacto valor, int posicion) {
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
	
	public Contacto buscarValorPorNombre(String nombre) {
		Nodo aux;
		aux = this.primero;
		
		while(aux != null) {
			if (aux.getContacto().getNombre().equalsIgnoreCase(nombre)) {
				return aux.getContacto();
			}
			
			aux = aux.getSiguiente();
		}
		
		return null;	// Si no existe devuelve null.
	}
	
	private class Nodo {

		private Contacto c;
		private Nodo siguiente;
		
		public Nodo(Contacto c) {
			this.c = c;
			this.siguiente = null;
		}
		
		public Contacto getContacto() {
			return this.c;
		}
		public void setContacto(Contacto c) {
			this.c = c;
		}
		public Nodo getSiguiente() {
			return siguiente;
		}
		public void setSiguiente(Nodo siguiente) {
			this.siguiente = siguiente;
		}
		
	}
}
