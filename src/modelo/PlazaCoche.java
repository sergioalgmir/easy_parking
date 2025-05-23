package modelo;

public class PlazaCoche extends Plaza {
	public PlazaCoche(int planta, int numPlaza, boolean ocupado) {
		super(planta, numPlaza, ocupado);
		this.tipo = Vehiculo.COCHE;
		this.precioXHora = 0.97;


	}

//	Implementación métodos abstractos
	
	@Override
	public String toString() {
		String disponibilidad = "";

		if (ocupado == true)
			disponibilidad = "Libre";
		else
			disponibilidad = "Ocupada";
		return "[Planta " + planta + ", " + numPlaza + ", " + "Coche" + ", " + "Precio por hora: " + precioXHora + "€, "
				+ disponibilidad + "]";
	}

}
