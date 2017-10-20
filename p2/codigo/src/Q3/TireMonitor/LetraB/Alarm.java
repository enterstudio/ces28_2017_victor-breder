package Q3.TireMonitor.LetraB;

public class Alarm {
	public static final double LOW_PRESSURE_THRESHOLD = 17;
	public static final double HIGH_PRESSURE_THRESHOLD = 21;
	
	private SensorInterface sensor;

	private boolean alarmOn = false;

	public Alarm(SensorInterface sensor) {
		this.sensor = sensor;
	}

	public void check() {
		double psiPressureValue = sensor.popNextPressurePsiValue();

		if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
			alarmOn = true;
		}
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}
}