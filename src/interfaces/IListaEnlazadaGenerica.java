package interfaces;

import trabajoPractico1.ListaEnlazadaGenerica;

public interface IListaEnlazadaGenerica<T> {
	public boolean esVacia();
	public ListaEnlazadaGenerica<T> insertarAlInicio(T x);
	public ListaEnlazadaGenerica<T> insertarAlFinal(T x);
	public void mostrar();
	public int cantidad();
	public T primerElemento() throws Exception;
	public ListaEnlazadaGenerica<T> borrarPrimero();
	public ListaEnlazadaGenerica<T> borrarUltimo();
	public boolean pertenece(T buscado);
	public ListaEnlazadaGenerica<T> borrarConValor(T buscado);
	public T valorEnPosicion(int posicion) throws Exception;
	public ListaEnlazadaGenerica<T> modificarValorEnPosicion(T valor, int posicion);
	public ListaEnlazadaGenerica<T> insertarEnPosicion(T valor, int posicion);

	public static final String ERROR_LISTA_VACIA = "No se puede obtener el primer elemento. La lista está vacía.";
	public static final String ERROR_POSICION = "No se puede buscar el valor en la posición porque la lista está vacía o no existe un elemento en la posición ingresada.";
}
