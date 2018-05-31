package frqTesting01;

public class HiddenWord {
	String word;
	public HiddenWord(String line) {
		this.word = line;
	}
	public String getHint(String str) {
		String wordholder = "";
		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			if (word.charAt(i) == letter) {
				wordholder = wordholder + letter;
			}
			else if (word.indexOf(letter) > -1) {
				wordholder = wordholder + "+";
			}
			else {
				wordholder = wordholder + "*";
			}
		}
		System.out.println(wordholder);
		return wordholder;
	}
}
