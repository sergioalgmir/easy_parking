package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * En esta clase solo se encuentra el método necesario para conectarse a la base de datos.
 */
public class Conexion {
	


		
		private static String url = "jdbc:mysql://tramway.proxy.rlwy.net:34709/railway";
		private static String user = "root";
		private static String password = "ovRGMHkkrdiYhNexaKHlfoLQCSkcRmAv";
		
		public static Connection conectar() {
			Connection con = null;
			try{
				
				con = DriverManager.getConnection(url, user, password);
				
			} catch (SQLException e) {
				System.out.println("Error al conectar con la base de datos");
			}
			return con;
		}

}
