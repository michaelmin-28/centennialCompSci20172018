package work03Hangman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Hanger {

	public static void main(String[] args) throws FileNotFoundException{
		// Start the game
		Wordfinder hangman = new Wordfinder();
		hangman.fileReader();
		hangman.gameStarter();
	}
}

class Wordfinder {
	// Classwide variables to use
	private Scanner file;
	private Scanner fileNum;
	private int lineNum = 0;
	private String word;
	private String[] arrayStrings;
	private Scanner in;

	// Constructor; nothing here
	public Wordfinder() {
		
	}
	// Looks at the file to get data
	public String[] fileReader() throws FileNotFoundException {
		fileNum = new Scanner(new File("/home/student/Eclipse/hangmanText.txt"));
		// Gets the number of lines within the data, excluding whitespace
		while(fileNum.hasNextLine()) {
			String screen = fileNum.nextLine();
			if (screen.isEmpty() == false) {
				lineNum++;
			}
		}
		file = new Scanner(new File ("/home/student/Eclipse/hangmanText.txt"));
		// Creates a String array with the size of the lines above
		String[] wordArray = new String [lineNum + 1];
		// Add the words into the String array
		for (int i = 1; file.hasNextLine(); i++) {
			word = file.nextLine();
			if (word.isEmpty() == false) {
				wordArray[i] = word;
			}
			if (word.isEmpty() == true) {
				i--;
			}
		}
		// Set the String array to work classwide
		this.arrayStrings = wordArray;
		return wordArray;
	}
	
	public void gameStarter() {
		// Initialize variables
		int wordArraySize = arrayStrings.length;
		int solvedYet = arrayStrings.length;
		int[] chosenIndex = new int[wordArraySize];
		Map <Character, Integer> wordMap = new HashMap<Character, Integer>();
		Map <Character, Integer> guessedLetts = new HashMap<Character, Integer>();
		// Tell the player what is happening
		System.out.println("Welcome to Hangman. \nYou are allowed 6 wrong guesses.");
		// While there are still words to be solved:
		while (solvedYet != 0) {
			// Initialize variables that apply to each individual word
			boolean wordSolve = false;
			guessedLetts.clear();
			wordMap.clear();
			int guessesLeft = 7;
			String wordholder = "";
			// Choose a random word
			int chooseWord = (int) (Math.random() * (wordArraySize - 1)) + 1;
			// Ensure that you don't double up for words
			if (chosenIndex[chooseWord] != chooseWord) {
				chosenIndex[chooseWord] = chooseWord;
				int wordLength = arrayStrings[chooseWord].length();
				// Tell the player how long the word is
				System.out.println("Your word has " + wordLength + " letters.");
				for(int i = 0; i < wordLength; i++) {
					wordholder = wordholder + "-";
				}
				System.out.println(wordholder);
				// Place the letters of the word into a map
				for(int i = 0; i < wordLength; i++) {
					wordMap.put(arrayStrings[chooseWord].charAt(i), i);
				}
				// While there are still guesses left and the word has not been solved
				while(wordSolve != true && guessesLeft > 1) {
					// Find the player's next guess
					in = new Scanner(System.in);
					System.out.println("What letter do you guess?");
					String guess = in.nextLine();
					// Prevent guesses of 0 length or longer than a character
					while(guess.length() == 0 || guess.length() > 1) {
						System.out.println("You can't do that.");
						guess = in.nextLine();
					}
					char guessChar = guess.charAt(0);
					// Prevent guesses that aren't alphabetical
					while(guessChar < 'a' || guessChar > 'z') {
						System.out.println("You can't do that.");
						guess = in.nextLine();
						guessChar = guess.charAt(0);
					}
					// Prevent guesses that have already been attempted.
					while(guessedLetts.containsKey(guessChar)) {
						System.out.println("You've already guessed that. ");
						guess = in.nextLine();
						guessChar = guess.charAt(0);
					}
					// If the letter exists
					if (arrayStrings[chooseWord].indexOf(guessChar) >= 0) {
						System.out.println("That's right! " + 
							guessChar + " is a letter.");
						System.out.println("You have " + (guessesLeft - 1) + 
								" guesses left. " );
						// Remove the letter from the map
						wordMap.remove(guessChar);
						guessedLetts.put(guessChar, 1);
						// Print a statement showing the placement of letters in the word
						for(int i = 0; i < wordLength; i++) {
							// Add the guessed letter to the statement
							if (arrayStrings[chooseWord].charAt(i) == guessChar) {
								wordholder = wordholder + guessChar;
							}
							// Keep unguessed letters hidden
							else if(wordholder.charAt(i) == '-') {
								wordholder = wordholder + '-';
							}
							// Continue to show guessed letters
							else if(wordholder.charAt(i) != '-'){
								wordholder = wordholder + wordholder.charAt(i);
							}
						}
						wordholder = wordholder.substring((wordholder.length()/2),wordholder.length());
						System.out.println(wordholder);
						// If all the letters have been guessed
						if(wordMap.isEmpty() == true) {
							solvedYet--;
							wordSolve = true;
							System.out.println("\nCongratulations on getting the word!");
							System.out.println("The word was '" + arrayStrings[chooseWord] + "'." );
						}
					}
					// Otherwise
					else {
						System.out.println("Sorry, " + guessChar + " is not a letter.");
						guessesLeft--;
						System.out.println("You have " + (guessesLeft - 1) + 
								" guesses left. " );
						guessedLetts.put(guessChar, 1);
						// If no guesses left
						if (guessesLeft == 1) {
							System.out.println("\nYou didn't get the word...");
							System.out.println("The word was '" + arrayStrings[chooseWord] + "'." );
							solvedYet--;
						}
					}
				}
			}
		}
	}
}