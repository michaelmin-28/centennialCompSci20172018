package note13Lists;
import java.util.ArrayList;
public class ListTests {

	public static void main(String[] args) {
		System.out.println("Begin here for ArrayList");
		// Call the welcome() function
		welcome();
		// ArrayLists are dynamically sized and use methods to access data
		// This is an ArrayList of Integers
		// ArrayLists can only hold classes
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(15);
		System.out.println(numbers + " Adding numbers into the ArrayList");
		numbers.add(1, 12);
		System.out.println(numbers + " Placing a number into the ArrayList - it'll "
				+ "shift other numbers ahead. ");
		numbers.set(1, 13);
		System.out.println(numbers + " Changing the value of a number in the ArrayList.");
		numbers.remove(2);
		System.out.println(numbers + " Removing the number at index 2 in the ArrayList.");
		Integer testThis = 13;
		numbers.remove(testThis);
		System.out.println(numbers + " Removing a specific number at any index in the ArrayList. ");
		
		numbers.add(14);
		numbers.add(15);
		// Get values from the list
		Integer first = numbers.get(0);
		Integer second = numbers.get(1);
		System.out.println(first + " and " + second + " is " + (first + second));
		
		// Loop through a list
		for (int dex = 0; dex < numbers.size(); dex++) {
			System.out.print(numbers.get(dex) + " ");
		}
		
		System.out.println();
		
		// Loop revisited oWo
		for (Integer numb : numbers) {
			System.out.print(numb +  " ");
		}
		System.out.println("\n");
		average(numbers);
		
		smallest(numbers);
		
		unique(numbers);
		numbers.add(10);
		
		unique(numbers);
	}

	// Create a private static function that prints a "Welcome" message
	// Call it welcome(); it'll take no parameters, and return 'void'
	
	private static void welcome() {
		System.out.println("Welcome! These are notes about ArrayLists. ");
	}
	
	// Create a private static function that takes an ArrayList<Integer> list
	// as a parameter and it returns the average of all integers in the list
	
	private static double average(ArrayList<Integer> aL) {
		double total = 0.0;
		int nums = 0;
		for (int i = 0; i < aL.size(); i++) {
			total += aL.get(i);
			nums++;
		}
		total = total/nums;
		System.out.println(total);
		return total;
	}
	
	// Create a private static function that takes an ArrayList<Integer> list
	// as a parameter and it returns the smallest value in the list
	private static int smallest(ArrayList<Integer> aL) {
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < aL.size(); i++) {
			if (max > aL.get(i)) {
				max = aL.get(i);
			}
		}
		System.out.println(max);
		return max;
	}
	
	// Create a private static function that takes an ArrayList<Integer> list
	// as a parameter and it returns TRUE if the list contains duplicate numbers or
	// FALSE if all values are unique or if the list is empty.
	
	private static boolean unique(ArrayList<Integer> al) {
		boolean end = true;
		if (al.size() == 0) {
			end = false;
		}
		for (int i = 0; i < al.size(); i++) {
			if (i + 1 < al.size() - 1) {
				for (int k = i + 1; k < al.size(); k++) {
					if (al.get(i) == al.get(k)) {
						end = false;
					}
				}
			}
		}
		System.out.println(end);
		return end;
	}
	
}


