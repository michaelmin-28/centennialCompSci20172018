import java.util.Scanner;

public class Conditionals {
	
		public Conditionals() {
			
		}
		public void gpaCheck() {
			System.out.print("What's your GPA? ");
			Scanner whatsGPA = new Scanner(System.in);
			double GPA = whatsGPA.nextDouble();
			whatsGPA.close();
			if (GPA >= 3.5 && GPA <= 4) {
				System.out.println("You have a GPA of " + GPA + ", so you can go to the movies.");
			}
			// Print "study" 3.5 > GPA >= 3.0
			if (GPA < 3.5 && GPA >= 3) {
				System.out.println("You have a GPA of " + GPA + ", so you should stay in and study.");
			}
			// Print "drop out" 3 > GPA
			if (GPA < 3) {
				System.out.println("Drop out - your grade is terrible.");
			}
		}
}
