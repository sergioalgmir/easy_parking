package modelo.plaza;

public class PlazaCoche extends Plaza {
	
	
	public PlazaCoche(int planta, int numPlaza) {
		super(planta, numPlaza);
		this.tipo = Vehiculo.COCHE;
		this.precioXHora = 0.97;


	}



}
