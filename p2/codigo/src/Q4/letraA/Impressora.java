package Q4.letraA;

public class Impressora {
	
	public void imprimir(String conteudo) {
		if (conteudo == null) {
			throw new IllegalArgumentException("Conteúdo nulo");
		} else {
			System.out.println(conteudo);
		}
	}
	
}
