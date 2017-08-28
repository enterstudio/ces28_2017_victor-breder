import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import nf.Cliente;
import nf.DBCliente;
import nf.DBProdutoInterface;
import nf.ItemInterface;
import nf.NotaFiscal;
import nf.VerificadorCPF;

import static org.junit.Assert.*;

public class DBTest {
	
	private String cpf1 = "12312312312";
	private String cpf2 = "32132132132";
	private String cpf3 = "11111111111";
	
	private NotaFiscal notaFiscal;
	
	@Mock private DBCliente dbCliente;
	@Mock private DBProdutoInterface dbProduto;
	@Mock private VerificadorCPF verificadorCPF;
	@Mock private ItemInterface item1;
	@Mock private ItemInterface item2;
	@Mock private ItemInterface item3;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(dbCliente.getCliente(cpf1))
			.thenReturn(new Cliente(cpf1, "Joao", "", ""));
		Mockito.when(verificadorCPF.verificar(cpf1)).thenReturn(true);
		
		Mockito.when(dbCliente.getCliente(cpf2))
			.thenReturn(new Cliente(cpf2, "Maria", "", ""));
		Mockito.when(verificadorCPF.verificar(cpf2)).thenReturn(false);
		
		Mockito.when(dbCliente.getCliente(cpf3))
			.thenReturn(new Cliente(cpf3, "Jose", "", ""));
		Mockito.when(verificadorCPF.verificar(cpf3)).thenReturn(true);
		
		notaFiscal = new NotaFiscal(dbCliente.getCliente(cpf3), verificadorCPF);
		
		Mockito.when(item1.getNome()).thenReturn("Lapis");
		Mockito.when(item1.getPreco()).thenReturn(100);
		Mockito.when(item2.getNome()).thenReturn("Caneta");
		Mockito.when(item2.getPreco()).thenReturn(200);
		Mockito.when(item3.getNome()).thenReturn("Borracha");
		Mockito.when(item3.getPreco()).thenReturn(1300);
	}
	
	@Test
	public void whenCPFIsValidThenCreateClient() {
		Cliente cliente = dbCliente.getCliente(cpf1);
		NotaFiscal nf = new NotaFiscal(cliente, verificadorCPF);
		Mockito.verify(verificadorCPF, Mockito.times(1)).verificar(cpf1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void whenCPFIsInvalidThenThrowException() {
		Cliente cliente = dbCliente.getCliente(cpf2);
		NotaFiscal nf = new NotaFiscal(cliente, verificadorCPF);
		Mockito.verify(verificadorCPF, Mockito.times(1)).verificar(cpf2);
	}
	
	@Test
	public void whenAddedOrRemovedItemsExpectCorrectValueSum() {
		notaFiscal.addItem(item1, 1);
		notaFiscal.addItem(item2, 2);
		assertEquals(500, notaFiscal.getValorTotal());
		notaFiscal.removeItem(1);
		assertEquals(100, notaFiscal.getValorTotal());
		notaFiscal.addItem(item3, 1);
		assertEquals(1400, notaFiscal.getValorTotal());
	}

}
