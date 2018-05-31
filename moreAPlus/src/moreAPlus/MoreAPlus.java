package moreAPlus;

public class MoreAPlus {

	public static void main(String[] args) {
		MoreAPlus checker = new MoreAPlus();
		checker.checkForPlus("aplusaplus");
		checker.existAPlus("lmapluslmaolmaopluslmaplusup/");

	}
	
	public MoreAPlus() {
		// The constructor of the file.
	}

	// This function uses multiple if statements to complete the objective.
	// The function to check for multiple a-plus, in either capital or lowercase letters.
	public String checkForPlus(String aPlus) {
		// This variable holds the count of a-plus in the string.
		int numAPlus = 0;
		// Loops through the entire string length
		for (int l = 0; l <= aPlus.length() - 1; l++) {
			// The char 'plus' is whatever is in index 'l' in the string 'aPlus'.
			char plus = aPlus.charAt(l);
			// Checks for 'a' to start off - if 'a' starts, it checks the next letter.
			if (plus == 'a' || plus == 'A') {
				plus = aPlus.charAt(l+1);
				if (plus == 'p' || plus == 'P') {
					plus = aPlus.charAt(l+2);
					if (plus == 'l' || plus == 'L') {
						plus = aPlus.charAt(l+3);
						if (plus == 'u' || plus == 'U') {
							plus = aPlus.charAt(l+4);
							if (plus == 's' || plus == 'S') {
								// If there's a form of 'APLUS', increase count by 1
								numAPlus = numAPlus + 1;
							}
						}
					}
				}
			}
		}
		// If the number of aPlus is more than 1, print 'yes'.
		if (numAPlus > 1) {
			System.out.println("yes");
		}
		// Otherwise, print 'no'.
		else {
			System.out.println("no");
		}
			
		
		return aPlus;
	}
	
	// This is the same function using different methods than the function above
	public String existAPlus(String APlus) {
		// This variable holds the number of 'aplus' in the string'
		int numAPlus = 0;
		// For the length of the string 'APlus':
		for (int l = 0; l < APlus.length(); l++) {
			// If the character + 4 more characters is less than the length of the string 'APlus':
			if (l + 4 < APlus.length()) {
				// The string 'shortA' is a substring from the character at 'l' until 'l+5'.
				String shortA = APlus.substring(l, l+5);
				// If this string 'shortA' contains 'aplus':
				if (shortA.contains("aplus") == true) {
					// The number of 'aplus' increases by one.
					numAPlus = numAPlus + 1;
				}
			}
			// Otherwise, break out of the function.
			else {
				break;
			}
		}
		// Print yes or no depending on the number of 'aplus'.
		if (numAPlus > 1) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		
		return APlus;
	}
}
