package nf;

public class Cliente {
	
	private String cpf;
	private String nome;
	private String endereco;
	private String telefone;
	
	public Cliente(String cpf, String nome, String endereco, String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String getCPF() {
		return cpf;
	}

}
