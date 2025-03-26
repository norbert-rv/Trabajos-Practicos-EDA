package principal.controladores;

import trabajoPractico1.Agenda;
import trabajoPractico1.Contacto;

public class Punto3 {

	public static void main(String[] args) {
		// Creo una agenda
		Agenda agenda1 = Agenda.crearAgenda();
		
		// Creación de contactos
		Contacto c1 = new Contacto("Norberto", "3815566098", "norberto@gmail.com");
		Contacto c2 = new Contacto("Ernesto", "3815562348", "ernesto@gmail.com");
		Contacto c3 = new Contacto("Norberto", "3815566098", "norberto@gmail.com");
		Contacto c4 = new Contacto("Manuela", "385883398", "manuela@gmail.com");
		
		// agrego los contactos a la agenda
		System.out.println("Agrego contactos a la agenda: ");
		agenda1.agregar(c1);
		agenda1.agregar(c2);
		agenda1.agregar(c3);
		agenda1.agregar(c4);
		
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
		
		// Valor en posicion
		System.out.println("\nIntento mostrar el contacto en una posición inválida: ");
		try {
			Contacto c5 = agenda1.enPosicion(3);
			System.out.println("El contacto en la posición 3 es: " + c5.toString());
		} catch (Exception e) {
			
		}
		
		agenda1.listar();
		
		// Testeando método agregarContactosUnicos()
		
		Agenda agenda2 = Agenda.crearAgenda();
		
		// Creación de contactos
		Contacto c6 = new Contacto("Norberto", "3815566098", "norberto@gmail.com");
		Contacto c7 = new Contacto("Ernesto", "3815562348", "ernesto@gmail.com");
		Contacto c8 = new Contacto("Joaquín", "3815767098", "joaquin@gmail.com");
		Contacto c9 = new Contacto("Manuela", "385883398", "manuela@gmail.com");
				
		// agrego los contactos a la agenda
		agenda2.agregar(c6);
		agenda2.agregar(c7);
		agenda2.agregar(c8);
		agenda2.agregar(c9);
		
		System.out.println("Contactos de agenda2: ");
		agenda2.listar();
		
		System.out.println("Agregando contactos únicos de agenda2 a agenda1: ");
		System.out.println();
		System.out.println("Hay " + agenda1.cantidad() + " contactos en la agenda1.");
		System.out.println("Hay " + agenda2.cantidad() + " contactos en la agenda2.");
		agregarContactosUnicos(agenda1, agenda2);
		System.out.println("\nContactos de agenda1 luego de la combinación: ");
		agenda1.listar();
	}

	/**
	 * 
	 * Función que recibe dos objetos Agenda y agrega en la primera los contactos de 
	 * la segunda que no existen en la primera.
	 * 
	 * @param agendaObjetivo agenda que se modificará.
	 * @param agendaOrigen agenda de la que se tomarán los contactos nuevos.
	 * @return
	 */
	public static Agenda agregarContactosUnicos(Agenda agendaObjetivo, Agenda agendaOrigen) {		
		for (int i = 0; i < agendaOrigen.cantidad(); i++) {
			Contacto c = agendaOrigen.enPosicion(i + 1);
			if (agendaObjetivo.buscar(c.getNombre()) == null) {
				agendaObjetivo.agregar(c);
			}
		}
		
		return agendaObjetivo;
	}
	
}
