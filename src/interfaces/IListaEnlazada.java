package interfaces;

import trabajoPractico1.ListaEnlazada;

public interface IListaEnlazada {
	
	public boolean esVacia();
	public ListaEnlazada insertarAlInicio(int x);
	public ListaEnlazada insertarAlFinal(int x);
	public void mostrar();
	public int cantidad();
	public int primerElemento();
	public ListaEnlazada borrarPrimero();
	public ListaEnlazada borrarUltimo();
	public boolean pertenece(int buscado);
	public ListaEnlazada borrarConValor(int buscado);
	public int valorEnPosicion(int posicion);
	public ListaEnlazada modificarValorEnPosicion(int valor, int posicion);
	public ListaEnlazada insertarEnPosicion(int valor, int posicion);

}
