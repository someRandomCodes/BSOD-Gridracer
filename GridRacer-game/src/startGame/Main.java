package startGame;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Main{
	
	private static JFrame frame = new JFrame();
	private static JProgressBar LoadingBar = new JProgressBar();
	private static Panel_startGame p_startGame = new Panel_startGame();
	
	/*
	 * method load let the loading bar get to 100 percent
	 * and creates the player
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
	
	public static void main(String[] args) {
		
		LoadingBar.setValue(0);
		LoadingBar.setStringPainted(true);
		
		frame.add(LoadingBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Unnecessary loading Screen");
		frame.setSize(420, 98);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
		load();
		
		
		p_startGame.setFocusable(true);
		
	
		frame.setVisible(false);
		MyFrame mainFrame = new MyFrame();
		mainFrame.add(p_startGame);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		
		Character player1 = new Character
				(Loadsave.loadName(),
				 Loadsave.loadScore(),
				 Loadsave.loadCharacter());
		
		System.out.println("Spielername: " + player1.getName());
		System.out.println("Score: " +player1.getScore());
		System.out.println("character: " +player1.getCharacter());
	}
}
