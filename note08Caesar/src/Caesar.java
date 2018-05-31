import javax.swing.JOptionPane;

public class Caesar {

	public static void main(String[] args) {
		// Create an instance of a class called Cipher
		Cipher myCipher = new Cipher("abcdefghijklmnopqrstuvwxyz");
		
		// Call the method "encode" on the Cipher class
		// passing a String and a key to the encode method.
		// The method returns a string.
		myCipher.setAlpha("abcdefghijklmnopqrstuvwxyz.!,$%;:");
		System.out.println("Cipher Text = " + myCipher.encode("dog", 1));
		System.out.println("Cipher Text = " + myCipher.encode("z", 1));
		System.out.println("Cipher Text = " + myCipher.encode("what!?:", 10));
		System.out.println("Cipher Text = " + myCipher.encode("The quick brown fox",  18));
		
		// Hello World 
		JOptionPane.showMessageDialog(null, "Hello, World!");
		
		// Get input from user in a text dialog
		String answer = JOptionPane.showInputDialog("Enter your name:");
		System.out.println("The user entered: " + answer);
		JOptionPane.showMessageDialog(null, "The user entered: " + answer);
		
		// Get input from user in a drop-down selection menu
		Object [] options = { "option 1", "option 2", "option 3" };
		Object optionPicked = JOptionPane.showInputDialog(null, "Pick an option", "Option menu",
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		JOptionPane.showMessageDialog(null, "The option picked: " + optionPicked);
		
		// CaesarSA Caesar2 = new CaesarSA();
		// Caesar2.doit();
	}
}

