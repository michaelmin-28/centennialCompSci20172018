package work05Clock;

import java.util.ArrayList;

import work05Clock.Clock.ClockType;

public class ClockSimulation {
	private final static Integer start = 0;
	private final static Integer day = 86400;
	private final static Integer week = 604800;
	private final static Integer month = 2592000;
	private final static Integer year = 31536000;

	public static void main(String[] args) {
		ArrayList<Clock> clockBag = new ArrayList<Clock>();
		
		clockBag.add(new Sundial(ClockType.natural, 0.00));
		clockBag.add(new CuckooClock(ClockType.mechanical, 0.000694444));
		clockBag.add(new GrandfatherClock(ClockType.mechanical, 0.000347222));
		clockBag.add(new WristWatch(ClockType.digital, 0.000034722));
		clockBag.add(new AtomicClock(ClockType.quantum, 0.0));
		
		System.out.println("Before the simulation. \n");
		timeCounter(start, clockBag);
		System.out.println();
		
		System.out.println("After ONE DAY. \n");
		timeCounter(day, clockBag);
		System.out.println();
		
		System.out.println("After ONE WEEK. \n");
		timeCounter(week, clockBag);
		System.out.println();
		
		System.out.println("After ONE MONTH. \n");
		timeCounter(month, clockBag);
		System.out.println();
		
		System.out.println("After ONE YEAR. \n");
		timeCounter(year, clockBag);
		System.out.println();
		}
	
	public static void timeCounter(Integer time, ArrayList<Clock> clockBag) {
		for (Clock clock : clockBag) {
			for (int i = 0; i < time; i++) {
				clock.tick();
			}
			clock.display();
			clock.reset();
		}
		System.out.println();
	}
}
