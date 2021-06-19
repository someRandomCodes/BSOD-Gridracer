package settingMenue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Klassen beschreibung
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Panel_ClientSettings extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7767668161602340122L;
	Font font = new Font("Apple Casual", Font.ITALIC|Font.BOLD, 20);
	JLabel backgroundGif = new JLabel(new ImageIcon("src/assets/img/test3.gif"));
	
	
	JButton btn_back = new JButton();
	JTextField tf_ip = new JTextField("localhost");
	JTextField tf_port = new JTextField("1099");
	JButton btn_save = new JButton();
	
	/*
	 * creates a panel as a GIF background
	 */
	public Panel_ClientSettings() {
		setPreferredSize(new Dimension(1280, 640));
		setLayout(null);
		createComponents();
		addComponents();
		
		backgroundGif.setBounds(0,0,1280,640);
		backgroundGif.setLayout(null);
		backgroundGif.setVisible(true);
		this.add(backgroundGif);
	}

	
	/*
	 * gives the buttons a text and adds lambda expression for listener code 
	 */
	private void createComponents() {
		btn_back.setText("Back");
		btn_back.addActionListener(e -> btn_back_clicked());
		btn_save.setText("Save");
		btn_save.addActionListener(e -> btn_back_clicked());
	}
	
	/*
	 * adds the buttons to the background GIF panel and positions them using absolute positioning
	 * sets new colors to the buttons and a new font
	 */
	private void addComponents() {
		backgroundGif.add(btn_back);
		btn_back.setBounds(540,260,200,40);
		btn_back.setBackground(Color.black);
		btn_back.setFont(font);
		btn_back.setForeground(Color.white);
		
		tf_ip.setBounds(540,310,200,40);
		backgroundGif.add(tf_ip);
		
		tf_port.setBounds(540,360,200,40);
		backgroundGif.add(tf_port);	
		
		btn_save.setBounds(540,420,200,40);
		backgroundGif.add(btn_save);	
	}
	
	/*
	 * sets elements invisible, returns to main menu and replays Button click sound
	 */
	private void btn_back_clicked() {
		this.setVisible(false);
		this.getParent().getComponents()[0].setVisible(true);
		this.getParent().remove(this);
	    try {
			buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }

	/*
	 * creates audio streams with a wave file
	 * streams the file when method is called
	 */
	public static  void buttonClickSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		File file = new File("src//assets//sounds//buttonclick.wav");
		
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(Panel_Sounds.volume());
		clip.start();
		}
}
