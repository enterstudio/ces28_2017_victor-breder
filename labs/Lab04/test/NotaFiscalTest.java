import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import NotaFiscal.ItemVenda;
import NotaFiscal.NotaFiscal;
import ProdutoServico.Component;

public class NotaFiscalTest {

	NotaFiscal notaFiscal;
	ItemVenda itemVenda1;
	ItemVenda itemVenda2;
	ItemVenda itemVenda3;
	@Mock Component component1;
	@Mock Component component2;
	@Mock Component component3;
	
	@Before
	public void setup() {
		notaFiscal = new NotaFiscal();
		itemVenda1 = new ItemVenda(component1);
		itemVenda2 = new ItemVenda(component2);
		itemVenda3 = new ItemVenda(component3);
	}
	
	@Test
	public void testaCriacaoNotaFiscal() {
		assertNotNull(notaFiscal);
	}
	
	@Test
	public void testaGetItemCount() {
		assertEquals(0, notaFiscal.getItemCount());
		notaFiscal.adicionaItemVenda(itemVenda1);
		assertEquals(1, notaFiscal.getItemCount());
		notaFiscal.adicionaItemVenda(itemVenda2);
		assertEquals(2, notaFiscal.getItemCount());
		notaFiscal.adicionaItemVenda(itemVenda3);
		assertEquals(3, notaFiscal.getItemCount());
	}
	
	@Test
	public void testaFechar() {
		assertFalse(notaFiscal.isFechada());
		notaFiscal.fechar();
		assertTrue(notaFiscal.isFechada());
	}
	
	@Test
	public void testaNotaFechadaImutavel() {
		notaFiscal.adicionaItemVenda(itemVenda1);
		notaFiscal.fechar();
		assertEquals(1, notaFiscal.getItemCount());
		int id = notaFiscal.getId();
		
		// alteracoes depois de fechada devem ser ignoradas
		notaFiscal.setId(id + 10);
		notaFiscal.adicionaItemVenda(itemVenda2);
		notaFiscal.adicionaItemVenda(itemVenda3);
		
		// verifica se nota nao foi alterada
		assertEquals(id, notaFiscal.getId());
		assertEquals(1, notaFiscal.getItemCount());
	}

}
