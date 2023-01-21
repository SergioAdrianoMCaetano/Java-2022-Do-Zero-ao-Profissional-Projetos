package br.com.cod3r.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.cod3r.cm.excecao.ExplosaoException;

public class Campo {
	
	private final int linha;
	private final int coluna;
	
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;
	
	//LISTA PARA A CLASSE CAMPO;
	private List<Campo> vizinhos = new ArrayList<>();
	//LISTA PARA CAMPO OBSERVADOR;
	private List<CampoObservador> observadores = new ArrayList();
	
	//CONSTRUTOR CAMPO
	public Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	//REGISTRAR OBSERVADOR
	public void registrarObservador(CampoObservador observador) {
		observadores.add(observador);
	}
	
	public void notificarObservador(CampoEvento evento) {
		observadores.stream().forEach(o -> o.eventoOcorreu(this, evento));
		
	}
	
	
	
	//MÉTODOS DA CLASSE CAMPO;
	public boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna - deltaLinha;
		
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else if(deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else {
			return false;
		}
	}
	
	//ALTERAR A MARCAÇÃO DO CAMPO;
	public void alternarMarcacao() {
		if(!aberto) {
			marcado = !marcado;
		}
		
			//MOSTRAR NA INTERFACE SE O CAMPO ESTÁ MARCADO OU DESMARCADO;
			if(marcado) {
				notificarObservador(CampoEvento.MARCAR);
			}else {
				notificarObservador(CampoEvento.DESMARCAR);
			}
	}
	
	//ABRINDO O CAMPO;
	public boolean abrir() {
		if(!aberto && !marcado) {
			if(minado) {
				notificarObservador(CampoEvento.EXPLODIR);
				return true;
			}
			
			setAberto(true);
			
			if(vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			
			return true;
		} else {
			return false;
		}
		
	}
	
	//VERIFICAR SE A CASA AO LADO É SEGURA PARA ABRIR O CAMPO;
	public boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	public void minar() {
		minado = true;
	}
	
	public boolean isMinado() {
		return minado;
	}
	
	public boolean isMarcado() {
		return marcado;
	}
	
	
	void setAberto(boolean aberto) {
		this.aberto = aberto;
		
		if(aberto) {
			notificarObservador(CampoEvento.ABRIR);
		}
	}

	public boolean isAberto() {
		return aberto;
	}
	
	public boolean isFechado() {
		return !isAberto();
	}
	
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}

	//DEFINIR O OBJETIVO ALCANÇADO NO CAMPO;
	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}
	
	public int minasNaVizinhanca() {
		return (int) vizinhos.stream().filter(v -> v.minado).count();
	}
	
	public void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
		notificarObservador(CampoEvento.REINICIAR);
		
	}
	
	/*public String toString() {
		if(marcado) {
			return "x";
		} else if(aberto && minado) {
			return "*";
		} else if(aberto && minasNaVizinhanca() > 0) {
			return Long.toString(minasNaVizinhanca());
		} else if(aberto ) {
			return " ";
		} else {
			return "?";
		}
	}*/
}
