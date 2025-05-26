package modelo.plaza;

public class PlazaMoto extends Plaza {
	
//	Constructor

	public PlazaMoto(int planta, int numPlaza) {
		super(planta, numPlaza);
		this.tipo = Vehiculo.MOTO;
		this.precioXHora = 1.06;


	}


}
