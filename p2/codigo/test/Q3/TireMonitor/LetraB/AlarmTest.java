package Q3.TireMonitor.LetraB;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class AlarmTest {

	private Alarm alarm;

	@Mock
	private SensorInterface mockSensor;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		alarm = new Alarm(mockSensor);
	}
	
	@Test
	public void alarmOffByDefault() {
		assertFalse(alarm.isAlarmOn());
	}

	@Test
	public void whenPressureBelowThresholdThenAlarmOn() {
		Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(Alarm.LOW_PRESSURE_THRESHOLD - 1);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	public void whenPressureWithinThresholdThenAlarmOff() {
		Mockito.when(mockSensor.popNextPressurePsiValue())
				.thenReturn((Alarm.LOW_PRESSURE_THRESHOLD + Alarm.HIGH_PRESSURE_THRESHOLD) / 2);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}

	@Test
	public void whenPressureAboveThresholdThenAlarmOn() {
		Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(Alarm.HIGH_PRESSURE_THRESHOLD + 1);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
}
