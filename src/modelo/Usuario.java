package modelo;

/**
 * Clase modelo para crear objetos de tipo Usuario.
 */
public class Usuario {

	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email;
	private long telefono;
	private Vehiculo vehiculo;
	private double saldo;

//	Constructor
	/**
	 * Constructor
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param email
	 * @param telefono
	 * @param vehiculo  puede ser Vehiculo.COCHE o Vehiculo.MOTO
	 */

	public Usuario(String dni, String nombre, String apellido1, String apellido2, String email, long telefono,
			Vehiculo vehiculo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.telefono = telefono;
		this.vehiculo = vehiculo;
		this.saldo = 0;
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

	@Override
	public String toString() {
		return "[" +nombre + " " + apellido1 + " " + apellido2 + ", " + dni + ", " + telefono + ", " + email + ", " + vehiculo + "]";
				
	}

}
