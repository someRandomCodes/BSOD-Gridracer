package multiplayer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Klassen beschreibung
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Gameplace extends JLabel {
	Color background = new Color(0x240055);
	/**
	 * 
	 */
	private static final long serialVersionUID = -2937602049742630401L;

	/*
	 * 
	 */
	Gameplace() {
		this.setBackground(background);
		this.setOpaque(true);
		this.setText(" ");
	}
	
	public Color getCheckColor() {
		return background;
	}
	
	/*
	 * 
	 */
	public void drawBorder() {
		this.setBackground(Color.black);
		this.setOpaque(true);
	}
	
	/*
	 * 
	 */
	public void drawSelf() {
		this.setBackground(new Color(0xfcb400));
		this.setOpaque(true);
	}
	
	/*
	 * 
	 */
	public void drawEnemy() {
		this.setBackground(new Color(0xfc6c55));
		this.setOpaque(true);
	}
	
	/*
	 * 
	 */
	public void resetField() {
		this.setBackground(background);
		this.setOpaque(true);
		this.setText(" ");
	}
}
