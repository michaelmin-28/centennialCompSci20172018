package prj02_Calculator;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JFrame;

public class Calc {
	
	public static void main(String[] args) {
		Calc calculator = new Calc();
	}
	
	public Calc() {
		/* Create the Swing panels for the calculator */
		Frame frame = new JFrame();
		Screen screen = new Screen();
		
		/* Add the Swing panels to the frame */ 
		frame.add(screen, BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);
		
		// Test harness for now - delete later!
		screen.postDigit("8");
		screen.postDigit("5");
		screen.postValue(3.1415926);
		System.out.println(screen.getValue());
	}
}