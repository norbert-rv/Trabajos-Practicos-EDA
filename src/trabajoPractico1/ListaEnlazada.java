package trabajoPractico1;

import interfaces.IListaEnlazada;

public class ListaEnlazada implements IListaEnlazada{
	
	public static ListaEnlazada crearLista() {
		return new ListaEnlazada();
	}

	@Override
	public boolean esVacia() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ListaEnlazada insertarAlInicio(int x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListaEnlazada insertarAlFinal(int x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int cantidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int primerElemento() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListaEnlazada borrarPrimero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListaEnlazada borrarUltimo() {
		// TODO Auto-generated method stub
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
	
}
