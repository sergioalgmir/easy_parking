package modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva implements Comparable<Reserva> {

	static int numReserva = 0;
	Integer id;
	private String dniUsuario;
	private Plaza plaza;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFin;
	private double precio;
	private boolean finalizada = false; //true si ha terminado y false en caso contrario

public boolean isFinalizada() {
		return finalizada;
	}

	
	//	Constructores
	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public Reserva(Usuario u, Plaza p, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
		this.id = ++numReserva;
		this.dniUsuario = u.getDni();
		this.plaza = p;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
		this.precio = calcularPrecio();

	}

//	Getters & setters

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public LocalDateTime getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public int getId() {
		return id;
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public String getPlaza() {
		return "Planta " + this.plaza.getPlanta() + ", " + this.plaza.getNumPlaza();
	}

	public double getPrecio() {
		return precio;
	}
	
	public void finalizar() {
		finalizada=true;
	}


//	equals & hashCode. Dos reservas son iguales si tienen el mismo id, las mismas horas de inicio y fin y la misma plaza

	@Override
	public int hashCode() {
		return Objects.hash(fechaHoraFin, fechaHoraInicio, id, plaza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(fechaHoraFin, other.fechaHoraFin)
				&& Objects.equals(fechaHoraInicio, other.fechaHoraInicio) && id == other.id
				&& Objects.equals(plaza, other.plaza);
	}

//	toString


	@Override
	public String toString() {
		return "[" + id + "; Usuario: " + this.dniUsuario + "; Plaza: " + this.getPlaza() + "; Inicio: "
				+ this.fechaHoraInicio.getDayOfMonth() + "/" + this.fechaHoraInicio.getMonthValue() + "/"
				+ this.fechaHoraInicio.getYear() + " " + this.fechaHoraInicio.getHour() + ":"
				+ this.fechaHoraInicio.getMinute() + "; Fin: " + this.fechaHoraFin.getDayOfMonth() + "/"
				+ this.fechaHoraFin.getMonthValue() + "/" + this.fechaHoraFin.getYear() + " "
				+ this.fechaHoraFin.getHour() + ":" + this.fechaHoraFin.getMinute() + "; Precio: " + this.precio
				+ " €]";
	}

//	compareTo

	@Override
	public int compareTo(Reserva o) {
		return this.id.compareTo(o.id);

	}

//	Métodos de clase
	/**
	 * 
	 * @return double. Precio total de la reserva
	 */
	public double calcularPrecio() {
		Duration duracion = Duration.between(fechaHoraInicio, fechaHoraFin); // Se llama así al método porque es un
																				// método estático
		double horas = duracion.toMinutes() / 60.0; // Lo pasamos a minutos porque si lo pasamos a horas directamente
													// con el método getHours(), se pierde la información de los minutos
		return horas * this.plaza.getPrecioXHora();
	}

}
