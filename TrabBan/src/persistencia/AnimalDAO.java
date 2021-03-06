//----------------------------------------------------------
//Bruno Marchi Pires
//Andrei Ant?nio Villa
//----------------------------------------------------------

package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dados.Animal;
import dados.Especie;

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
			//Express?es SQL
			insert = conexao.prepareStatement("insert into animais values(?,?,?,?,?,?)");
			selectAll = conexao.prepareStatement("select * from animais");
			join = conexao.prepareStatement("select a.nomeanimal from animais a join especies e on a.codespecie = e.codespecie where e.expectativaespecie > 10");
			subagreg = conexao.prepareStatement("(select table2.nomeespecie, table2.codespecie, table2.max from \r\n"
					+ "(select table1.nomeespecie, table1.codespecie, MAX(cont) from \r\n"
					+ "(select e.nomeespecie, a.codespecie, count(*) as cont from animais a join\r\n"
					+ "especies e on a.codespecie = e.codespecie group by a.codespecie, e.nomeespecie) as table1\r\n"
					+ "group by table1.nomeespecie, table1.codespecie)as table2\r\n"
					+ "group by table2.nomeespecie, table2.codespecie, table2.max\r\n"
					+ "order by table2.max desc)\r\n"
					+ "");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static AnimalDAO getInstance() {
		//pegando inst?ncia do singleton
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
			System.out.println("Animal inserido com sucesso");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Animal> selectAll() {
		List<Animal> animais = new ArrayList<Animal>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				String nome = rs.getString(1);
				int codEsp = rs.getInt(2);
				int codAni = rs.getInt(3);
				int codAniPai = rs.getInt(4);
				int codAniMae = rs.getInt(5);
				Date date = rs.getDate(6);
				animais.add(new Animal(nome, codAni, codEsp, codAniMae, codAniPai, date));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return animais;
	}
	
	public List<Animal> join(){
		List<Animal> animais = new ArrayList<Animal>();
		
		try {
			ResultSet rs = join.executeQuery();
			while(rs.next()) {
				Animal a =new Animal();
				String nome = rs.getString(1);
				a.setNomeAnimal(nome);
				animais.add(a);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return animais;
	}
	
	public List<Especie> subagreg(){
		List<Especie> especies = new ArrayList<Especie>();
		
		try {
			ResultSet rs = subagreg.executeQuery();
			while(rs.next()) {
				Especie e = new Especie();
				e.setNomeEspecie(rs.getString(1));
				e.setCodEspecie(rs.getInt(2));
				e.setMax(rs.getInt(3));
				especies.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return especies;
	}
}






