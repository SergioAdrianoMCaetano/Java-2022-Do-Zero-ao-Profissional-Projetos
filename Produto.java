package exercicios.lambdas;

public class Produto extends Object {
	
	final String nome;
	final double preco;
	final double desconto;
	
	
	public Produto(String nome, double preco, double desconto) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}
	//toSTRING serv
	public String toString(){
		double precoFinal = preco * (1 - desconto);
		return nome + " tem preço de R$" + precoFinal;
		
	}
	
	
}
