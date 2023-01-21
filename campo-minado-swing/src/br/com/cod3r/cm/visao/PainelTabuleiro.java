package br.com.cod3r.cm.visao;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.cod3r.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel{//AGRUPADOR DE COMPONETES;
	
	public PainelTabuleiro(Tabuleiro tabuleiro) {
		
		setLayout(new GridLayout(
				tabuleiro.getLinhas(), tabuleiro.getColunas()));

		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));//PRA CADA QUADRADINHO DO TABULEIRO ELE VAI CRIAR UM BOTÃO;
	
		tabuleiro.registrarObservador(e ->{
			
			SwingUtilities.invokeLater(() -> {
				if(e.isGanhou()) {
					JOptionPane.showMessageDialog(this, "Ganhou =D");
				}else {
					JOptionPane.showMessageDialog(this, "Perdeu =(");
				}
				
				tabuleiro.reiniciar();
				
			});
		});
	}

}
