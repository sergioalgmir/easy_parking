package modelo.usuario;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Estacionamiento;
import modelo.GestorSistema;
import modelo.plaza.Plaza;
import modelo.plaza.Vehiculo;

public class Cliente extends Usuario implements Comparable<Cliente> {

//	Atributos
	private Vehiculo vehiculo;
	private double saldo;

//	Constructor

	public Cliente(Vehiculo vehiculo) {
		super();
		this.vehiculo = vehiculo;
		this.saldo = 0;

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

//	Métodos de la clase Cliente

	// Relacionados con las reservas
	public String estacionar(Plaza p) {
		if (p.isOcupado() == false) {
			Estacionamiento e = new Estacionamiento(this, p);
			GestorSistema.getListaEstacionamientosActivos().add(e);
			p.setOcupado(true);
			GestorSistema.getPlazasOcupadas().add(p);
			GestorSistema.getPlazasLibres().remove(p);
			return "Estacionamiento iniciado correctamente.";
		} else
			return "No se ha podido iniciar el estacionamiento correctamente.";
	}

	public String finalizarEstacionamiento(Estacionamiento e) {
		if (GestorSistema.getListaEstacionamientosActivos().contains(e)) {
			e.finalizar();
			GestorSistema.getListaEstacionamientosFinalizados().add(e);
			GestorSistema.getListaEstacionamientosActivos().remove(e);
			return "Estacionamiento finalizado correctamente.";
		} else
			return "Error al finalizar el estacionamiento.";
	}

	// Relacionados con los datos del cliente

	public String modificarVehiculo() {
		if (this.getVehiculo().equals(Vehiculo.MOTO)) {
			this.setVehiculo(Vehiculo.COCHE);
		} else
			this.setVehiculo(Vehiculo.MOTO);

		return "Vehiculo modificado correctamente";
	}

	public String modificarEmail() {
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Introduzca el nuevo correo electrónico:");
			String email = sc.next(); // VALIDAR EMAIL
			this.setEmail(email);
			return "Email modificado correctamente.";

		} catch (InputMismatchException e) {

			return "El tipo de dato introducido es incorrecto. No se ha podido modificar su email";
			// TODO: handle exception
		}
	}

	public String modificarTelefono() {

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Introduzca el nuevo número de teléfono: ");
			long tlf = sc.nextLong(); // VALIDAR TELÉFONO
			this.setTelefono(tlf);
			return "Número de teléfono modificado correctamente.";

		} catch (InputMismatchException e) {

			return "El tipo de dato introducido es incorrecto. No se ha podido modificar su número telefónico.";
			// TODO: handle exception
		}

	}

	public String modificarContraseña() {
		try (Scanner sc = new Scanner(System.in)) {
			int intentos = 0;
			System.out.println("Introduzca su contraseña actual:");
			String contrasenyaActual = sc.next();
			intentos++;
			while (!contrasenyaActual.equals(this.getContraseña()) && intentos <= 3) {
				System.out.println("Las contraseñas no coinciden. Inténtelo de nuevo:");
				contrasenyaActual = sc.next();
				intentos++;
			}

			if (intentos > 3) {
				return ("Ha excedido el límite de intentos para restablecer su contraseña. Inténtelo de nuevo más tarde.");

			} else {
				System.out.println("Introduzca la nueva contraseña.");
				System.out.println(
						"Recuerde que debe contener al menos una letra mayúscula, una letra minúscula y un número:");
				String contrasenyaNueva = sc.next(); //VALIDAR CONTRASEÑA
				this.setContraseña(contrasenyaNueva);
				return "Contraseña actualizada correctamente.";
			}
		}
	}
	
	public String ingresarDinero(double cantidad) {
		if (cantidad>0) {
			this.setSaldo(cantidad);
			return "Ingreso realizado correctamente.";
		}
		else return "La cantidad introducida es inválida.";
	}
	
	public String eliminarCuenta() {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Introduzca su contraseña: ");
			String contrasenya = sc.next();
			if(!contrasenya.equals(this.contraseña)) {
				return "Contraseña incorrecta. No se ha podido eliminar la cuenta.";
			}
		    System.out.println("Si está seguro de que desea eliminar la cuenta, pulse 15243:");
			
				int num = sc.nextInt();
				if (num == 15243) {
					
					GestorSistema.getListaClientes().remove(this);
					return "Cuenta eliminada correctamente.";
					
				
			} else return "Código de confirmación incorrecto. Cuenta no eliminada.";
		} catch (InputMismatchException e) {
			return "El tipo de dato introducido es incorrecto.";
			// TODO: handle exception
		}
	}

}
