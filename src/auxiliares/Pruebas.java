package auxiliares;

import java.time.LocalDateTime;

import modelo.Plaza;
import modelo.PlazaCoche;
import modelo.Reserva;
import modelo.Usuario;
import modelo.Vehiculo;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Usuario u = new Usuario();
		Plaza p = new PlazaCoche(2, 34, false);

		LocalDateTime inicio = LocalDateTime.of(2025, 5, 23, 10, 30);
		LocalDateTime fin = LocalDateTime.of(2025, 5, 24, 8, 30);

		Reserva r = new Reserva(u, p, inicio, fin);
		System.out.println(r.toString());
	}

}
