package exercicios.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Fornecedor {

	public static void main(String[] args) {
		
		/*SUPPLIER É UMA INTERFACE QUE RECEBE UM PARÂMENTRO E NÃO DEVOLVE NADA.
		 * É UMA FUNÇÃO MAIS SIMPLES*/
		Supplier<List<String>> umLista = () -> Arrays.asList("Ana", "Gui", "Bia");
		System.out.println(umLista.get());
	}
}
