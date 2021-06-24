package menue;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;


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
import settingMenue.Panel_Sounds;



/**
 * this class displays the main menue
 * 
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Panel_MainMenue extends JPanel {
	private Panel_SettingMenue p_settingMenue = new Panel_SettingMenue();
	private Panel_CharacterMenue p_characterMenue = new Panel_CharacterMenue();
	
	private JButton btn_StartMultiplayer = new JButton("Multiplayer");
	private JButton btn_CharacterSettings = new JButton("Character");
	private JButton btn_Settings = new JButton("Settings");
	private JButton btn_Website = new JButton("Website");
	
	private JLabel backgroundGif = new JLabel(new ImageIcon("src/assets/img/title.gif"));
	
	private static final long serialVersionUID = -715260095579860078L;

	/*
	 * creates a panel as a GIF background and puts the buttons on it and positions them using absolute positioning and also creates a new font for the buttons
	 */
	public Panel_MainMenue() {
		Font font = new Font("Apple Casual", Font.ITALIC|Font.BOLD, 20);
		setPreferredSize(new Dimension(1280, 640));
		
		backgroundGif.setBounds(1,1,1280,640);
		backgroundGif.setVisible(true);
		add(backgroundGif);
		
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
	
	/*
	 * allows to launch associated applications registered on the native desktop and to open up our URI and replays the buttonclick sound
	 */
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
	    	Panel_Sounds.buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * starts MultiplayerGame and RMIServer method and replays the buttonclick sound
	 */
    private void  btn_StartMultiplayer_clicked() throws RemoteException {
    	new MultiplayerGame();
    	new RMIServer();
	    try {
	    	Panel_Sounds.buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/*
	 * sets Settings_MainMenue panel invisible, opens CharacterSettings panel, sets it visible and replays the buttonclick sound
	 */
    private void btn_CharacterSettings_clicked() {
		setVisible(false);
		getParent().add(p_characterMenue);
		
		p_characterMenue.loadCharSettings();
		p_characterMenue.setVisible(true);
		
	   	try {
	   		Panel_Sounds.buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/*
	 * sets Settings_MainMenue panel invisible, opens Settings panel, sets it visible and replays the buttonclick sound
	 */
    private void btn_Settings_clicked() {
		setVisible(false);
		getParent().add(p_settingMenue);
		
		p_settingMenue.setVisible(true);
		
	    	try {
			Panel_Sounds.buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
