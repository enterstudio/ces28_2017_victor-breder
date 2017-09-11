import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControladorPTCTest {
	
	@Mock private Datacenter dataCenter;
	@Mock private PainelCondutor painelCondutor;
	@Mock private Sensor sensor;
	
	private ControladorPTC controladorPTC;
	
	@Before
	public void setUp() {
		controladorPTC = Mockito.spy(new ControladorPTC(sensor, dataCenter, painelCondutor));
	}
	
	// LETRA A
	@Test
	public void whenContructedExpectNotNull() {
		assertNotNull(controladorPTC);
	}

	// LETRA B
	@Test
	public void whenNotInCrossingExpectNonPriorityMessages() {
		Mockito.when(sensor.isCruzamento()).thenReturn(false);
		
		controladorPTC.run();
		
		Mockito.verify(controladorPTC, Mockito.times(1)).enviaMsgNormalPainel(Mockito.any(), Mockito.any());
		Mockito.verify(controladorPTC, Mockito.times(0)).enviaMsgPrioritariaPainel(Mockito.any(), Mockito.any());
		Mockito.verify(controladorPTC, Mockito.times(1)).enviaMsgDatacenter(Mockito.any(), Mockito.any());
		Mockito.verify(controladorPTC, Mockito.times(0)).diminuiVelocidade(Mockito.anyDouble());
		Mockito.verify(controladorPTC, Mockito.times(0)).aumentaVelocidade(Mockito.anyDouble());
	}
	
	// LETRA C
	@Test
	public void whenInCrossingFasterThan100KmhExpectPriorityMessageAndNoChangeInSpeed() {
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(sensor.getVelocidade()).thenReturn(120.0);
		// Operator saw warning and confirmed that train should maintain speed 
		Mockito.when(painelCondutor.imprimirAviso(Mockito.anyString(), Mockito.anyInt())).thenReturn(true);
		
		controladorPTC.run();
		
		Mockito.verify(controladorPTC, Mockito.times(1)).enviaMsgPrioritariaPainel(Mockito.any(), Mockito.any());
		Mockito.verify(controladorPTC, Mockito.times(0)).diminuiVelocidade(Mockito.anyDouble());
		Mockito.verify(controladorPTC, Mockito.times(0)).aumentaVelocidade(Mockito.anyDouble());
	}
	
	// LETRA D
	@Test
	public void whenInCrossingSlowerThan20KmhExpectPriorityMessageAndSpeedUp() {
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(sensor.getVelocidade()).thenReturn(10.0);
		// Operator did not see warning
		Mockito.when(painelCondutor.imprimirAviso(Mockito.anyString(), Mockito.anyInt())).thenReturn(false);
		
		controladorPTC.run();
		
		Mockito.verify(controladorPTC, Mockito.times(1)).enviaMsgPrioritariaPainel(Mockito.any(), Mockito.any());
		Mockito.verify(controladorPTC, Mockito.times(0)).diminuiVelocidade(Mockito.anyDouble());
		Mockito.verify(controladorPTC, Mockito.times(1)).aumentaVelocidade(Mockito.anyDouble());
	}
	
}
