//----------------------------------------------------------
//Bruno Marchi Pires
//Andrei Ant?nio Villa
//----------------------------------------------------------

package dados;

public class Especie {
	private int codEspecie;
	private String nomeEspecie;
	private int expectativaEspecie;
	private int max; //usado apenas para ultima consulta (op??o 6)
	
	public Especie(int codEspecie, String nomeEspecie, int expectativaEspecie) {
		this.codEspecie = codEspecie;
		this.nomeEspecie = nomeEspecie;
		this.expectativaEspecie = expectativaEspecie;
	}
	
	public Especie() {
		//construtor vazio para tornar opcional a utiliza??o ou n?o do outro
	}
	
	
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getCodEspecie() {
		return codEspecie;
	}
	public void setCodEspecie(int codEspecie) {
		this.codEspecie = codEspecie;
	}
	public String getNomeEspecie() {
		return nomeEspecie;
	}
	public void setNomeEspecie(String nomeEspecie) {
		this.nomeEspecie = nomeEspecie;
	}
	public int getExpectativaEspecie() {
		return expectativaEspecie;
	}
	public void setExpectativaEspecie(int expectativaEspecie) {
		this.expectativaEspecie = expectativaEspecie;
	}
	
	public String toString() {
		return "codEspecie = "+this.codEspecie+" | nomeEspecie: "+this.nomeEspecie+" | expectativaEspecie: "+ this.expectativaEspecie+"\n";
	}
	
	
}
