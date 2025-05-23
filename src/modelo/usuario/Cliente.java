package modelo.usuario;

import java.util.SortedSet;
import java.util.TreeSet;

import modelo.Estacionamiento;
import modelo.plaza.Vehiculo;

public class Cliente extends Usuario implements Comparable<Cliente> {

//	Atributos
	private Vehiculo vehiculo;
	private double saldo;
	

//	Constructor

	public Cliente(Vehiculo vehiculo) {
		super();
		this.vehiculo = vehiculo;
		this.saldo=0;
		
	}

// 	Getters & Setters

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	

	// toString

	@Override
	public String toString() {
		return "[DNI=" + dni + ", Nombre=" + nombre + ", Primer apellido=" + apellido1 + ", Segundo apellido="
				+ apellido2 + ", Email=" + email + ", Teléfono=" + telefono + ", Vehículo=" + vehiculo + ", Saldo="
				+ saldo + "]";
	}

//	compareTo

	@Override
	public int compareTo(Cliente o) { // Comparamos por dni para ordenarlos en una lista de clientes que será visible
										// solo por el administrador
		return this.dni.compareTo(o.getDni());
	}

}
