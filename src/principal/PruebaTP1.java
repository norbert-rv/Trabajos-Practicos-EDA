package principal;

import trabajoPractico1.ListaEnlazada;

public class PruebaTP1 {

	public static void main(String[] args) {
		
		/*
		 * Primero pruebo armar una lista nueva y mostrarla por pantalla.
		 */
		
		ListaEnlazada lista1 = ListaEnlazada.crearLista();
		ListaEnlazada lista2 = ListaEnlazada.crearLista();
		
		System.out.println("La lista está vacía: " + lista1.esVacia());
		
		System.out.println("\nInserto elementos al inicio (en orden 1 3 1 6 56 1 4): \n");
		lista1.insertarAlInicio(1);
		lista1.insertarAlInicio(3);
		lista1.insertarAlInicio(1);
		lista1.insertarAlInicio(6);
		lista1.insertarAlInicio(56);
		lista1.insertarAlInicio(1);
		lista1.insertarAlInicio(4);
		
		lista1.mostrar();
		lista2.mostrar();
		
		System.out.println("\n\nInserto 9 al final y 15 al inicio: \n");
		lista1.insertarAlFinal(9);
		lista1.insertarAlInicio(15);

		lista1.mostrar();
		
		// Pruebo métodos con print
		System.out.println("\n\nLa lista tiene " + lista1.cantidad() + " elementos.\n");
		
		System.out.println("La lista está vacía: " + lista1.esVacia());
		
		try {
			System.out.println("\nEl primer elemento es: " + lista1.primerElemento());
			System.out.println();
			System.out.println("\nEl primer elemento es: " + lista2.primerElemento());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		// Borrar primero
		System.out.println("\nBorrar primero:");
		lista1.borrarPrimero();
		
		lista1.mostrar();
		
		// Borrar último
		System.out.println("\nBorrar último:");
		lista1.borrarUltimo();
		
		lista1.mostrar();
		
		// Pertenece
		System.out.println("\nEl número 56 pertenece a la lista: " + lista1.pertenece(56));
		
		// Borrar con valor
		System.out.println("\nBorrar con valor 1:");
		lista2.borrarConValor(1);
		lista1.mostrar();
		
		System.out.println("\nBorrar con valor 56:");
		lista1.borrarConValor(56);
		lista1.mostrar();
		
		// Valor en posicion
		try {
			System.out.println("\nEl valor en la posición 2 es: " + lista1.valorEnPosicion(2));
			
			System.out.println("\nIntento buscar un elemento en la posición 4... ");
			System.out.println("\nLa lista tiene " + lista1.cantidad() + " elementos.");
			System.out.println("\nEl valor en la posición 4 es: " + lista1.valorEnPosicion(4));
		} catch (Exception e) {
			System.out.println("\n" + e.getMessage() + "\n");
		}
		
		// Modificar valor en posición
		System.out.println("Modifico valor en la posición 2 (nuevo valor 78): ");
		lista1.modificarValorEnPosicion(78, 2);
		lista1.mostrar();
		
		System.out.println("\nModifico valor en la posición 6 (nuevo valor 78): ");
		lista1.modificarValorEnPosicion(78, 6);
		lista1.mostrar();
		
		System.out.println("\nModifico valor en la posición 1 (nuevo valor 8): ");
		lista1.modificarValorEnPosicion(8, 1);
		lista1.mostrar();
		
		// Insertar valor en posición
		System.out.println("\nInserto valor en la posición 3 (8): ");
		lista1.insertarEnPosicion(8, 3);
		lista1.mostrar();
		
	}

}
