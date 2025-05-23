package modelo.plaza;

public class PlazaMoto extends Plaza {
	
//	Constructor

	public PlazaMoto(int planta, int numPlaza) {
		super(planta, numPlaza);
		this.tipo = Vehiculo.MOTO;
		this.precioXHora = 1.06;


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
