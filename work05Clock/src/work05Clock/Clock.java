package work05Clock;

public abstract class Clock implements TimePiece{

	private ClockType clockType;
	protected Time time;
 
	
	public enum ClockType{
		natural, mechanical, digital, quantum
	}

	public Clock(ClockType type, double drift) {
		this.clockType = type;
		time = new Time(0, 0, 0, drift);
	}
	
	public ClockType getClockType() {
		return(clockType);
	}
	
	
	public void reset() {
		time.resetToStartTime();
	}
	
	public void tick() {
		time.incrementTime(); 		
	}
	
	public abstract void display();
}
