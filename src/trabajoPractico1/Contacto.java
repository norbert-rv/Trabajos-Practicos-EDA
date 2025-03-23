package trabajoPractico1;

import java.util.Objects;

public class Contacto {
	private String nombre;
	private String telefono;
	private String email;
	
	public Contacto(String nombre, String telefono, String email) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
	
//	public void mostrar() {
//		System.out.println("(" + this.nombre + ", " + this.telefono + ", " + this.email + ")");
//	}
	
	@Override
	public String toString() {
		String out = "(" + this.nombre + ", " + this.telefono + ", " + this.email + ")";
		return out;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Contacto other = (Contacto) obj;
		return this.email.equalsIgnoreCase(other.email) || this.telefono.equalsIgnoreCase(other.telefono);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
