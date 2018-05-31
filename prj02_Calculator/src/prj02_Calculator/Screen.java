package prj02_Calculator;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * SCREEN - manage the calculator's display
 */
public class Screen extends JPanel {
	private JLabel display;
	
	/* Constructor - Create the JLabel*/
	public Screen() {
		System.out.println("Create Screen");
		display = new JLabel("0");
		super.add(display);
	}
	
	/* postDigit() -Display a single digit by concatenating */ 
	public void postDigit(String digit) {
		String displayLine = display.getText();

		// What happens if 0 is on the screen??
		if (displayLine == "0") {
			display.setText(digit);
		}
		else {
			display.setText(displayLine + digit);
		}
	}
	
	/* postValue() - Display an entire value from a calculation */
	public void postValue(double value) {
		display.setText(Double.toString(value));
	}
	
	/* getValue() - Provide access to the current value on the display */
	public double getValue() {
		String displayLine = display.getText();
		double screenValue = Double.parseDouble(displayLine);
		return(screenValue);
	}
}