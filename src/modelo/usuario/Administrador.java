package modelo.usuario;

import java.time.LocalDateTime;
import java.util.SortedSet;

import modelo.Estacionamiento;
import modelo.GestorSistema;
import modelo.plaza.Plaza;
import modelo.plaza.Vehiculo;

public class Administrador extends Usuario {

	// Aunque las llame listas, son conjuntos para evitar que se repitan datos

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
		return GestorSistema.getListaClientes();
	}

	public SortedSet<Plaza> getListaPlazas() {
		return GestorSistema.getListaPlazas();
	}

	public SortedSet<Estacionamiento> getListaEstacionamientosFinalizados() {
		return GestorSistema.getListaEstacionamientosFinalizados();
	}

//	toString

	public SortedSet<Estacionamiento> getListaEstacionamientosActivos() {
		return GestorSistema.getListaEstacionamientosActivos();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[DNI=" + dni + ", Nombre=" + nombre + ", Primer apellido=" + apellido1 + ", Segundo apellido="
				+ apellido2 + ", Email=" + email + ", Teléfono=" + telefono + "]";
	}

//	Métodos de la clase
	
	//Relacionados con las plazas

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
			if (GestorSistema.getPlazasLibres().contains(p))
				GestorSistema.getPlazasLibres().remove(p);
			else if(GestorSistema.getPlazasOcupadas().contains(p))
				GestorSistema.getPlazasOcupadas().remove(p);
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

		for (Plaza p : this.getListaPlazas()) {
			if (p.getTipo().equals(tipo))
				p.setPrecioXHora(precio);
		}
		return "Precio modificado correctamente.";
	}

	
	//Relacionados con los clientes
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
			c=null;
			return "Cliente eliminado correctamente.";
		} else
			return "El cliente no se encontraba en el sistema.";
	}

	
	//Relacionados con los estacionamientos
	public String listarEstacionamientosTerminados() {
		String lista = "";
		for (Estacionamiento e : this.getListaEstacionamientosFinalizados()) {
			lista += e.toString() + "\n";
		}

		return lista;
	}

	public String listarEstacionamientosActivos() {
		String lista = "";
		for (Estacionamiento e : this.getListaEstacionamientosActivos()) {
			lista += e.toString() + "\n";
		}

		return lista;
	}

	public double getBeneficios(int opcion) {
		double beneficios = 0;
		LocalDateTime fechaActual = LocalDateTime.now();
		LocalDateTime fechaLimite = null;
		switch (opcion) {
		case 1:
			fechaLimite = fechaActual.minusDays(1);
			break;

		case 2:
			fechaLimite = fechaActual.minusMonths(1);
			break;
		case 3:
			fechaLimite = fechaActual.minusYears(1);
			break;
		default:
			return 0;

		}

		for (Estacionamiento e : this.getListaEstacionamientosFinalizados()) {
			if (e.getFechaHoraFin().isAfter(fechaLimite))
				beneficios += e.getPrecio();
		}
		return beneficios;

	}

}
