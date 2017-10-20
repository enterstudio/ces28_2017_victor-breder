package Q4.letraC;

public class SistemaOperacional {
	
	// É possível manter o mesmo método, que retorne alguma impressora padrão
	// independente de esta ser jato de tinta ou laser
	public Impressora getDriverImpressao() {
		return new ImpressoraLaser();
	}
	
	// Caso seja desejado um tipo físico específico, são oferecidos os métodos
	public ImpressoraJatoDeTinta getDriverImpressaoJatoDeTinta() {
		return new ImpressoraJatoDeTinta();
	}
	public ImpressoraLaser getDriverImpressaoLaser() {
		return new ImpressoraLaser();
	}
	
}
