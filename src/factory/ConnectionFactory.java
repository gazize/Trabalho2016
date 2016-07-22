package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Descri��o: Classe do tipo ConnectionFactory para realizar o gerenciamento de conex�o com o BD
 * 
 * 
 * */
public class ConnectionFactory {

	static {
		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			throw new RuntimeException(e);

		}
	}

	// Obt�m conex�o com o banco de dados
	public static Connection obtemConexao() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost/SICM_WEB?user=root&password=1234");

	}
}