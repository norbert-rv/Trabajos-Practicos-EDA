package trabajoPractico1;

import interfaces.IAgenda;

public class Agenda implements IAgenda {
	private ListaEnlazadaContactos listaAgenda = ListaEnlazadaContactos.crearLista();
	
	private Agenda() {
		
	}
	
	public static Agenda crearAgenda() {
		Agenda agenda = new Agenda();
		return agenda;
	}
	
	public Agenda agregar(Contacto c) {
		this.listaAgenda.insertarAlFinal(c);
		return this;
	}

	public Contacto buscar(String nombre) {
		return this.listaAgenda.buscarValorPorNombre(nombre);
	}

	public ListaEnlazadaContactos borrar(String telefono) {
		Contacto c = new Contacto(null, telefono, null);
		return this.listaAgenda.borrarConValor(c);
	}

	public void listar() {
		this.listaAgenda.mostrar();
	}
	
	public int cantidad() {
		return this.listaAgenda.cantidad();
	}
	
	public Contacto enPosicion(int posicion) {
		Contacto c = null;
		
		try {
			c = this.listaAgenda.valorEnPosicion(posicion);
		} catch (Exception e) {
			System.out.println();
			System.out.println(e.getMessage());
		}
		
		return c;
	}

	public ListaEnlazadaContactos getListaAgenda() {
		return listaAgenda;
	}

	public void setListaAgenda(ListaEnlazadaContactos listaAgenda) {
		this.listaAgenda = listaAgenda;
	}
	
}
