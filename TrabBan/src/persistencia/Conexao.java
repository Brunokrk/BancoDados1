//----------------------------------------------------------
//Bruno Marchi Pires
//Andrei Ant�nio Villa
//----------------------------------------------------------

package persistencia;

import java.sql.*;

public class Conexao {

	private static Connection conexao = null;
	
	
	private Conexao() {
		
	}
	
	public static Connection getConexao() {
		if(conexao == null) {
			String url = "jdbc:postgresql://localhost:5432/Zoo";  //mudar de acordo com o banco da professora
			String usuario = "postgres"; //mudar de acordo com o usu�rio da professora
			String senha = "17012001"; //mudar de acordo com a senha da professora
			try {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(url, usuario, senha);
				System.out.println("Conexao com Banco de Dados estabelecida.");
				
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return conexao;
	}
}
