package modelo.usuario;

import java.util.SortedSet;
import java.util.TreeSet;

import modelo.Estacionamiento;
import modelo.plaza.Plaza;
import modelo.plaza.Vehiculo;

public class Administrador extends Usuario {

	// Aunque las llame listas, son conjuntos para evitar que se repitan datos

	private SortedSet<Cliente> listaClientes = new TreeSet<Cliente>();
	private SortedSet<Plaza> listaPlazas = new TreeSet<Plaza>();
	private SortedSet<Estacionamiento> listaEstacionamientosFinalizados = new TreeSet<Estacionamiento>();
	private SortedSet<Estacionamiento> listaEstacionamientosActivos = new TreeSet<Estacionamiento>();

//	Constructores

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(String dni, String nombre, String apellido1, String apellido2, String email, long telefono,
			String contraseña) {
		super(dni, nombre, apellido1, apellido2, email, telefono, contraseña);
		// TODO Auto-generated constructor stub
	}

//	Getters & Setters

	// Solo creo los getters porque se pueden modificar los conjuntos directamente
	// desde el getter

	public SortedSet<Cliente> getListaClientes() {
		return listaClientes;
	}

	public SortedSet<Plaza> getListaPlazas() {
		return listaPlazas;
	}

	public SortedSet<Estacionamiento> getListaEstacionamientosFinalizados() {
		return listaEstacionamientosFinalizados;
	}
	
	
	
//	toString

	public SortedSet<Estacionamiento> getListaEstacionamientosActivos() {
		return listaEstacionamientosActivos;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[DNI=" + dni + ", Nombre=" + nombre + ", Primer apellido=" + apellido1 + ", Segundo apellido="
				+ apellido2 + ", Email=" + email + ", Teléfono=" + telefono + "]";
	}

//	Métodos de la clase

	public String crearPlaza(Plaza p) {
		if (this.getListaPlazas().contains(p)) {
			return "La plaza referida ya se encuentra en el sistema.";
		} else {
			this.getListaPlazas().add(p);
			return "Plaza añadida correctamente.";
		}
	}

	public String eliminarPlaza(Plaza p) {
		if (this.getListaPlazas().contains(p)) {
			this.getListaPlazas().remove(p);
			return "Plaza eliminada del sistema.";
		} else
			return "La plaza no se encontraba en el sistema.";
	}

	/**
	 * Modificar el precio por hora según el tipo de plaza
	 * 
	 * @param tipo
	 * @param precio
	 * @return
	 */
	public String modificarPrecioPlazas(Vehiculo tipo, double precio) {

		for (Plaza p : this.listaPlazas) {
			if (p.getTipo().equals(tipo))
				p.setPrecioXHora(precio);
		}
		return "Precio modificado correctamente.";
	}

	public String listarClientes() {
		String lista = "";
		for (Cliente c : this.getListaClientes()) {
			lista += c.toString() + "\n";
		}

		return lista;
	}

	public String eliminarCliente(Cliente c) {
		if (this.getListaClientes().contains(c)) {
			this.getListaClientes().remove(c);
			return "Cliente eliminado correctamente.";
		} else
			return "El cliente no se encontraba en el sistema.";
	}

}
