package Q4.letraC;

public abstract class Impressora {
	
	public void imprimir(String conteudo) {
		if (conteudo == null) {
			throw new IllegalArgumentException("Conteúdo nulo");
		} else {
			System.out.println(conteudo);
		}
	}
	
}
