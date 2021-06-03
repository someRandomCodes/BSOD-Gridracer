package menue;

import java.awt.Desktop;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;

import javax.swing.JButton;
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
	
	private static final long serialVersionUID = -715260095579860078L;

	public Panel_MainMenue() {
		
		this.setPreferredSize(new Dimension(1280, 640));
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
		
		this.add(btn_StartSingleplayer);
		this.add(btn_StartMultiplayer);
		this.add(btn_CharacterSettings);
		this.add(btn_Settings);
		this.add(btn_Website);	
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
	}
    
    private void btn_StartSingleplayer_clicked() {
		Snake.main(null);;
    }
    
    private void  btn_StartMultiplayer_clicked() throws RemoteException {
    	new MultiplayerGame();
    	new RMIServer();
    }
    
    private void btn_CharacterSettings_clicked() {
		this.setVisible(false);
		this.getParent().add(p_characterMenue);
		p_characterMenue.setVisible(true);
    }
    
    private void btn_Settings_clicked() {
		this.setVisible(false);
		this.getParent().add(p_settingMenue);
		p_settingMenue.setVisible(true);
    }
}
