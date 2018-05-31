public class IfLoop {

	public static void main(String[] args) {
		// The basic IF structure
		// if (false) {
		//	System.out.println("The expression is true.");
		//}
		
		//else {
		//	System.out.println("The expression is false.");
		//}

		// Set a variable 'a' to a value . //
		int a = 0;
		// Print "negative" if it's less than 0. //
		if (a < 0) {
			System.out.println("The variable is negative.");
		}
		// Print "positive" if it's greater than 0. // 
		if (a > 0) {
			System.out.println("The variable is positive.");
		}
		// Print "zero" if equal to zero. // 
		else if (a == 0) {
			System.out.println("The variable is zero.");
		}
		/*
		// Set a GPA.
		float gpa = 3.2f;
		// Print "You can go to the movie." if 4 >= GPA >= 3.5
		if (gpa >= 3.5 && gpa <= 4) {
			System.out.println("You have a GPA of " + gpa + ", so you can go to the movies.");
		}
		// Print "study" 3.5 > GPA >= 3.0
		if (gpa < 3.5 && gpa >= 3) {
			System.out.println("You have a GPA of " + gpa + ", so you should stay in and study.");
		}
		// Print "drop out" 3 > GPA
		if (gpa < 3) {
			System.out.println("Drop out - your grade is terrible.");
		}
		*/
		
		/*Conditionals movieTime = new Conditionals();
		movieTime.gpaCheck();
		*/
		
		
		// 3 components to every loop
		// 1) START of the loop; initialize; variant
		// 2) MODIFY the loop; change; modify; assign; write
		// 3) STOP; Conditionals; IFs; comparisons;
		
		
		// Write a FOR loop that prints out number 1 through 10 //
		for (int x = 1; x < 11; x++) {
			System.out.println(x + " ");
		}
		System.out.println(" ");
		// Write a WHILE loop that prints the fibonacci sequence up to 100,000 //
		int firstNumber = 0;
		int secondNumber = 1;
		int combinedNumber = firstNumber + secondNumber;
		System.out.println(secondNumber);
		while(combinedNumber <= 100000) {
			System.out.println(combinedNumber + " ");
			firstNumber = secondNumber;
			secondNumber = combinedNumber;
			combinedNumber = firstNumber + secondNumber;
		}
		
		System.out.println(" ");
		
		// Examples of a DO-WHILE loop
		// int KLAPPA = lmao;
		// int kappaPRIDE = lmoa;
		// do
		// {
		// 		System.out.println(kappaPride);
		// 		kappaPRIDE = KLAPPA + kappaPRIDE;
		// }
		// while (kappaPRIDE = lmoa);
		
		// Refactor the while loop into a DO loop //
		int firstTerm = 0;
		int secondTerm = 1; 
		int combinedTerm = firstTerm + secondTerm;
		do
		{
			System.out.println(secondTerm + " ");
			firstTerm = secondTerm;
			secondTerm = combinedTerm;
			combinedTerm = firstTerm + secondTerm;
			
		}
		while (secondTerm <= 100000);
	}
	
}