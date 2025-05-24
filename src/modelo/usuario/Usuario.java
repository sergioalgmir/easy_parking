package modelo.usuario;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class Usuario {

//		Atributos
	protected String dni;
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected String email;
	protected long telefono;
	protected String contraseña;

//		Constructores

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String dni, String nombre, String apellido1, String apellido2, String email, long telefono,
			String contraseña) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.telefono = telefono;
		this.contraseña = contraseña;

	}

//	Getters & Setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

//	equals & hashCode
	@Override
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido1, other.apellido1) && Objects.equals(apellido2, other.apellido2)
				&& Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);
	}

	public abstract String toString();

}
