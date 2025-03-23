package interfaces;

import trabajoPractico1.ListaEnlazadaContactos;
import trabajoPractico1.Contacto;

public interface IListaEnlazadaContactos {
	public boolean esVacia();
	public ListaEnlazadaContactos insertarAlInicio(Contacto c);
	public ListaEnlazadaContactos insertarAlFinal(Contacto c);
	public void mostrar();
	public int cantidad();
	public Contacto primerElemento() throws Exception;
	public ListaEnlazadaContactos borrarPrimero();
	public ListaEnlazadaContactos borrarUltimo();
	public boolean pertenece(Contacto buscado);
	public ListaEnlazadaContactos borrarConValor(Contacto buscado);
	public Contacto valorEnPosicion(int posicion) throws Exception;
	public ListaEnlazadaContactos modificarValorEnPosicion(Contacto valor, int posicion);
	public ListaEnlazadaContactos insertarEnPosicion(Contacto valor, int posicion);
	
	// método nuevo
	public Contacto buscarValorPorNombre(String nombre);

	public static final String ERROR_LISTA_VACIA = "No se puede obtener el primer elemento. La lista está vacía.";
	public static final String ERROR_POSICION = "No se puede buscar el valor en la posición porque la lista está vacía o no existe un elemento en la posición ingresada.";
}
