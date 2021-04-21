package menue;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Character_Settings.Panel_CharacterMenue;
import settingMenue.Panel_SettingMenue;


public class Panel_MainMenue extends JPanel {
	Panel_SettingMenue p_settingMenue = new Panel_SettingMenue();
	Panel_CharacterMenue p_characterMenue = new Panel_CharacterMenue();
	
	JButton btn_StartSingleplayer = new JButton();
	JButton btn_StartMultiplayer = new JButton();
	JButton btn_CharacterSettings = new JButton();
	JButton btn_Settings = new JButton();

	
	private static final long serialVersionUID = -715260095579860078L;

	public Panel_MainMenue() {
		this.setPreferredSize(new Dimension(1280, 640));
		createComponents();
		addComponents();
	}
	
	public void createComponents() {
		btn_StartSingleplayer.setText("Singleplayer");
		btn_StartSingleplayer.addActionListener(e -> btn_StartSingleplayer_clicked());
		
		btn_StartMultiplayer.setText("Multiplayer");
		btn_StartMultiplayer.addActionListener(e -> btn_StartMultiplayer_clicked());
		
		btn_CharacterSettings.setText("Character");
		btn_CharacterSettings.addActionListener(e -> btn_CharacterSettings_clicked());
		
		btn_Settings.setText("Settings");
		btn_Settings.addActionListener(e -> btn_Settings_clicked());
	}
	
    private void addComponents() {  
		this.add(btn_StartSingleplayer);
		this.add(btn_StartMultiplayer);
		this.add(btn_CharacterSettings);
		this.add(btn_Settings);
    }
    
    
    private void btn_StartSingleplayer_clicked() {
    	JOptionPane.showMessageDialog(null, "Als ob das schon geht!");
    }
    
    private void  btn_StartMultiplayer_clicked() {
    	JOptionPane.showMessageDialog(null, "Als ob das schon geht!");
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
