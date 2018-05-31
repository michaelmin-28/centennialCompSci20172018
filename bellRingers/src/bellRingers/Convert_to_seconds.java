package bellRingers;

import java.util.Scanner;

public class Convert_to_seconds {
	
	

	public static Scanner input; 

	public static void main(String[] args) {
		// Ask for the input. //
		System.out.print("Please give a number of seconds to be converted into hours, minutes, and seconds. ");
		// Save this input as an integer variable. //
		input = new Scanner(System.in);
		int secondsGiven = input.nextInt();
		// Calculate the number of hours in the input, and remove them from the input. //
		int hours = secondsGiven/3600;
		int minutesLeft = secondsGiven - (3600*hours);
		// Calculate the number of minutes in the input, and remove them from the input. //
		int minutes = minutesLeft/60;
		int secondsLeft = minutesLeft - (60*minutes);
		// Print the number of hours, minutes, and seconds to the user. //
		System.out.println("You have " + hours + " hours, " + minutes + " minutes, and " + secondsLeft + " seconds. ");
		
		
	}

}