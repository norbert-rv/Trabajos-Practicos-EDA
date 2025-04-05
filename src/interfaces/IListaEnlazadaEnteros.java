package interfaces;

import trabajoPractico1.ListaEnlazada;

public interface IListaEnlazadaEnteros {
	
	public boolean esVacia();
	public ListaEnlazada insertarAlInicio(int x);
	public ListaEnlazada insertarAlFinal(int x);
	public void mostrar();
	public int cantidad();
	public int primerElemento() throws Exception;
	public ListaEnlazada borrarPrimero();
	public ListaEnlazada borrarUltimo();
	public boolean pertenece(int buscado);
	public ListaEnlazada borrarConValor(int buscado);
	public int valorEnPosicion(int posicion) throws Exception;
	public ListaEnlazada modificarValorEnPosicion(int valor, int posicion);
	public ListaEnlazada insertarEnPosicion(int valor, int posicion);
        
        // TP3
        public int mayor();

	public static final String ERROR_LISTA_VACIA = "No se puede obtener el primer elemento. La lista está vacía.";
	public static final String ERROR_POSICION = "No se puede buscar el valor en la posición porque la lista está vacía o no existe un elemento en la posición ingresada.";
}
