package multiplayer;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel_TheGame extends JPanel {
	private int gameboardSizeW = 80;
	private int gameboardSizeH = 60;
	private int gameboardSize = gameboardSizeH * gameboardSizeW;
	private boolean gamerun = true;
	private char moveSelfDirektion = 'd';
	private movings thread1 = new movings();
	private Gameplace[] place = new Gameplace[gameboardSize];

	/**
	 * 
	 */
	private static final long serialVersionUID = 5438164405065722657L;

	Panel_TheGame() {
		this.setLayout(new GridLayout(gameboardSizeH, gameboardSizeW));
		this.setFocusable(true);
		this.addKeyListener(new MovingListener());
		
		for (int i = 0; i < gameboardSize ;i++) {
			place[i] = new Gameplace();
			this.add(place[i]);	
			System.out.println((i+1) + "Felder erstellt");
		}
		
		// top border
		for (int i = 0; i<gameboardSizeW ; i++) {
			place[i].drawBorder();
		}
		
		// bottom border
		for (int i = gameboardSize-1; i >= gameboardSize-gameboardSizeW ; i--) {
			place[i].drawBorder();
		}
		
		// left border
		for (int i = gameboardSizeW ; i < gameboardSize; i += gameboardSizeW) {
			place[i].drawBorder();
		}
		
		// right border
		for (int i = (gameboardSizeW * 2) -1  ; i < gameboardSize; i += gameboardSizeW) {
			place[i].drawBorder();
		}
		
		thread1.start();
		
	}
	
	private class movings extends Thread {
		
		@SuppressWarnings("deprecation")
		public void run() {
			int i = 580;
			System.out.println("voher");
			while(gamerun) {
				try {
					System.out.println("voher");
					Thread.sleep(40);
					System.out.println("nachher");
					switch(moveSelfDirektion) {
					case 'w':
			            i-= gameboardSizeW;
						if(place[i].getBackground() == Color.black) {
							JOptionPane.showMessageDialog(null, "colide");							
							thread1.stop();
						}
			            place[i].drawBorder();
						break;
					case 'a':
						i-=1;
						if(place[i].getBackground() == Color.black) {
							JOptionPane.showMessageDialog(null, "colide");							
							thread1.stop();
						}
			            place[i].drawBorder();
						break;
					case 's':
						i+= gameboardSizeW;
						if(place[i].getBackground() == Color.black) {
							JOptionPane.showMessageDialog(null, "colide");
							thread1.stop();
						}
			            place[i].drawBorder();
						break;
					case 'd':
						i+=1;
						if(place[i].getBackground() == Color.black) {
							JOptionPane.showMessageDialog(null, "colide");							
							thread1.stop();
						}
			            place[i].drawBorder();
						break;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	private class MovingListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println(e.getKeyChar());
			if (e.getKeyChar() == 'w' 
					|| e.getKeyChar() == 'a' 
					|| e.getKeyChar() == 's' 
					|| e.getKeyChar() == 'd') moveSelfDirektion = e.getKeyChar();
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
}
