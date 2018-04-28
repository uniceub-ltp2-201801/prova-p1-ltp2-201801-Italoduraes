package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	//Metodo para retornar um conexao ao BD
	public static Connection getConexao() {
		
		// Criando o objeto de conexao
		Connection conexao = null;

		//conectar no banco de dados
		
		try {
			//referenciar o driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			
			//Criar strings de conexão
			String url= "jdbc:mysql://localhost/faculdade";
			String username ="root";
			String password = "root";
			
			// Realizar conexao com o BD
		 conexao = DriverManager.getConnection(url, username , password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// Mostra o erro
			e.printStackTrace();
		}
		
		return conexao;
		
		
	}

}
