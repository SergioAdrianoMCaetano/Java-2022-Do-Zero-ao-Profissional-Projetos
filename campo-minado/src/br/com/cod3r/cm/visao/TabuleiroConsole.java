package br.com.cod3r.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.cod3r.cm.excecao.ExplosaoException;
import br.com.cod3r.cm.excecao.SairException;
import br.com.cod3r.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	Scanner entrada = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while(continuar) {
				cicloDoJogo();
				
				System.out.println("Deseja jogar novamente? (S/n)");
				String resposta = entrada.nextLine();
				
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
					System.out.println("Até breve!");
				}else {
					tabuleiro.reiniciar();
				}
			}
			
		}catch (SairException e) {
			System.out.println("Tchau!! Até a próxima!!");
		}finally {
			entrada.close();
		}
		
	}

	private void cicloDoJogo() {
		try {
			
			while(!tabuleiro.objetivoAlcancado()) {//OBJETIVO DO JOGO NÃO FOI ALCANÇADO ENTÃO;
				System.out.println(tabuleiro);
				
				String digitado = capturarValorDigitado("Digite (x ou y): ");
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
				.map(e -> Integer.parseInt(e.trim())).iterator();//TRANSFORMAR O VALOR DIGITADO EM INTEIRO;
				
				digitado = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar: ");
				
				if("1".equals(digitado)){
					tabuleiro.abrir(xy.next(), xy.next());//ABRIR O JOGO COM OS VALORES DIGITADOS;
				}else if("2".equals(digitado)) {
					tabuleiro.alterarMarcacao(xy.next(), xy.next());//ALTERAR A MARCAÇÃO COM OS VALORES DIGITADOS;
				}
				
			}
			System.out.println(tabuleiro);
			System.out.println("=D \nParabéns!! \nVocê venceu!!");//OBJETIVO DO JOGO ALCANÇADO;
		}catch (ExplosaoException e) {//EXPLOSÃO DA BOMBA;
			System.out.println(tabuleiro);
			System.out.println("=( \nVocê perdeu!");
		} 
	}
	
	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();
		
		if("sair".equals(digitado)) {
			throw new SairException();
		}
		
		return digitado;
	}
	
	

}
