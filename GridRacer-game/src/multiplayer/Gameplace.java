package multiplayer;

import java.awt.Color;

import javax.swing.JLabel;

public class Gameplace extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2937602049742630401L;

	Gameplace() {
		this.setBackground(Color.cyan);
		this.setOpaque(true);
		this.setText(" ");
	}
	
	public void drawBorder() {
		this.setBackground(Color.black);
		this.setOpaque(true);
	}
}
