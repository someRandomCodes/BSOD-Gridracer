package startGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import menue.Panel_MainMenue;

/**
 * This class is the first panel to see
 * 
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Panel_startGame extends JPanel implements ActionListener {
	private static final long serialVersionUID = -715260095579860078L;
	int backGroundMoveLeft = 0;
	boolean leftMove = true;
	
	Panel_MainMenue p_mainMenue = new Panel_MainMenue();
	Image img;
	Timer timer;
	String welc = "Welcome to";
	String gridRacer = "GRIDRACER";

	/*
	 * constructor add the keylistener keyadapter
	 * and do some other stuff
	 */
	Panel_startGame() {
		this.setPreferredSize(new Dimension(1280, 640));
		this.setLayout(null);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				loadMenue();
			}	
		});
		this.setFocusable(true);

		img = new ImageIcon("src/assets/img/background_start.png").getImage();
		
		timer = new Timer(200, this);
		timer.start();
	}
	
	/*
	 * paints the background
	 */
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(img, -backGroundMoveLeft, 0, null);
		g2D.setPaint(Color.GRAY);
		g2D.setFont(new Font("MV Boli", Font.BOLD, 50));
		g2D.drawString(welc, 440, 80);
		g2D.setFont(new Font("Ink Free", Font.BOLD, 50));
		g2D.drawString(gridRacer, 440, 130);
		g2D.setFont(new Font("MV Boli", Font.ITALIC, 30));	
		g2D.drawString("press any key to continue", 405, 300);
	}
	
	/*
	 * loads the menue and remove this class/panel
	 */
	public void loadMenue() {
		this.setVisible(false);
		this.removeAll();
		this.getParent().add(p_mainMenue);
		this.getParent().remove(this);
	}


	/*
	 * this method (action performed listen to the timer
	 * and move the background image
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (backGroundMoveLeft >= 5000) {
			leftMove = false;
		} else if (backGroundMoveLeft <= 0) {
			leftMove = true;
		}
		if (leftMove) {
			backGroundMoveLeft = backGroundMoveLeft + 10;
		} else {
			backGroundMoveLeft = backGroundMoveLeft - 10;
		}
		repaint();
	}
}
