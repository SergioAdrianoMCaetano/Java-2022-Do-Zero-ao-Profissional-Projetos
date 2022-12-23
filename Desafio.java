package exercicios.lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {
	
	public static void main(String[] args) {
		
		
		
		
		/*
		 * APLICAR LÂMBIDAS E FUNÇÕES APÓS CRIAR UM PRODUTO E:
		 * 
		 * 1. A partir do produto calcular o preço;
		 * 2. Imposto Municipal: >= 2500 (8,5%)/ < 2500 (Isento);
		 * 3. Frete: >= 3000 (100)/ < 3000(50);
		 * 4. Arredondar: Deixar duas casas decimais;
		 * 5. Formatar: R$1234,56
		 * 
		 * */
		//1. A partir do produto calcular o preço;
		Function<Produto, Double> precoFinal = 
				produto -> produto.preco * (1 - produto.desconto);
		//2. Imposto Municipal: >= 2500 (8,5%)/ < 2500 (Isento);
		UnaryOperator<Double> impostoMunicipal = 
				preco -> preco >= 2500 ? preco * 1.085 : preco;
		//3. Frete: >= 3000 (100)/ < 3000(50);
		UnaryOperator<Double> frete = 
				preco -> preco >= 3000 ? preco + 100 : preco + 50;
		//4. Arredondar: Deixar duas casas decimais;
		UnaryOperator<Double> arredondar = 
				preco -> Double.parseDouble(String.format("%.2f", preco));
		//Formatar: R$1234,56
		Function<Double, String> formatar = 
				preco -> ("R$" + preco).replace(".", ",");
		
		Produto p = new Produto("iPad", 3235.89, 0.13);
		String valor = precoFinal.andThen(impostoMunicipal)
				.andThen(frete)
				//.andThen(arredondar)
				.andThen(formatar)
				.apply(p);
		System.out.println("O preço final é " + valor);
		
	}

}
