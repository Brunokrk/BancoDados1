package apresentacao;

import persistencia.EspecieDAO;
import persistencia.AnimalDAO;

import java.sql.Date;

import java.util.List;
import dados.Especie;

import dados.Animal;

public class Main {

	private static EspecieDAO especieDAO;
	private static AnimalDAO animalDAO;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Testando Banco
		//Especie e1 = new Especie(14, "Bruno", 12);
		//especieDAO.getInstance().insert(e1);
		
		String datastr = "2017-10-10";
		Date date = Date.valueOf(datastr);
		Animal a1 = new Animal("Mel", 67, 1, 10, 9, date);
		animalDAO.getInstance().insert(a1);		
		
		//List<Especie> esps = especieDAO.getInstance().selectAll();
		//for(Especie e: esps) {
		//	System.out.println(e.toString());
		//}
		
		//static Date valueOf(String date) -> convers�o de string para data
		
		//String datastr = "2017-10-10";
		//Date date = Date.valueOf(datastr);
		//Animal animal = new Animal("Mel", 27, 2, 10, 9, date);
		//animalDAO.getInstance().insert(animal);
		
		//List<Animal> anis = animalDAO.getInstance().selectAll();
		//for(Animal a : anis) {
		//	System.out.println(a.toString());
		//}
		
		//List<Animal> anis = animalDAO.getInstance().join();
		//for(Animal a : anis) {
			//System.out.println(a.getNomeAnimal());
		//}

	}
}
