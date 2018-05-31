package work05Clock;

public class WristWatch extends Clock{
	public WristWatch(ClockType type, double drift) {
		super(type, drift);
	}
	
	public void display() {
		System.out.println(getClockType() + ", wrist watch, time [" + time.formattedTime() + " ], total drift = "
				+ time.getTotalDrift());
	}
}
