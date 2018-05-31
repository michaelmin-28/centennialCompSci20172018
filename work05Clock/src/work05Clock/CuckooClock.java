package work05Clock;

public class CuckooClock extends Clock {

	public CuckooClock(ClockType type, double drift) {
		super(type, drift);
	}
	
	public void display() {
		System.out.println(getClockType() + ", cuckoo clock, time [" + time.formattedTime() + " ], total drift = "
			+ time.getTotalDrift());
	}
}
