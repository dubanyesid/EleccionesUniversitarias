package co.edu.ufps.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionPostgreSQL implements ConexionFactory {

	public Connection con;

	private static ConexionPostgreSQL db;

	private PreparedStatement preparedStatement;
	
	public Statement st = null;

	private ConexionPostgreSQL() {
	
		
		/*String host = "kashin.db.elephantsql.com";
		String db = "mpybktnb";
		String url = "jdbc:postgresql://" + host + ":5432/" + db;
		String user = "mpybktnb";
		String password = "WhyxLHVX1nhKKGqqdEHfXNUYo4wS3HVA";
		*/
		String host = "localhost";
		String db = "elecciones2";
		String url = "jdbc:postgresql://" + host + ":5432/" + db;
		String user = "postgres";
		String password = "123";
		
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, user, password);

			boolean valid = con.isValid(50000);
			System.out.print(valid ? "TEST OK" : "TEST FAIL");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static ConexionPostgreSQL getConexion() {

		if (db == null) {
			db = new ConexionPostgreSQL();
		}
		return db;
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

	
	public void cerrarConexion() {
		try {
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet consultar(String sql) {

		try {
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// COMPROBAR
	public static void main(String[] args) {
		ConexionPostgreSQL cp = new ConexionPostgreSQL();

		ResultSet r = cp.consultar("Select * from eleccion");
		try {
			while (r.next()) {
				int id = r.getInt(1);
				String nombre = r.getString("nombre");
				
				
				System.out.print("\n" + id + "nombre" +nombre);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		cp.cerrarConexion();
	}
}
