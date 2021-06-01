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
		btn_back.setText("Back");
		btn_back.addActionListener(e -> btn_back_clicked());
	}
	
    private void addComponents() {  
		this.add(btn_back);
    }
  	 private void btn_back_clicked() {
  		this.setVisible(false);
  		this.getParent().getComponents()[0].setVisible(true);
  		this.getParent().remove(this);
      }
}
