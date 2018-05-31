package work05Clock;

public class AtomicClock extends Clock{
	public AtomicClock(ClockType type, double drift) {
		super(type, drift);
	}
	
	public void display() {
		System.out.println(getClockType() + ", atomic clock, time [" + time.formattedTime() + " ], total drift = "
				+ time.getTotalDrift());
	}
}
