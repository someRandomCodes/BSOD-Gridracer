package startGame;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Main{
	private static JProgressBar LoadingBar = new JProgressBar();
	static JFrame mainFrame = new JFrame();
 
	/*
	 * Method load let the loading bar get to 100 percent
	 * and creates the player.
	 */
	private static void load() {
		while(LoadingBar.getValue() < 100) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LoadingBar.setValue(LoadingBar.getValue() + 1);
		}
		
	}
	
	/*
	 * Main method, starts the whole Game.
	 * Create the first Frame and add the first Panel.
	 */
	public static void main(String[] args) {
		LoadingBar.setValue(0);
		LoadingBar.setStringPainted(true);
		
		mainFrame.add(LoadingBar);
		mainFrame.setSize(400,200);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Unnecessary loading Screen");
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);	
		
		load();
		
		Panel_startGame p_startGame = new Panel_startGame();
		p_startGame.setFocusable(true);
		
		mainFrame.remove(LoadingBar);
		mainFrame.setTitle("GridRacer by B.S.O.D");
		mainFrame.add(p_startGame);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
	}
}
