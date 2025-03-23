package principal;

import trabajoPractico1.Agenda;
import trabajoPractico1.Contacto;

public class Punto3 {

	public static void main(String[] args) {
		// Creo una agenda
		Agenda agenda1 = Agenda.crearAgenda();
		
		// Creación de contactos
		Contacto c1 = new Contacto("Norberto", "3815566098", "norberto.rodriguezvaquero@gmail.com");
		Contacto c2 = new Contacto("Ernesto", "3815562348", "ernesto@gmail.com");
		Contacto c3 = new Contacto("Norberto", "3815566098", "norberto.rodriguezvaquero@gmail.com");
		
		// agrego los contactos a la agenda
		System.out.println("Agrego contactos a la agenda: ");
		agenda1.agregar(c1);
		agenda1.agregar(c2);
		agenda1.agregar(c3);
		
		agenda1.listar();

		// Buscar por nombre
		System.out.println("Buscar contacto por nombre 'Ernesto': ");
		System.out.println("\n" + agenda1.buscar("Ernesto"));
		
		System.out.println("\nContactos en la agenda: ");
		agenda1.listar();
		System.out.println("Hay " + agenda1.cantidad() + " contactos en la agenda.");
		
		// Borrar por número de teléfono
		System.out.println("\nBorrar contacto por el número de teléfono (3815566098): ");
		agenda1.borrar("3815566098");
		agenda1.listar();
		System.out.println("Hay " + agenda1.cantidad() + " contactos en la agenda.");
		
		System.out.println("\nBorrar contacto por el número de teléfono (3815562348): ");
		agenda1.borrar("3815562348");
		agenda1.listar();
		System.out.println("Hay " + agenda1.cantidad() + " contactos en la agenda.");
		
	}
	
//	public Agenda combinarAgendas(Agenda agendaOrigen, Agenda agendaObjetivo) {
//		ListaEnlazadaContactos listaOrigen = agendaOrigen.getListaAgenda();
//		ListaEnlazadaContactos listaObjetivo = agendaObjetivo.getListaAgenda();
//		
//		
//		
//		return null;
//	}

}
