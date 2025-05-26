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
			
			String sql = 
					"CREATE TABLE IF NOT EXISTS estacionamientos ("
				            + "  id INT AUTO_INCREMENT PRIMARY KEY,"
				            + "  dni_usuario VARCHAR(9) NULL,"
				            + "  plaza_id INT NULL,"
				            + "  fecha_hora_inicio DATETIME NOT NULL,"
				            + "  fecha_hora_fin DATETIME,"
				            + "  precio DECIMAL(8,2) NOT NULL DEFAULT 0,"
				            + "  finalizado BOOLEAN NOT NULL DEFAULT FALSE,"
				            + "  FOREIGN KEY (dni_usuario) REFERENCES clientes(dni) ON DELETE SET NULL,"
				            + "  FOREIGN KEY (plaza_id) REFERENCES plazas(id) ON DELETE SET NULL"
				            + ");"
				            ;
					st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	

}
