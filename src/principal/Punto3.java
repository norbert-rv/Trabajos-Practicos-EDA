package principal;

import trabajoPractico1.Agenda;
import trabajoPractico1.Contacto;
import trabajoPractico1.ListaEnlazadaContactos;

public class Punto3 {

	public static void main(String[] args) {
		Agenda agenda1 = Agenda.crearAgenda();	// creo una agenda
		
		// Creación de contactos
		Contacto c1 = new Contacto("Norberto", "3815566098", "norberto.rodriguezvaquero@gmail.com");
		Contacto c2 = new Contacto("Ernesto", "3815562348", "ernesto@gmail.com");
		Contacto c3 = new Contacto("Norberto", "3815566098", "norberto.rodriguezvaquero@gmail.com");
		
		// agrego los contactos a la agenda
		agenda1.agregar(c1);
		agenda1.agregar(c2);
		agenda1.agregar(c3);
		
		agenda1.listar();

		
	}
	
	public Agenda combinarAgendas(Agenda agendaOrigen, Agenda agendaObjetivo) {
		ListaEnlazadaContactos listaOrigen = agendaOrigen.getListaAgenda();
		ListaEnlazadaContactos listaObjetivo = agendaObjetivo.getListaAgenda();
		
		
		
		return null;
	}

}
