package startGame;

import javax.swing.JFrame;

public class MyFrame extends JFrame{


	/**
	 * creates the standard Frame
	 */
	private static final long serialVersionUID = 140453441694353650L;
	
	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("GridRacer by B.S.O.D");
		this.setResizable(false);
		this.setVisible(true);
	}	
}