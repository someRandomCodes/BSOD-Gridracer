package settingMenue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Klassen beschreibung
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Panel_Credits extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1328399414907651111L;
	
	Timer creditTimer = new Timer(20,this);
	String text;
	int textY =  1000;
	Color myColor = new Color(1, 84, 153);
	
	/*
	 * 
	 */
	public Panel_Credits() {
		this.setPreferredSize(new Dimension(1280, 400));
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(myColor);
		
		text = "GRID RACER wird Ihnen prÃ¤sentiert von...\n\n"
				+ "B.S.O.D\n"
				+"THOMAS\n"
				+"LUKAS\n"
				+"AMAN\n\n"
				+"Danke fürs Zocken";
		
		creditTimer.start();
		
		JLabel bsodlabel1 = new JLabel();
		bsodlabel1.setText(":(");
		bsodlabel1.setVisible(true);
		bsodlabel1.setFont(new Font("ARIAL",100,100));
		bsodlabel1.setForeground(Color.white);
		bsodlabel1.setBounds(200,100,400,400);
		
		JLabel bsodlabel2 = new JLabel();
		bsodlabel2.setText("Your PC ran into a problem and needs to restart. We´re ");
		bsodlabel2.setVisible(true);
		bsodlabel2.setFont(new Font("ARIAL",100,30));
		bsodlabel2.setForeground(Color.white);
		bsodlabel2.setBounds(200,200,1100,400);
		
		JLabel bsodlabel3 = new JLabel();
		bsodlabel3.setText("just collecting some error info, and then we´ll restart for");
		bsodlabel3.setVisible(true);
		bsodlabel3.setFont(new Font("ARIAL",100,30));
		bsodlabel3.setForeground(Color.white);
		bsodlabel3.setBounds(200,240,1100,400);
		
		JLabel bsodlabel4 = new JLabel();
		bsodlabel4.setText("you");
		bsodlabel4.setVisible(true);
		bsodlabel4.setFont(new Font("ARIAL",100,30));
		bsodlabel4.setForeground(Color.white);
		bsodlabel4.setBounds(200,280,1100,400);
		
		this.add(bsodlabel1);
		this.add(bsodlabel2);
		this.add(bsodlabel3);
		this.add(bsodlabel4);
		
		
	}
	
	/*
	 * 
	 */
	public void paintComponent(Graphics g) {
	super.paintComponent(g); 
	
	Graphics2D g2d = (Graphics2D)g;
	
	g2d.setFont(new Font("Times New Roman", Font.PLAIN, 40));
	g2d.setColor(Color.black);
	
	int y = textY;
	
	for(String line: text.split("\n")) {
		
		int stringLength =(int)g2d.getFontMetrics().getStringBounds(line, g2d).getWidth();
		int x = getWidth()/2 -stringLength/2;
		g2d.drawString(line, x, y+=50);
		}
	}
	
		/*
		 * 
		 */
	public void actionPerformed(ActionEvent e) {
		System.out.println(textY);
		textY--;
		if (textY < -170) {
			creditTimer.stop();
		}
		repaint();
	}

}
