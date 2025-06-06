package modelo.plaza;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

import modelo.GestorSistema;

public abstract class Plaza implements Comparable<Plaza> {

//	Atributos
	protected int planta;
	protected int numPlaza;
	protected Vehiculo tipo;
	protected boolean ocupado; // true si está ocupada y false si está libre
	protected double precioXHora;

//	Constructores

	public Plaza() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param planta   int
	 * @param numPlaza int
	 * @param ocupado  boolean (true si está ocupada y false si está libre)
	 */

	public Plaza(int planta, int numPlaza) {
		super();
		this.planta = planta;
		this.numPlaza = numPlaza;
		this.ocupado = false;
		
		// Se crea la plaza libre por defecto y se añade al listado de plazas
		// libres
		GestorSistema.getPlazasLibres().add(this);

	}

//	Getters & setters
	/**
	 * 
	 * @return planta
	 */
	public int getPlanta() {
		return planta;
	}

	/**
	 * 
	 * @param planta int
	 */
	public void setPlanta(int planta) {
		this.planta = planta;
	}

	/**
	 * 
	 * @return numPlaza
	 */
	public int getNumPlaza() {
		return numPlaza;
	}

	/**
	 * 
	 * @param numPlaza int
	 */
	public void setNumPlaza(int numPlaza) {
		this.numPlaza = numPlaza;
	}

	/**
	 * 
	 * @return tipo (COCHE o MOTO)
	 */
	public Vehiculo getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @return boolean, true si está ocupada la plaza y false en caso contrario
	 */

	public boolean isOcupado() {
		return ocupado;
	}

	/**
	 * 
	 * @param ocupado boolean, true si está ocupada la plaza y false en caso
	 *                contrario
	 */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	/**
	 * 
	 * @return precioXHora
	 */
	public double getPrecioXHora() {
		return precioXHora;
	}

	/**
	 * 
	 * @param precioXHora double
	 * 
	 */
	public void setPrecioXHora(double precioXHora) {
		this.precioXHora = precioXHora;
	}



//	equals & hashCode. Dos plazas son iguales si tienen la misma planta y el mismo número de plaza

	@Override
	public int hashCode() {
		return Objects.hash(numPlaza, planta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plaza other = (Plaza) obj;
		return numPlaza == other.numPlaza && planta == other.planta;
	}

	/**
	 * Se compara primero por número de planta y después por número de plaza
	 */
	@Override
	public int compareTo(Plaza o) {
		int compare = Integer.compare(this.planta, o.getPlanta());
		if (compare == 0)
			compare = Integer.compare(this.numPlaza, o.getNumPlaza());

		return compare;
	}

	

	@Override
//	Implementación métodos abstractos
	public String toString() {
		String disponibilidad = "";

		if (ocupado == false)
			disponibilidad = "Libre";
		else
			disponibilidad = "Ocupada";
		return "[Planta " + planta + ", " + numPlaza + ", " + "Moto" + ", " + "Precio por hora: " + precioXHora + "€, "
				+ disponibilidad + "]";
	}

}
