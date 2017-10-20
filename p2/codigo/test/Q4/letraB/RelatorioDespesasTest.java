package Q4.letraB;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Q4.letraA.Calculadora;
import Q4.letraA.Despesa;
import Q4.letraA.Impressora;
import Q4.letraA.RelatorioDespesas;
import Q4.letraA.SistemaOperacional;

public class RelatorioDespesasTest {

	@Mock
	private SistemaOperacional sistemaOperacionalMock;

	@Mock
	private Impressora impressoraMock;

	@Mock
	private Calculadora calculadoraMock;

	private RelatorioDespesas relatorioDespesa;
	private ArrayList<Despesa> despesas;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(sistemaOperacionalMock.getDriverImpressao()).thenReturn(impressoraMock);
		
		despesas = new ArrayList<Despesa>();
		despesas.add(new Despesa(100));
		despesas.add(new Despesa(200));
		despesas.add(new Despesa(50));
		despesas.add(new Despesa(10));
		
		Mockito.when(calculadoraMock.calculaTotalDespesas(Mockito.any())).thenReturn(360f);
		
		relatorioDespesa = new RelatorioDespesas(sistemaOperacionalMock, calculadoraMock);
	}

	@Test
	public void testPrepararRelatorioDespesas() {
		relatorioDespesa.preparaRelatorio(despesas.iterator());
		String relatorio = relatorioDespesa.getRelatorio();
		assertEquals("Relatório de Despesas\n Total das despesas:360.0", relatorio);
	}

	@Test
	public void testImprimirRelatorioDespesas() {
		relatorioDespesa.preparaRelatorio(despesas.iterator());
		relatorioDespesa.imprimeRelatorio();
		Mockito.verify(impressoraMock, Mockito.times(1)).imprimir("Relatório de Despesas\n Total das despesas:360.0");
	}

}
