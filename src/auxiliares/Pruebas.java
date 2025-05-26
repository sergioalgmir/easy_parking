package auxiliares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://tramway.proxy.rlwy.net:34709/railway";
		String user = "root";
		String password = "ovRGMHkkrdiYhNexaKHlfoLQCSkcRmAv";
		
		
		try(Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement()){
			 String sql = "CREATE TABLE IF NOT EXISTS administradores ("
		                + "dni VARCHAR(9) PRIMARY KEY, "
		                + "nombre VARCHAR(30) NOT NULL, "
		                + "apellido1 VARCHAR(50) NOT NULL, "
		                + "apellido2 VARCHAR(50), "
		                + "email VARCHAR(100) UNIQUE NOT NULL, "
		                + "telefono INT UNIQUE NOT NULL, "
		                + "contraseña VARCHAR(100) NOT NULL"
		                + ");";
				            ;
					st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	

}
