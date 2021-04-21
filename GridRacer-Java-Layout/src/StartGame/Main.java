package StartGame;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Main{
	
	static JFrame frame = new JFrame();
	static JProgressBar LoadingBar = new JProgressBar();
	static Panel_startGame p_startGame = new Panel_startGame();

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
		
		p_startGame.setFocusable(true);
		
		load();
		frame.setVisible(false);
		MyFrame mainFrame = new MyFrame();
		mainFrame.add(p_startGame);
		mainFrame.pack();
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
	}
	
	public static void load() {
		while(LoadingBar.getValue() < 100) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LoadingBar.setValue(LoadingBar.getValue() + 1);
		}
	}
}
