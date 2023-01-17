package br.com.cod3r.cm;

import br.com.cod3r.cm.modelo.Tabuleiro;
import br.com.cod3r.cm.visao.TabuleiroConsole;

public class Aplication {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
		new TabuleiroConsole(tabuleiro);
		System.out.println("Se quiser parar o jogo, digite 'sair'");
	}

}
