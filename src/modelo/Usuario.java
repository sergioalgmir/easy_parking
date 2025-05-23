package modelo;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Clase modelo para crear objetos de tipo Usuario.
 */
public class Usuario {

//	Atributos
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email;
	private long telefono;
	private Vehiculo vehiculo;
	private double saldo;
	private SortedSet<Reserva> reservasActivas = new TreeSet<Reserva>();
	private String contraseña;

//	Constructores

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor
	 * 
	 * @param dni       String
	 * @param nombre    String
	 * @param apellido1 String
	 * @param apellido2 String
	 * @param email     String
	 * @param telefono  long
	 * @param vehiculo  puede ser Vehiculo.COCHE o Vehiculo.MOTO
	 */

	public Usuario(String dni, String nombre, String apellido1, String apellido2, String email, long telefono,
			Vehiculo vehiculo, String contraseña) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.telefono = telefono;
		this.vehiculo = vehiculo;
		this.saldo = 0;
		this.contraseña = contraseña;
	}

//	Getters & Setters

	/**
	 * 
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * 
	 * @param dni String
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * 
	 * @param apellido1 String
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * 
	 * @return apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * 
	 * @param apellido2 String
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return telefono
	 */
	public long getTelefono() {
		return telefono;
	}

	/**
	 * 
	 * @param telefono long
	 */
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	/**
	 * 
	 * @return vehiculo (COCHE o MOTO)
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * 
	 * @param vehiculo Vehiculo (COCHE o MOTO)
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * 
	 * @return saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * 
	 * @param saldo double
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public SortedSet<Reserva> getReservasActivas() {
		return reservasActivas;
	}
	

	// toString
	

	public String toStringParaAdmin() {
		return "[" + nombre + " " + apellido1 + " " + apellido2 + ", " + dni + ", " + telefono + ", " + email + ", "
				+ vehiculo + "]";
	}
		
		
		public String toStringParaUsuario() {
			return "[DNI=" + dni + ", Nombre=" + nombre + ", Primer apellido=" + apellido1 + ", Segundo apellido=" + apellido2
					+ ", Email=" + email + ", Teléfono=" + telefono + ", Vehículo=" + vehiculo + ", Saldo=" + saldo
					+ ", Contraseña=" + contraseña + "]";

	}

//	equals & hashCode


	

	@Override

	public int hashCode() {
		return Objects.hash(dni, email, telefono);
	}

	@Override

	/**
	 * Un usuario es igual a otro si coinciden en dni, telefono y email
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(email, other.email) && telefono == other.telefono;
	}
	
	
	

}
