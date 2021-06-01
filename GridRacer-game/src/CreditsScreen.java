package Credits;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditsScreen extends JPanel implements ActionListener{
	Timer creditTimer = new Timer(20,this);
	String text;
	int textY =  600;
	public CreditsScreen() {
		JFrame window = new JFrame ("Credits");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.add(this);
		window.setVisible(true);
		this.setBackground(Color.black);
		
		text = "GRID RACER wird Ihnen präsentiert von...\n\n"
				+ "B.S.O.D\n"
				+"THOMAS\n"
				+"LUKAS\n"
				+"AMAN\n\n"
				+"Danke fürs Zocken";
		
		creditTimer.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		g2d.setColor(Color.white);
		//g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		int y = textY;
		
		for(String line: text.split("\n")) {
			
			int stringLength =(int)g2d.getFontMetrics().getStringBounds(line, g2d).getWidth();
			int x = getWidth()/2 -stringLength/2;
			g2d.drawString(line, x, y+=28);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(textY);
		textY--;
		if (textY < -170) {
			creditTimer.stop();
		}
		repaint();
		
	}
}
