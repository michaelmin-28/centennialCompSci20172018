package work05Clock;

public class Sundial extends Clock{

	public Sundial(ClockType type, double drift) {
		super(type, drift);
	}

	public void display() {
		System.out.println(getClockType() + ", sun dial, time [" + time.formattedTime() + " ], total drift = "
		+ time.getTotalDrift());
	}
}
