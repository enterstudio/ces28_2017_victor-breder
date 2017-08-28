package nf;

public interface DBCliente {
	
	public boolean addCliente(String cpf, String nome, String endereco, String telefone);
	
	public Cliente getCliente(String cpf);
	
	public void updateCliente(String cpf, String nome, String endereco, String telefone);
	
	public void deleteCliente(String cpf);
}
