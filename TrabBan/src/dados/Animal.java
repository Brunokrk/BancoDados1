//----------------------------------------------------------
//Bruno Marchi Pires
//Andrei Ant?nio Villa
//----------------------------------------------------------

package dados;
 //import java.util.Date;
 import java.sql.Date;
 
public class Animal {
	
	private String nomeAnimal;
	private int codAnimal;
	private int codEspecie;
	private int codAnimalMae;
	private int codAnimalPai;
	private Date dataNascimento;
	//static Date valueOf(String date) -> convers?o de string para data
	
	public Animal(String nomeAnimal, int codAnimal, int codEspecie, int codAnimalMae, int codAnimalPai, Date dataNascimento) {
		this.codAnimal = codAnimal;
		this.nomeAnimal = nomeAnimal;
		this.codEspecie = codEspecie;
		this.codAnimalMae = codAnimalMae;
		this.codAnimalPai = codAnimalPai;
		this.dataNascimento = dataNascimento;
	}
	
	public Animal() {
		//construtor vazio
	}
	

	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public int getCodAnimal() {
		return codAnimal;
	}
	public void setCodAnimal(int codAnimal) {
		this.codAnimal = codAnimal;
	}
	public int getCodEspecie() {
		return codEspecie;
	}
	public void setCodEspecie(int codEspecie) {
		this.codEspecie = codEspecie;
	}
	public int getCodAnimalMae() {
		return codAnimalMae;
	}
	public void setCodAnimalMae(int codAnimalMae) {
		this.codAnimalMae = codAnimalMae;
	}
	
	public int getCodAnimalPai() {
		return codAnimalPai;
	}
	public void setCodAnimalPai(int codAnimalPai) {
		this.codAnimalPai = codAnimalPai;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String toString() {
		
		return "nomeAnimal = "+this.nomeAnimal+" | codEspecie = "+this.codEspecie+" | codAnimal = "+this.codAnimal+" | codAnimalMae = "+this.codAnimalMae+" | codAnimalPai = " + this.codAnimalPai + " | dtnascimento = "+ this.dataNascimento;                           
	}
	
	
}
