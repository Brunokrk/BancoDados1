//----------------------------------------------------------
//Bruno Marchi Pires
//Andrei Ant?nio Villa
//----------------------------------------------------------

package persistencia;

import java.sql.*;
import dados.Especie;

import java.util.ArrayList;
import java.util.List;

public class EspecieDAO {
	private static EspecieDAO instance = null;

	//Prepared Statements
	private PreparedStatement selectAll; 
	private PreparedStatement insert; //ok
	private PreparedStatement join;
	private PreparedStatement subagreg;
	
	
	public static EspecieDAO getInstance() {
		if(instance ==null) {
			instance = new EspecieDAO();
		}
		return instance;
	}

	private EspecieDAO() {
		//Construtor
		
		Connection conexao = Conexao.getConexao();
		try {
			//Express?es SQL
			insert = conexao.prepareStatement("insert into especies values (?, ?, ?)");
			selectAll = conexao.prepareStatement("select * from especies");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insert (Especie esp) {
		try {
			insert.setInt(1, esp.getCodEspecie());
			insert.setString(2, esp.getNomeEspecie());
			insert.setInt(3, esp.getExpectativaEspecie());
			insert.executeUpdate();
			System.out.println("Especie inserida com sucesso");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Especie> selectAll() {
		List<Especie> especies = new ArrayList<Especie>();
		
		//retorna todas as esp?cies do banco de dados
		try {
			ResultSet rs = selectAll.executeQuery();		
			while(rs.next()) {
				int idesp = rs.getInt(1);
				String nome = rs.getString(2);
				int expec = rs.getInt(3);
				especies.add(new Especie(idesp, nome, expec));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return especies;
	}
	
}	
