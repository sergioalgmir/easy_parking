package modelo.plaza;

public class PlazaCoche extends Plaza {
	
	
	public PlazaCoche(int planta, int numPlaza) {
		super(planta, numPlaza);
		this.tipo = Vehiculo.COCHE;
		this.precioXHora = 0.97;


	}

//	Implementación métodos abstractos
	
	@Override
	public String toString() {
		String disponibilidad = "";

		if (ocupado == false)
			disponibilidad = "Libre";
		else
			disponibilidad = "Ocupada";
		return "[Planta " + planta + ", " + numPlaza + ", " + "Coche" + ", " + "Precio por hora: " + precioXHora + "€, "
				+ disponibilidad + "]";
	}

}
