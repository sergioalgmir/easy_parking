package auxiliares;

public class Validaciones {
	
	/**
	 * Valida que la contraseña tenga más de 6 caracteres y contenga al menos una letra mayúscula, una letra minúscula y un número.
	 * @param contrasenya
	 * @return
	 */
	public static boolean validarContrasenya(String contrasenya) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{7,}$";
		return contrasenya != null && contrasenya.matches(regex);
		
	}

}
