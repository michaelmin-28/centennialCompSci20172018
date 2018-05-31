package note14Recursion;

public class Recursion {

	public static void main(String[] args) {
		System.out.println(factoral(4));
		System.out.println(nonRecFac(4));
		System.out.println(alphabet((int)('n')));
		System.out.println(bitCount(4));
		System.out.println(bitCount(1024));
	}

	public static int factoral(int number) {
		int result = 0;
		if(number == 1) {
			result = 1;
		}
		else {
			System.out.println("Process factorial: " + number);
	
			System.out.println("    Recursion: " + (number - 1));
			result = number * factoral(number - 1);
		}
		System.out.println("returning result: " + result);
		return(result);
	}
	
	// Better version here hehe
	public static int nonRecFac(int number) {
		int result = 1;
		for(int y = number; y > 1; y--) {
			result = result * y;
			System.out.print(result + " ");
		}
		return result;
	}
	// Our goal is to return all characters after the chosen letter specified by the parameter
	public static String alphabet(int code) {
		String result;
		if (code == (int)('z')) {
			result = "z";
		}
		else {
			result = (char)(code) + alphabet(code+1);
		}
		return result;
	}
	
	public static int bitCount(int number) {
		int time = 0;
		if (number <= 1) {
			time = 1;
		}
		else {
			time = 1 + bitCount(number / 2);
		}
		return time;
	}
}
