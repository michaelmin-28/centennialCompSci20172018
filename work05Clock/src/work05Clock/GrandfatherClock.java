package work05Clock;

public class GrandfatherClock extends Clock{
	public GrandfatherClock(ClockType type, double drift) {
		super(type, drift);
	}
	
	public void display() {
		System.out.println(getClockType() + ", grandfather clock, time [" + time.formattedTime() + " ], total drift = "
				+ time.getTotalDrift());
	}
}
