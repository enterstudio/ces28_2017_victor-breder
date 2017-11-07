package ProdutoServico;

public class Servico implements Component {
	
	private String nome;
	private double precoUnitario;
	private int tempo;
	
	public Servico(String nome, double precoUnitario, int tempo) {
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.tempo = tempo;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
}
