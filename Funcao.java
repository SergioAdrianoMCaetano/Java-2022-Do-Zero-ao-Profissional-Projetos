package exercicios.lambdas;

import java.util.function.Function;

public class Funcao {
	
	public static void main(String[] args) {
		
		/*PROGRAMAÇÃO FUNCIONAL PARA ENCADEAMENTO DE FUNÇÕES*/
		
		//INTERFACE QUE RECEBE 2 TIPOS
		Function<Integer, String> parOuImpar = 
				numero -> numero % 2 == 0 ? "Par" : "Ímpar";//EXPRESÃO LÂMBIDA;
		//VERIFICAR SE O NÚMERO DA EXPRESSÃO É PAR OU É ÍMPAR;		
		System.out.println(parOuImpar.apply(32));
		
		//CRIADO OUTRA FUNÇÃO
		Function<String, String> oResultradoE =
				valor -> "O resultado é: " + valor;
		
		Function<String, String> empolgado = valor -> valor + "!!!";		
		//VARIÁVEL QUE ARMAZENARÁ O VALOR DE PARouIMPAR, VAI RECEBER UMA STRING E ENVIAR OUTRA STRING + O VALOR APLICADO;		
		
		
		Function<String, String>duvida = valor -> valor + "???";
		
		String resultadoFinal1 = parOuImpar.
				andThen(oResultradoE).
				andThen(empolgado).
				apply(33);
		
		String resultadoFinal2 = parOuImpar.
				andThen(oResultradoE).
				andThen(duvida).
				apply(32);
		
		System.out.println(resultadoFinal1);
		System.out.println(resultadoFinal2);
		/*Ao final, várias funções foram encadeadas e impressas na tela*/		
				
				
		
		
	}

}
