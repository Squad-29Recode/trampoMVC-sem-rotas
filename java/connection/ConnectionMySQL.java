package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	private static String URL = "jdbc:mysql://localhost:3306/trampo360°entrega2";
	private static String USUARIO = "root";
	private static String SENHA = "33612515";
	
	public static Connection createConnectionMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
		
		return connection;
	}
	public static void main(String[] args) throws Exception {
		// Recupera uma conexão com o banco de dados
		Connection con = createConnectionMySQL();
		
		// testar a conexão 
		if (con != null) {
			System.out.println(con + "\n\n ****  Conexão obtida com sucesso!  ****");
			con.close();
		}
	}
}