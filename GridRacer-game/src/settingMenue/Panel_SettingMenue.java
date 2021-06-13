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

// Aman

public class Panel_SettingMenue extends JPanel {
	
	JButton btn_back = new JButton();
	JButton btn_sound = new JButton();
	JButton btn_updates = new JButton();
	JButton btn_doNotPress = new JButton();
	JButton btn_credits = new JButton();
	
	JLabel backgroundGif = new JLabel(new ImageIcon("src/assets/img/test3.gif"));
	Font font = new Font("Apple Casual", Font.ITALIC|Font.BOLD, 20);
	int volume = -20;

	
	private static final long serialVersionUID = -715260095579860078L;

	public Panel_SettingMenue() {
		setPreferredSize(new Dimension(1280, 640));
		createComponents();
		addComponents();
		
		backgroundGif.setBounds(1,1,1280,640);
		backgroundGif.setVisible(true);
		this.add(backgroundGif);
	}
	
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
    
    private void btn_sound_clicked() {
    	try {
			buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void btn_updates_clicked() {
    	try {
			buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void btn_doNotPress_clicked() {
    	String eingabe = JOptionPane.showInputDialog("");
    	if (eingabe.equals("BSOD")) {
    		int newScore = Integer.parseInt(JOptionPane.showInputDialog("Score"));
    		Loadsave.savePlayer(Loadsave.loadName(), newScore, '4');
    	}
	    try {
			buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void btn_credits_clicked() {
    	MyFrame frame = new MyFrame(false);
    	frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    	frame.add(new Panel_Credits());
    	frame.setVisible(true);
	    try {
			buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public  void buttonClickSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		File file = new File("src/assets/img/buttonclick.wav");
		
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue((float) +volume);
		clip.start();
		
		
	}
}
