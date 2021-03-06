//----------------------------------------------------------
//Bruno Marchi Pires
//Andrei Ant?nio Villa
//----------------------------------------------------------

package apresentacao;

import persistencia.EspecieDAO;
import persistencia.AnimalDAO;

import java.sql.Date;

import java.util.List;
import java.util.Scanner;

import dados.Especie;

import dados.Animal;

public class Main {

	private static EspecieDAO especieDAO;
	private static AnimalDAO animalDAO;
	
	
	public static void main(String[] args) {
		int op = -1;
		while(op!=0) {
			op = menu();
			switch (op){
            	case 1: 
            		especieDAO.insert(novaEspecie());
            		break;
            	case 2: 
            		animalDAO.insert(novoAnimal());
                    break;
            	case 3: 
            		printaTabelasEspecies("",especieDAO.getInstance().selectAll());
          
                    break;
            	case 4: 
            		printaTabelasAnimais("",animalDAO.getInstance().selectAll());
                    break;
            	case 5:
            		List<Animal> animais = animalDAO.getInstance().join();
            		printaTabelasAnimais("join", animais);
                    break;
            	case 6:
            		List<Especie>especies = animalDAO.getInstance().subagreg();
            		printaTabelasEspecies("subagreg", especies);
            		break;
			}
		}
	}
	
	
	private static int menu() {
        System.out.println("");
        System.out.println("Informe o n?mero da op??o que desejas executar: ");
        System.out.println("1 - Inserir uma nova esp?cie");
        System.out.println("2 - Inserir um novo animal");
        System.out.println("3 - Exibir todas as esp?cies");
        System.out.println("4 - Exibir todos os animais");
        System.out.println("5 - Exibir animais com expectativa de vida maior que 10 anos");
        System.out.println("6 - Exibir especies ordenadas de acordo com a quantidade de animais que cada uma possui no zool?gico");
        System.out.println("Digite 0 para sair");
        System.out.print("Sua op??o: ");
        Scanner input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine());
    }
	
	private static Especie novaEspecie() {
		Scanner input = new Scanner(System.in);
		Especie especie = new Especie();
		System.out.println("Informe o codigo da nova esp?cie:");
		especie.setCodEspecie(Integer.parseInt(input.nextLine()));
		System.out.println("Informe o nome da nova esp?cie:");
		especie.setNomeEspecie(input.nextLine());
		System.out.println("Informe a expectativa de vida da nova esp?cie:");
		especie.setExpectativaEspecie(Integer.parseInt(input.nextLine()));
		return especie;
	}
	
	private static Animal novoAnimal() {
		Scanner input = new Scanner(System.in); 
		Animal animal = new Animal();
		System.out.println("Informe o codigo do novo animal");
		animal.setCodAnimal(Integer.parseInt(input.nextLine()));
		System.out.println("Informe o nome do novo animal");
		animal.setNomeAnimal(input.nextLine());
		System.out.println("Informe o codigo da m?e do novo animal");
		animal.setCodAnimalMae(Integer.parseInt(input.nextLine()));
		System.out.println("Informe o codigo do pai do novo animal");
		animal.setCodAnimalPai(Integer.parseInt(input.nextLine()));
		System.out.println("Informe o codigo da especie do novo animal");
		animal.setCodEspecie(Integer.parseInt(input.nextLine()));
		System.out.println("Informe a data de nascimento do novo animal");
		String datastr = input.nextLine(); //convers?o de string para DATASQL
		Date datasql = Date.valueOf(datastr);
		animal.setDataNascimento(datasql);
		return animal;
	}
	
	private static void printaTabelasAnimais(String choice, List<Animal> lista) {
		if (choice == ""){
			for (Animal a : lista) {
				System.out.println("____________________________________________________________________________________________________________________________________________________________________________");
				System.out.println(a.toString());
			}	
		}else {
			//join
			for (Animal a : lista) {
				System.out.println("____________________________________________________________________________________________________________________________________________________________________________");
				System.out.println(a.getNomeAnimal());
			}
		}
	}
	
	private static void printaTabelasEspecies(String choice, List<Especie> lista) {
		
		if(choice == "") {
			for(Especie e : lista){
				System.out.println("______________________________________________________________________________________________________________________________________________________________________________");
				System.out.println(e.toString());
			}
		}else {
			//subagreg
			for(Especie e : lista){
				System.out.println("______________________________________________________________________________________________________________________________________________________________________________");
				System.out.println("CodEspecie: "+e.getCodEspecie()+"    NomeEspecie: "+ e.getNomeEspecie()+"     QuantidadeAnimais: "+ e.getMax());
			}
		}
	}
}
