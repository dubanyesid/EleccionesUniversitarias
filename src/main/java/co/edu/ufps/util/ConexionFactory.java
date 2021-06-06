package co.edu.ufps.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ConexionFactory {
	

	public ResultSet query() throws SQLException;

	public PreparedStatement setPreparedStatement(String sql) throws SQLException;

	public int execute() throws SQLException;

	public void cerrarConexion();
}
