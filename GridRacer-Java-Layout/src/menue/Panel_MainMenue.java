package menue;

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;


public class Panel_MainMenue extends JPanel implements ActionListener {
		JButton btn_Start = new JButton("newPanel");
		JPanel p_mainMenue = new JPanel();
	
	private static final long serialVersionUID = -715260095579860078L;

	public Panel_MainMenue() {
		this.setPreferredSize(new Dimension(1280, 640));
		this.add(btn_Start);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start Game")) {
			this.remove(btn_Start);
			this.add(p_mainMenue);
		}
		
	}
}
