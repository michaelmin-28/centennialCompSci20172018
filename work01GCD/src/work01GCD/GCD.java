package work01GCD;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class GCD {

	public static void main(String[] args) throws FileNotFoundException {
		GCDRunner GCD = new GCDRunner();
		GCD.readerFunction();
		

	}

}

class GCDRunner {
	public GCDRunner() {
	}
	
	public void readerFunction() throws FileNotFoundException {
		Scanner file = new Scanner(new File("/home/student/Eclipse/work01GCD/src/work01GCD/GCD01data.dat"));
		while(file.hasNextLine()) {
			while(file.hasNextInt()) {
				boolean solvedYet = false;
				int GCD = 1;
				int firstNum = file.nextInt();
				int secondNum = file.nextInt();
				int max = Math.max(firstNum, secondNum);
				int min = Math.min(firstNum, secondNum);
				int[] maxListDivs = new int[max + 1];
				int[] minListDivs = new int [min + 1];
				for (int i = 1; i <= max; i++) {
					if ((max % i) == 0) {
						maxListDivs[i] = i;
					}
				}
				for (int i = 1; i <= min; i++) {
					if ((min % i) == 0) {
						minListDivs[i] = i;
						System.out.println(i);
					}
				}
				int maxVal = Integer.MIN_VALUE;
				for(int i=0; i + 1 <= minListDivs.length; i++){
				    if(minListDivs[i] > maxVal){
				        maxVal = minListDivs[i];
				    }
				}
				int isItGCD = Arrays.binarySearch(maxListDivs, maxVal);
				if (isItGCD >= 0) {
					GCD = maxVal;
					System.out.println(GCD);
				}
				else {
					while(solvedYet == false) {
						maxVal = Integer.MIN_VALUE;
						for(int i=0; i + 1 <= minListDivs.length-1; i++){
						    if(minListDivs[i] > maxVal){
						        maxVal = minListDivs[i];
						    }
						}
						if (isItGCD >= 0) {
							GCD = maxVal;
							System.out.println(GCD);
							solvedYet = true;
						}
					}
				}
				// Original uncomplete draft; better version above
				/*
				if ((Math.max(firstNum, secondNum) % Math.min(firstNum, secondNum) == 0)) {
					System.out.println("The GCD of " + firstNum + " and " + secondNum + " is " + Math.min(firstNum, secondNum));
				}	
				else {
					boolean dividedYet = false;
					while (dividedYet == false) {
						start = start.nextProbablePrime();
						if ((Math.min(firstNum, secondNum) % start.intValue()) == 0) {
						}
					}
					
					
				}
				*/
			}
			
			
		}
		
		file.close();
		return;
	}
	
}
