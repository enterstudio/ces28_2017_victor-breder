package labmock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.jdbc.Driver;

public class ServicoDB implements IServicoDB {

	private Connection conn;
	
	public void setDBConnection(Connection conn) {
		this.conn = conn;
	}

	public void getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ces28?useSSL=false", "root", "senha");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int persisteProcesso(IProcesso proc) {
		try {
			String query = "INSERT INTO processos (id, nome_reclamante, telefone, email) " + "VALUES ('" + proc.getID()
					+ "','" + proc.getNomeReclamante() + "','" + proc.getTelefone() + "','" + proc.getEmail() + "')";
			return conn.createStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
