public class Loops {

	// MICHAEL MIN, P2B
	public static void main(String[] args) {
		Loops Quiz = new Loops();
		Quiz.powerOfTwo(1);
		Quiz.sumNums(3, 5);
		Quiz.avgNums(0,4);
	}

	public Loops() {
		// Nothing to do here
	}
	
	public int powerOfTwo(int power) {
		int x = 0;
		// This is question 1 of the quiz.
		do {
			System.out.println("Number returned: 2^" + power + " = " + Math.pow(2, power));
			x++;
		} while(x < 1);
		return power;
	}
	
	public int sumNums(int start, int stop) {
		int s = 0;
		for (; start <= stop; start++) {
			s = start + s;
		}
		System.out.println(s);
			
		return stop;
		// This is question 2 of the quiz.
	}
	
	public float avgNums(float start, float stop) {
		float begStart = start;
		float a = 0;
		while (start <= stop) {
			a = start + a;
			start++;
			
		}
		System.out.println("Your number is " + (a / (stop - begStart + 1)));
		return stop;

		// This is question 3 of the quiz.
	}
}
