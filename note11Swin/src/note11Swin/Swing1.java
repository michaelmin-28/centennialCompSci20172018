package note11Swin;

import javax.swing.JFrame;

public class Swing1 extends JFrame {
	public Swing1() {
		// Call the base constructor
		super("My Window Title");
		// Notice that the "this" means the extended class, not the base class!
		super.setSize(800, 600);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	public void setSize(int w, int h) {
		System.out.println("Wrong function Buck Wheat!  I don't want to write my own!");
	}
}
