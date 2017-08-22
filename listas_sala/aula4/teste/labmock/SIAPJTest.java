package labmock;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SIAPJTest {
	
	private SIAPJ siapj;
	
	@Mock private IServicoEmail mockServicoEmail;
	@Mock private IServicoDB mockServicoDB;
	@Mock private IValidatorProcesso mockValidadorProcesso;
	@Mock private IProcesso mockProcessoValido;
	@Mock private IProcesso mockProcessoInvalido;
	
	@Mock private IProcesso mockProcesso;
	@Mock private Connection mockConnection;
	@Mock private Statement mockStatement;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		siapj = new SIAPJ(mockServicoEmail, mockServicoDB, mockValidadorProcesso);
	}
	
	@Test
	public void testSIAPJContructor() {
		assertNotNull(siapj);
	}
	
	@Test
	public void testSIAPJCriaReclamacaoProcessoValido() throws SQLException {
		Mockito.when(mockProcessoValido.getEmail()).thenReturn("vb@gmail.com");
		Mockito.when(mockValidadorProcesso.validaProcesso(mockProcessoValido)).thenReturn(true);
		Mockito.when(mockServicoDB.persisteProcesso(mockProcessoValido)).thenReturn(1);
		Mockito.when(mockServicoEmail.sendEmail(mockProcessoValido.getEmail(), "Processo Aceito")).thenReturn(true);
		
		siapj.criaReclamacao(mockProcessoValido);
		
		Mockito.verify(mockValidadorProcesso, Mockito.times(1)).validaProcesso(Mockito.any());
		Mockito.verify(mockServicoDB, Mockito.times(1)).persisteProcesso(Mockito.any());
		Mockito.verify(mockServicoEmail, Mockito.times(1)).sendEmail(Mockito.any(), Mockito.any());
	}
	
	@Test
	public void testSIAPJCriaReclamacaoProcessoInvalido() throws SQLException {
		Mockito.when(mockValidadorProcesso.validaProcesso(mockProcessoInvalido)).thenReturn(false);
		Mockito.when(mockServicoEmail.sendEmail(mockProcessoInvalido.getEmail(), "Processo Rejeitado")).thenReturn(true);
		
		siapj.criaReclamacao(mockProcessoInvalido);
		
		Mockito.verify(mockValidadorProcesso, Mockito.times(1)).validaProcesso(Mockito.any());
		Mockito.verifyZeroInteractions(mockServicoDB);
		Mockito.verify(mockServicoEmail, Mockito.times(1)).sendEmail(Mockito.any(), Mockito.any());
	}
	
	@Test
	public void testSIAPCriaReclamacaoComBancoDeDados() throws SQLException {
		Random random = new Random(System.nanoTime());
		Mockito.when(mockProcesso.getID()).thenReturn(random.nextLong());
		Mockito.when(mockProcesso.getNomeReclamante()).thenReturn("Victor Breder");
		Mockito.when(mockProcesso.getTelefone()).thenReturn("12 98765 4321");
		Mockito.when(mockProcesso.getEmail()).thenReturn("vb@gmail.com");
		Mockito.when(mockValidadorProcesso.validaProcesso(mockProcesso)).thenReturn(true);
		Mockito.when(mockServicoEmail.sendEmail(mockProcesso.getEmail(), "Processo Aceito")).thenReturn(true);
		
		Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
		Mockito.when(mockStatement.executeUpdate(Mockito.any())).thenReturn(1);
		
		ServicoDB servicoDB = new ServicoDB();
		servicoDB.setDBConnection(mockConnection);
		SIAPJ siapj = new SIAPJ(mockServicoEmail, servicoDB, mockValidadorProcesso);
		siapj.criaReclamacao(mockProcesso);
		
		Mockito.verify(mockConnection, Mockito.times(1)).createStatement();
		Mockito.verify(mockStatement, Mockito.times(1)).executeUpdate(Mockito.any());
	}

}
