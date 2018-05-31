package note11Swin;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Swing2 extends JFrame {
	public Swing2() {
		// Call the base constructor
		super("My Window Title");
		// Notice that the "this" means the extended class, not the base class!
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Create a NORTH panel
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.BLUE);
		super.add(panel1, BorderLayout.NORTH);
		// Create a SOUTH panel
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.RED);
		super.add(panel2,  BorderLayout.SOUTH);
		// Create a CENTER panel
		JPanel centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(Color.YELLOW);
		super.add(centerPanel,  BorderLayout.CENTER);
		
		// Create a button - On NORTH
		JButton button1 = new JButton("button 1");
		button1.setBackground(Color.RED);
		panel1.add(button1);
		// Create a button - On NORTH
		JButton button2 = new JButton("button 2");
		button2.setBackground(Color.GREEN);
		panel1.add(button2);
		
		// Create a checkbox - On SOUTH
		JCheckBox cbox1 = new JCheckBox("Pizza");
		cbox1.setBackground(Color.CYAN);
		panel2.add(cbox1);

		// Create Labels - On CENTER
		JLabel label1 = new JLabel("Boring Label");
		JLabel label2 = new JLabel("Exciting label");
		JLabel label3 = new JLabel("Cha Cha Cha");
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20,40,10,30);
		gbc.gridx = 0;
		gbc.gridy = 0;
		centerPanel.add(label1, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		centerPanel.add(label2, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		centerPanel.add(label3, gbc);
		
		// Create an array of 10 buttons
		JButton[] buts = new JButton[10];
		String title = "Button Label: ";
		for (int i=0; i<10; i++) {
			buts[i] = new JButton(title + title.charAt(i));
		}
		
		// Add Buttons to the Center Panel
		int counter = 0;
		for (int y=1; y<3; y++) {
			for (int x=0; x<3 ;x++) {
				gbc.gridx = x;
				gbc.gridy = y;
				centerPanel.add(buts[counter], gbc);
				counter = counter + 1;
			}
		}

		setVisible(true);
	}
}
