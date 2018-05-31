package prj01_GuessMyNumber;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// Construct a match to play the game
		Match time = new Match();
	}
}

class Match {

	Match () {
		System.out.println("Create a match.");
		int winCondition = 0;

		
		// Instantiate a 'Guess' and 'Secret' number.
		Secret sec = new Secret();
		Guess attempt = new Guess();
		
		// Tell the rules of the game.
		System.out.println("\nLet's play a game. It's called 'Guess My Number." + "\nIn it, you'll have 7 attempts to try and guess my number, which is between 1 and 99, inclusive - I'll give you hints! \nGood luck!");
		
		
		// Do the first time of the game
		attempt.setGuess();
		attempt.setAttempts();
		
		// Enter the loop
		while ((attempt.getAttempts() < attempt.maxAttempts()) && (winCondition == 0)) {
			// Compare the two values.
			if (attempt.getGuess() < sec.getSecret()) {
				System.out.println("Your guess was too LOW; try again.");
				System.out.println("That was attempt number " + attempt.getAttempts() + ".");
				attempt.setGuess();
			}
			if (attempt.getGuess() > sec.getSecret()) {
				System.out.println("Your guess was too HIGH; try again.");
				System.out.println("That was attempt number " + attempt.getAttempts() + ".");
				attempt.setGuess();
			}
			if (attempt.getGuess() == sec.getSecret()) {
				System.out.println("Your guess was just right!");
				winCondition = 1;
			}	
			
			attempt.setAttempts();
		}
		
		if (winCondition == 0) {
			System.out.println("\nYou didn't win...");
			System.out.println("The number was: " + sec.getSecret());
		}
		
		else if (winCondition == 1) {
			System.out.println("\nCongratulations on getting my number!");
		}
}

// The class to generate the random 'secret' number. // 
class Secret {
	private int number = 0;
	
	Secret() {
		// Setting up a random generator class
		Random rand = new Random();
		// Think of a number between 1 and 99 (inclusive)
		this.number = rand.nextInt(99) + 1;
	
	}
	
	int getSecret() {
		return(this.number);
	}
}

// The class to obtain guesses and track attempts. // 
class Guess {
	private int number = 0;
	private int numOfAttempts = 0;
	
	Scanner keyboard;
	
	Guess() {
		keyboard = new Scanner(System.in);	
	}
	
	// Function to allow access to the user's guess.
	int getGuess() {
		return(this.number);
	}
	
	// This function/method has the responsibility to ask the user for 
	// their guess.
	void setGuess() {
		System.out.print("\nWhat's your guess? ");
		this.number = keyboard.nextInt();
	}
	
	int getAttempts() {
		return(this.numOfAttempts);
	}
	
	void setAttempts() {
		numOfAttempts++;
	}
	
	int maxAttempts() {
		return(7);
	}
}
}