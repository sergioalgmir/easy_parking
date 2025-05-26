package dao.clasesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.Conexion;
import modelo.usuario.Cliente;

public class ClienteDAO {

	private Connection conexion;

	public ClienteDAO() {
		this.conexion = Conexion.conectar();

		// TODO Auto-generated constructor stub
	}

	public void create (Cliente cl) {
		if (cl!= null) {
			Connection con = conexion;
			String sql = "INSERT INTO clientes (dni, nombre, apellido1, apellido2, email, telefono, contrasenya, vehiculo, "
					+ "saldo) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			
			try (PreparedStatement st = conexion.prepareStatement(sql)){
				st.setString(1, cl.getDni());
				st.setString(2, cl.getNombre());
				st.setString(3, cl.getApellido1());
				st.setString(4, cl.getApellido2());
				st.setString(5, cl.getEmail());
				st.setLong(6, cl.getTelefono());
				st.setString(7, cl.getContraseña());
				st.setString(8, cl.getVehiculo().name());
				st.setDouble(9, 0);
				
				st.executeUpdate();
			} catch (SQLException e) {
				System.out.println("SQLException: "+ e.getMessage());
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("ErrorCode: " + e.getErrorCode());
			} finally {
				if (con!= null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
