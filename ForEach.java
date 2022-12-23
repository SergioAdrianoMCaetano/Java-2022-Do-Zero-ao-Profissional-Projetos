package exercicios.lambdas;

import java.util.Arrays;
import java.util.List;

public class ForEach {
	
	public static void main(String[] args) {
		
		/** 
		 * COMO APLICAR O FOREACH;
		 * **/
		List<String>aprovados = Arrays.asList("Ana", "Bia", "Gui", "Lia");
		
		System.out.println("Forma tradicional...");
		for(String nome: aprovados) {
			System.out.println(nome);
		}
		
		System.out.println("\nLamnada #01...");
		//PRA CADA ELEMENTO DA LISTA EXECUTE '->' A FUNÇÃO LÂMBIDA{} 
		aprovados.forEach((nome) -> {System.out.println(nome + "!!!");});
		
		//PRA CADA ELEMENTO IMPRIMA NA TELA;
		System.out.println("\nMethod Reference #01...");
		aprovados.forEach(System.out::println);
		
		System.out.println("\nLamnada #02...");
		aprovados.forEach(nome -> meuImprimir(nome));
		
		System.out.println("\nMethod Reference #02...");
		aprovados.forEach(ForEach::meuImprimir);

		}
	
	static void meuImprimir(String nome) {
		System.out.println("Oi! O meu nome é "+ nome);
		
	}

	
	

}
