package settingMenue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File;
import java.io.IOException;

import characterSettings.Loadsave;
import startGame.MyFrame;

/**
 * Klassen beschreibung
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Panel_SettingMenue extends JPanel {
	Panel_Sounds p_sound = new Panel_Sounds();
	SoundSettings myVol = new SoundSettings();
	
	JButton btn_back = new JButton();
	JButton btn_sound = new JButton();
	JButton btn_updates = new JButton();
	JButton btn_doNotPress = new JButton();
	JButton btn_credits = new JButton();
	
	JLabel backgroundGif = new JLabel(new ImageIcon("src/assets/img/test3.gif"));
	Font font = new Font("Apple Casual", Font.ITALIC|Font.BOLD, 20);
	

	
	private static final long serialVersionUID = -715260095579860078L;

	/*
	 * uses methods createComponents and addComponents to create and add buttons and creates a label for the GIF background
	 */
	public Panel_SettingMenue() {
		setPreferredSize(new Dimension(1280, 640));
		createComponents();
		addComponents();
		
		backgroundGif.setBounds(1,1,1280,640);
		backgroundGif.setVisible(true);
		this.add(backgroundGif);
	}
	
	/*
	 * adds a text to the buttons and uses lambda expression for listener code
	 */
	public void createComponents() {
		btn_back.setText("Back");
		btn_back.addActionListener(e -> btn_back_clicked());
		btn_sound.setText("Sound");
		btn_sound.addActionListener(e -> btn_sound_clicked());
		btn_updates.setText("Updates");
		btn_updates.addActionListener(e -> btn_updates_clicked());
		btn_doNotPress.setText("don't press this button");
		btn_doNotPress.addActionListener(e -> btn_doNotPress_clicked());
		btn_credits.setText("Credits");
		btn_credits.addActionListener(e -> btn_credits_clicked());
	}
	
	/*
	 * adds the buttons in label, puts a new font and colors and positions them using absolute positioning
	 */
    private void addComponents() {  
		backgroundGif.add(btn_back);
		btn_back.setBounds(540,260,200,40);
		btn_back.setBackground(Color.black);
		btn_back.setFont(font);
		btn_back.setForeground(Color.white);
			
		backgroundGif.add(btn_sound);
		btn_sound.setBounds(540,320,200,40);
		btn_sound.setBackground(Color.black);
		btn_sound.setFont(font);
		btn_sound.setForeground(Color.white);
			
		backgroundGif.add(btn_updates);
		btn_updates.setBounds(540,380,200,40);
		btn_updates.setBackground(Color.black);
		btn_updates.setFont(font);
		btn_updates.setForeground(Color.white);
			
		backgroundGif.add(btn_doNotPress);
		btn_doNotPress.setBounds(540,440,200,40);		 							
		btn_doNotPress.setBackground(Color.black);
		btn_doNotPress.setFont(font);
		btn_doNotPress.setForeground(Color.white);
			
		backgroundGif.add(btn_credits);	
		btn_credits.setBounds(540,500,200,40);
		btn_credits.setBackground(Color.black);
		btn_credits.setFont(font);
		btn_credits.setForeground(Color.white);
    }
    
	/*
	 * 
	 */
    private void btn_back_clicked() {
		this.setVisible(false);
		this.getParent().getComponents()[0].setVisible(true);
		this.getParent().remove(this);
	    try {
	    	Panel_Sounds.buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/*
	 * sets Settings_Menue panel invisible, opens Sounds panel and sets it visible and replays the buttonclick sound
	 */
    private void btn_sound_clicked() {
    	try {
    		Panel_Sounds.buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVisible(false);
		this.getParent().add(p_sound);
		p_sound.setVisible(true);
    }
    
	/*
	 * 
	 */
    private void btn_updates_clicked() {
    	try {
    		Panel_Sounds.buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/*
	 * opens a JOptionPane 
	 */
    private void btn_doNotPress_clicked() {
    	String eingabe = JOptionPane.showInputDialog("");
    	if (eingabe.equals("BSOD")) {
    		int newScore = Integer.parseInt(JOptionPane.showInputDialog("Score"));
    		Loadsave.savePlayer(Loadsave.loadName(), newScore, '4');
    	}
	    try {
	    	Panel_Sounds.buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/*
	 * opens a new frame with maximized size and adds the Credits panel to it and replays the buttonclick sound
	 */
    private void btn_credits_clicked() {
    	MyFrame frame = new MyFrame(false);
    	frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    	frame.add(new Panel_Credits());
    	frame.setVisible(true);
	    try {
	    	Panel_Sounds.buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
