package settingMenue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import startGame.MyFrame;

// Aman

public class Panel_SettingMenue extends JPanel {
	
	JButton btn_back = new JButton();
	JButton btn_sound = new JButton();
	JButton btn_updates = new JButton();
	JButton btn_doNotPress = new JButton();
	JButton btn_credits = new JButton();

	
	private static final long serialVersionUID = -715260095579860078L;

	public Panel_SettingMenue() {
		setPreferredSize(new Dimension(1280, 640));
		setLayout(new BorderLayout());
		createComponents();
		addComponents();
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
    	add(btn_back);
    	add(btn_sound);
    	add(btn_updates);
    	add(btn_doNotPress);
    	add(btn_credits);
    }
    
    
    private void btn_back_clicked() {
		this.setVisible(false);
		this.getParent().getComponents()[0].setVisible(true);
		this.getParent().remove(this);
    }
    
    private void btn_sound_clicked() {
    	
    }
    
    private void btn_updates_clicked() {
    	
    }
    
    private void btn_doNotPress_clicked() {
    	
    }
    
    private void btn_credits_clicked() {
    	MyFrame frame = new MyFrame(false);
    	frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    	frame.add(new Panel_Credits());
    	frame.setVisible(true);
    }
}
