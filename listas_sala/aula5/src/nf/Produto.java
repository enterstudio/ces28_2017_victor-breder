package nf;

public class Produto implements ItemInterface {
	
	private int id;
	private String nome;
	private int preco;
	
	public Produto(String nome, int preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}
	
	public int getPreco() {
		return preco;
	}

}
