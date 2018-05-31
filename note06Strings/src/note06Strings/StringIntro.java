package note06Strings;

public class StringIntro {

	public static void main(String[] args) {
		System.out.println("Start 'String' practice.");
		int numNative = 5;
		System.out.println(numNative);
		Integer numClass = new Integer(3);
		System.out.println(numClass);

		// Change the value of the Native type
		numNative = numNative + 50;
		
		// Change the value of the Class type
		numClass = numClass + 45;

		System.out.println(numNative);
		System.out.println(numClass);
		
		// Declare a string.
		String myString1 = new String("BOISE");
		// Print the first character of the string
		System.out.println(myString1.charAt(0));
		// Print the length of the string
		System.out.println(myString1.length());
		// Write charAt() test cases to check what happens with invalid parameters.
		
		// System.out.println(myString1.charAt(5));
		// System.out.println(myString1.charAt(-1));
		
		// Print each character of the string on a separate line.
		for (int x = 0;x < myString1.length(); x++) {
			System.out.print(myString1.charAt(x));

		}
		StringTest vowelChecker = new StringTest();
		vowelChecker.vow("AA");
	}

}

class StringTest {
	public StringTest() {
		
	}
	
	public String vow(String str) {
		// Write a class method that accepts a String parameter. Return "yes" if 
		// the first letter or last letter is a vowel. Otherwise, return "no."
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (i == 0 || i == str.length() - 1) {
				if (current == 'a' || current == 'A' || current == 'e' || current == 'E' || current == 'i' || current == 'I' || current == 'o' || current == 'O' || current == 'u' || current == 'U') {
					System.out.println("Yes.");
					break;
				}
			}
		
	} return("test");
}
}
