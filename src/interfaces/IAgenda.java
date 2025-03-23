package interfaces;

import trabajoPractico1.Agenda;
import trabajoPractico1.ListaEnlazadaContactos;
import trabajoPractico1.Contacto;

public interface IAgenda {
	
	/**
	 * 
	 * Agrega un contacto a la agenda.
	 * 
	 * @param c dato de tipo Contacto.
	 * @return el objeto de la agenda.
	 */
	public Agenda agregar(Contacto c);
	
	/**
	 * 
	 * Buscar el primer contacto con el nombre recibido por parámetro y devuelve el
	 * Contacto. Si no existe devuelve NULL.
	 * 
	 * @param nombre
	 * @return
	 */
	public Contacto buscar(String nombre);
	
	/**
	 * 
	 * Elimina el primer contacto con telefono igual al recibido por parámetro.
	 * 
	 * @param telefono
	 * @return
	 */
	public ListaEnlazadaContactos borrar(String telefono);
	
	/**
	 * 
	 * Muestra por pantalla los datos de todos los contactos de la agenda.
	 * 
	 */
	public void listar();
	
	/**
	 * 
	 * Devuelve la cantidad de contactos en la agenda.
	 * 
	 * @return
	 */
	public int cantidad();
	
	/**
	 * 
	 * Devuelve el contacto en la posición 'posicion'.
	 * 
	 * @param posicion
	 * @return
	 */
	
	public Contacto enPosicion(int posicion) throws Exception;
	
	public static final String ERROR_POSICION = "No se puede buscar el valor en la posición porque la lista está vacía o no existe un elemento en la posición ingresada.";
}
