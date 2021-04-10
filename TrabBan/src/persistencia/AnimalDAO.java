package persistencia;

import java.sql.*;
import dados.Animal;

public class AnimalDAO {

	private static AnimalDAO instance = null; //tornando um singleton
	private PreparedStatement selectAll;
	private PreparedStatement insert;
	private PreparedStatement join;
	private PreparedStatement subagreg;
	
	
	private AnimalDAO() {
		//Construtor
		Connection conexao = Conexao.getConexao();
		try {
			//Expressões SQL
			insert = conexao.prepareStatement("insert into animais values(?,?,?,?,?,?)");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static AnimalDAO getInstance() {
		//pegando instância do singleton
		if(instance == null) {
			instance = new AnimalDAO();
		}
		return instance;
	}
	
	//nome, codesp, codani, codpai, codmae, datanascimento
	public void insert (Animal animal) {
		try {
			insert.setString(1, animal.getNomeAnimal());
			insert.setInt(2, animal.getCodEspecie());
			insert.setInt(3, animal.getCodAnimal());
			insert.setInt(4, animal.getCodAnimalPai());
			insert.setInt(5,  animal.getCodAnimalMae());
			insert.setDate(6, animal.getDataNascimento()); //vai dar merda
			insert.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
