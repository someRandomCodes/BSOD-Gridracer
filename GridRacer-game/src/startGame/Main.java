package startGame;

import java.awt.Container;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JProgressBar;

import settingMenue.Panel_Sounds;
/**
 * This class starts the game.
 * 
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
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
	
	/*
	 * creates 2 audio streams with different wav files
	 * streams one of those if music is turned on in settings in a while loop
	 */
	public static  void backGroundMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		File file = new File("src//assets//sounds//baba.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		
		File file2 = new File("src//assets//sounds//baba2.wav");
		AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
		Clip clip2 = AudioSystem.getClip();
		clip2.open(audioStream2);
		FloatControl gainControl2 = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);

		while (!(Panel_Sounds.a == 5)) {
			switch(Panel_Sounds.a) {
			case(1):clip2.stop();
					gainControl.setValue(Panel_Sounds.volume()); clip.loop(Clip.LOOP_CONTINUOUSLY);
			break;
			case(2):clip.stop(); clip.setMicrosecondPosition(0);
			break;
			case(3):clip.stop(); clip.setMicrosecondPosition(0);
					gainControl2.setValue(Panel_Sounds.volume()); clip2.loop(Clip.LOOP_CONTINUOUSLY);
			}
		}
		
	}
}
