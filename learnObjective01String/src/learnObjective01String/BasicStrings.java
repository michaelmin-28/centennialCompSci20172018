package learnObjective01String;
import java.util.Scanner;

public class BasicStrings {

	

	public static void main(String[] args) {
		BasicStrings strings = new BasicStrings();
		strings.passwordCheck();

	}

	public BasicStrings() {
		// The constructor of the file.
	}
	
	// This function checks your password security as a string.
	// LOs completed: 1; 2; 3;
	// LO 1: uses strings
	// LO 2: loops to process strings
	// LO 3: conditionally activates the loop on the string depending on the numbers within the string.
	private String passwordCheck() {
		// Open the variable password as a 'Scanner'.
		Scanner password;
		// Explain what the function does.
		System.out.println("This program will check your password security.");
		System.out.print("Please type your password in. ");
		// Obtain the password as a string from the user.
		password = new Scanner (System.in);
		String realPW = password.nextLine();
		// Find the length of the password.
		int pwLength = realPW.length();
		// Find the number of numbers in the password.
		int numbOfNumbs = 0;
		for (int l = 0; l < realPW.length(); l++) {
			char Numbs = realPW.charAt(l);
			if (Numbs == '0'  || Numbs == '1' || Numbs == '2' || Numbs == '3' || Numbs == '4' || Numbs == '5' || Numbs == '6'|| Numbs == '7' || Numbs == '8' || Numbs == '9') {
				numbOfNumbs = numbOfNumbs + 1; 
			}
			
		}
		// Find the number of symbols in the password.
		int numOfSyms = 0;
		for (int l=0; l < realPW.length(); l++ ) {
			char Syms = realPW.charAt(l);
			if (Syms == '!' || Syms == '@' || Syms == '#' || Syms == '%' || Syms == '^' || Syms == '&' || Syms == '*' || Syms == '(' || Syms == ')' || Syms == ',' || Syms == '.') {
				numOfSyms = numOfSyms + 1;
			}
		}
		
		// If the password is both at least 12 and at most 25% of the password is numbers, this password is 'secure'.
		if (pwLength >= 12 && numbOfNumbs + numOfSyms <= (pwLength/4)) {
			System.out.println("Your password is very secure!");
		}
		else {
			// If the password is too short, it displays this message.
			if (pwLength < 12) {
				System.out.println("Consider lengthening your password.");
			}
			// If the password is more than 25% numbers, it displays this message.
			else {
				System.out.println("Your password isn't secure - use more letters in place of numbers or symbols.");
			}
		}
		password.close();
		return realPW;
	}
}