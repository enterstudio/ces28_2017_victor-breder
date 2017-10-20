package Q4.letraA;

import java.util.Iterator;

public class RelatorioDespesas {
	
	private Calculadora calculadora;
	private SistemaOperacional sistemaOperacional;
	
	private String relatorio;
	
	public RelatorioDespesas(SistemaOperacional sistemaOperacional, Calculadora calculadora) {
		this.calculadora = calculadora;
		this.sistemaOperacional = sistemaOperacional;
	}
	
	public void preparaRelatorio(Iterator<Despesa> despesas) {
		float totalDespesas = calculadora.calculaTotalDespesas(despesas);
		String conteudo = "Relatório de Despesas";
		conteudo += "\n Total das despesas:" + totalDespesas;
		this.relatorio = conteudo;
	}
	
	public String getRelatorio() {
		return this.relatorio;
	}
	
	public void imprimeRelatorio() {
		Impressora impressora = sistemaOperacional.getDriverImpressao();
		impressora.imprimir(relatorio);
	}
	
}