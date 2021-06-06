package co.edu.ufps.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ConexionMysql implements ConexionFactory {
	private Connection con = null;

	private PreparedStatement preparedStatement;

	private static ConexionMysql db;

	private static final String host = "localhost";
	private static final String base = "elecciones_universitarias";
	private static final String url = "jdbc:mysql://" + host + ":3306/" + base;
	private static final String user = "root";
	private static final String password = "";

	public ConexionMysql() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		try {
			if (con == null) {
				con = DriverManager.getConnection(url, user, password);
			}
			boolean valid = con.isValid(50000);
			System.out.print(valid ? "TEST OK" : "TEST FAIL");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public Connection getCon() {
		return this.con;
	}

	
	public static ConexionMysql getConexion() {
		if (db == null) {
			db = new ConexionMysql();
		}
		return db;
	}


	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public ResultSet query() throws SQLException {
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}

	
	public int execute() throws SQLException {
		int result = preparedStatement.executeUpdate();
		return result;
	}

	
	public PreparedStatement setPreparedStatement(String sql) throws SQLException {
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}
	
	
	
	public ResultSet consultar(String sql) {

		try {
			Statement st = (Statement) this.con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/*public static void main(String[] args) {
		ConexionMysql cp = new ConexionMysql();

		ResultSet r = cp.consultar("Select * from eleccion");
		try {
			while (r.next()) {
				int id = r.getInt(1);
				String nombre = r.getString("nombre");
				Date fechainicio = r.getDate("fechainicio");
				Date fechafin = r.getDate("fechafin");
				String cargo = r.getString("cargo");
				System.out.print("\n" + id + "nombre" +nombre);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		cp.cerrarConexion();
	}*/

}
