package multiplayer;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * This class creates the Standard "Gameplace".
 * This is used for the Game to "draw" lines.
 * 
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Gameplace extends JLabel {
	final Color background = new Color(0x240055);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2937602049742630401L;

	/*
	 * Create the standard place(jlabel) for the Grid
	 */
	Gameplace() {
		this.setBackground(background);
		this.setOpaque(true);
		this.setText(" ");
	}
	
	/*
	 * Returns the standard background color
	 * @return Color
	 */
	public Color getCheckColor() {
		return background;
	}
	
	/*
	 * Set the background to black
	 * (the border)
	 */
	public void drawBorder() {
		this.setBackground(Color.black);
		this.setOpaque(true);
	}
	
	/*
	 * Set the background to 0xfcb400 
	 * (The Player-line)
	 */
	public void drawSelf() {
		this.setBackground(new Color(0xfcb400));
		this.setOpaque(true);
	}
	
	/*
	 * Set the background to 0xfc6c55
	 *(The Enemy-line)
	 */
	public void drawEnemy() {
		this.setBackground(new Color(0xfc6c55));
		this.setOpaque(true);
	}
	
	/*
	 * Set the Background back to standard
	 */
	public void resetField() {
		this.setBackground(background);
		this.setOpaque(true);
		this.setText(" ");
	}
}
