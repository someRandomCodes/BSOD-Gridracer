package menue;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;

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

import characterSettings.Panel_CharacterMenue;
import multiplayer.MultiplayerGame;
import serverApplication.RMIServer;
import settingMenue.Panel_SettingMenue;
import singleplayer.Snake;


public class Panel_MainMenue extends JPanel {
	Panel_SettingMenue p_settingMenue = new Panel_SettingMenue();
	Panel_CharacterMenue p_characterMenue = new Panel_CharacterMenue();
	
	JButton btn_StartSingleplayer = new JButton("Singleplayer");
	JButton btn_StartMultiplayer = new JButton("Multiplayer");
	JButton btn_CharacterSettings = new JButton("Character");
	JButton btn_Settings = new JButton("Settings");
	JButton btn_Website = new JButton("Website");
	
	JLabel backgroundGif = new JLabel(new ImageIcon("src/assets/img/test3.gif"));
	
	private static final long serialVersionUID = -715260095579860078L;

	public Panel_MainMenue() {
		Font font = new Font("Apple Casual", Font.ITALIC|Font.BOLD, 20);
		this.setPreferredSize(new Dimension(1280, 640));
		
		backgroundGif.setBounds(1,1,1280,640);
		backgroundGif.setVisible(true);
		this.add(backgroundGif);
		
		btn_StartSingleplayer.addActionListener(e -> btn_StartSingleplayer_clicked());
		btn_StartMultiplayer.addActionListener(e -> {
			try {
				btn_StartMultiplayer_clicked();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btn_CharacterSettings.addActionListener(e -> btn_CharacterSettings_clicked());
		btn_Settings.addActionListener(e -> btn_Settings_clicked());
		btn_Website.addActionListener(e -> btn_website_clicked());
		
		backgroundGif.add(btn_StartSingleplayer);
		btn_StartSingleplayer.setBounds(540,260,200,40);
		btn_StartSingleplayer.setBackground(Color.black);
		btn_StartSingleplayer.setFont(font);
		btn_StartSingleplayer.setForeground(Color.white);
		
		backgroundGif.add(btn_StartMultiplayer);
		btn_StartMultiplayer.setBounds(540,320,200,40);
		btn_StartMultiplayer.setBackground(Color.black);
		btn_StartMultiplayer.setFont(font);
		btn_StartMultiplayer.setForeground(Color.white);
		
		backgroundGif.add(btn_CharacterSettings);
		btn_CharacterSettings.setBounds(540,380,200,40);
		btn_CharacterSettings.setBackground(Color.black);
		btn_CharacterSettings.setFont(font);
		btn_CharacterSettings.setForeground(Color.white);
		
		backgroundGif.add(btn_Settings);
		btn_Settings.setBounds(540,440,200,40);
		btn_Settings.setBackground(Color.black);
		btn_Settings.setFont(font);
		btn_Settings.setForeground(Color.white);
		
		backgroundGif.add(btn_Website);
		btn_Website.setBounds(540,500,200,40);
		btn_Website.setBackground(Color.black);
		btn_Website.setFont(font);
		btn_Website.setForeground(Color.white);
	}
	}
	
    private void btn_website_clicked() {
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
		    try {
				Desktop.getDesktop().browse(new URI("http://www.do7gt.de/"));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	    try {
			ButtonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    private void btn_StartSingleplayer_clicked() {
		Snake.main(null);;
    }
    
    private void  btn_StartMultiplayer_clicked() throws RemoteException {
    	new MultiplayerGame();
    	new RMIServer();
	    try {
			ButtonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void btn_CharacterSettings_clicked() {
		this.setVisible(false);
		this.getParent().add(p_characterMenue);
		p_characterMenue.setVisible(true);
	   	try {
			ButtonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void btn_Settings_clicked() {
		this.setVisible(false);
		this.getParent().add(p_settingMenue);
		p_settingMenue.setVisible(true);
	    	try {
			ButtonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public  void ButtonClickSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		File file = new File("src/assets/img/buttonclick.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue((float) +volume);
		clip.start();
	}
}
