package settingMenue;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

// Aman
public class Panel_Credits extends JPanel {
	JButton btn_back = new JButton();
	
	public Panel_Credits() {
		this.setPreferredSize(new Dimension(1280, 400));
		this.setVisible(true);
		createComponents();
		addComponents();
	}
	
	public void createComponents() {
		btn_back.setText("Bgehhe");
	}
	
    private void addComponents() {  
		this.add(btn_back);
    }
}
