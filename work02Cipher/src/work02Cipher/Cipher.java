package work02Cipher;
//import java.lang.reflect.Array;

public class Cipher {

	public static void main(String[] args) {
		/*CipherInitial caesar = new CipherInitial();
		caesar.setAlpha();
		*/
		CipherInitial caesar = new CipherInitial();
		caesar.setAlpha("abcdefghjiklmnopqrstuvwxyz");
		
	}

}

class CipherInitial {
	
	private CharSequence alphabet;
	private char[] alphaArray;
	
	public CipherInitial(){
	}
	
	public void setAlpha(CharSequence array) {
		alphabet = array;
		alphaArray = new char[alphabet.length()];
		for (int i = 0; i < alphabet.length(); i++) {
			alphaArray[i] = alphabet.charAt(i);
		}
		System.out.println(alphaArray);
		
		return;
	}
	
	public CharSequence encode(StringBuilder chr, int move) {
		int totalMove = move;
		totalMove = totalMove % alphabet.length();
		for(int i = 0; i < chr.length(); i++) {
			
			while(chr.charAt(i) != ' ') {
				char k = chr.charAt(i);
				k = alphaArray[(chr.indexOf() + totalMove) % alphabet.length()];
				
				
				
			}
		}
		
		return chr;	
	}
	
	
	
	//This doesn't work; find a different function to use.
	/*public void setAlpha(Array array) {
		int alphabetLength = Array.getLength(array);
		char[] myAlpha = new char[alphabetLength];
		for (int i = 0; i <= alphabetLength; i++) {
			myAlpha[i] = Array.getChar(array, i);
		}
		System.out.println(array);
		return;
	}
	
	public void encode() {
		
	}
	*/
}
