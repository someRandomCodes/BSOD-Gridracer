package startGame;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import characterSettings.Loadsave;

public class Main{
	private static JProgressBar LoadingBar = new JProgressBar();
	static MyFrame mainFrame = new MyFrame(true);
 
	/*
	 * Method load let the loading bar get to 100 percent
	 * by let the thread sleep
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
		Container frameContent = mainFrame.getContentPane();
		Panel_startGame p_startGame = new Panel_startGame();
		
		//test save
		Loadsave.savePlayer("Johannes", 581, '3');
		
		LoadingBar.setValue(0);
		LoadingBar.setStringPainted(true);
		
		mainFrame.setSize(400,200);
		frameContent.add(LoadingBar);
		mainFrame.setVisible(true);	
		
		load();
		
		p_startGame.setFocusable(true);
		
		frameContent.remove(LoadingBar);
		frameContent.add(p_startGame);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		
		try {
			backGroundMusic();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  void backGroundMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		File file = new File("src/assets/img/baba.wav");
		
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue((float) -40);
		clip.loop(clip.LOOP_CONTINUOUSLY);
		
		
	}
}
